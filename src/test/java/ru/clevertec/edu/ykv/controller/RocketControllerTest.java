package ru.clevertec.edu.ykv.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.clevertec.edu.ykv.common.RocketType;
import ru.clevertec.edu.ykv.domain.Rocket;
import ru.clevertec.edu.ykv.exception.RocketNotFoundException;
import ru.clevertec.edu.ykv.service.RocketService;
import ru.clevertec.edu.ykv.util.RocketTestData;
import ru.clevertec.edu.ykv.util.RocketTestDataByType;
import ru.clevertec.edu.ykv.util.RocketTestDataEndedTestPeriod;

import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RocketController.class)
class RocketControllerTest {

    @MockBean
    private RocketService rocketService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Nested
    class Create {
        @Test
        void shouldCreateRocket() throws Exception {
            //given
            Rocket rocket = RocketTestData.getRocketForCreate();
            Rocket createdRocket = RocketTestData.getFillRocket();
            String content = objectMapper.writeValueAsString(rocket);

            when(rocketService.createRocket(rocket)).thenReturn(createdRocket);

            //when, then
            mockMvc.perform(post("/api/v1/rockets")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(content)
                    )
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id").value(RocketTestData.ROCKET_UUID.toString()))
                    .andExpect(jsonPath("$.name").value(RocketTestData.ROCKET_NAME))
                    .andExpect(jsonPath("$.rocketType").value(RocketTestData.ROCKET_TYPE.toString()))
                    .andExpect(jsonPath("$.country").value(RocketTestData.ROCKET_COUNTRY))
                    .andExpect(jsonPath("$.startTestPeriod").value(RocketTestData.CURRENT_DATE.toString()))
                    .andExpect(jsonPath("$.endTestPeriod").value(RocketTestData.CURRENT_DATE_PLUS_MONTH.toString()))
            ;

            verify(rocketService, times(1)).createRocket(rocket);

        }
    }


    @Test
    void shouldGetAllRocket() throws Exception {
        //given
        List<Rocket> rockets = RocketTestData.getListWithFiveRockets();
        when(rocketService.getRockets()).thenReturn(rockets);

        //when, then
        mockMvc.perform(get("/api/v1/rockets"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(5));

        verify(rocketService, times(1)).getRockets();
    }

    @Nested
    class GetById {
        @Test
        void shouldGetRocketById() throws Exception {
            //given
            UUID rocketId = RocketTestData.ROCKET_UUID;
            Rocket rocket = RocketTestData.getFillRocket();
            when(rocketService.getRocketById(rocketId)).thenReturn(rocket);

            //when, then
            mockMvc.perform(get("/api/v1/rockets/{id}", rocketId))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$").value(IsNull.notNullValue()))
                    .andExpect(jsonPath("$.id").value(RocketTestData.ROCKET_UUID.toString()))
                    .andExpect(jsonPath("$.name").value(RocketTestData.ROCKET_NAME))
                    .andExpect(jsonPath("$.rocketType").value(RocketTestData.ROCKET_TYPE.toString()))
                    .andExpect(jsonPath("$.country").value(RocketTestData.ROCKET_COUNTRY))
                    .andExpect(jsonPath("$.startTestPeriod").value(RocketTestData.CURRENT_DATE.toString()))
                    .andExpect(jsonPath("$.endTestPeriod").
                            value(RocketTestData.CURRENT_DATE_PLUS_MONTH.toString()));

            verify(rocketService, times(1)).getRocketById(rocketId);
        }


        @Test
        void shouldNotGetRocketById_whenRocketNotFound() throws Exception {
            //given
            UUID rocketId = RocketTestData.ROCKET_UUID;
            when(rocketService.getRocketById(rocketId)).thenThrow(RocketNotFoundException.class);

            //when, then
            mockMvc.perform(get("/api/v1/rockets/{id}", rocketId))
                    .andExpect(status().isInternalServerError());

            verify(rocketService, times(1)).getRocketById(rocketId);
        }


    }

    @ParameterizedTest
    @EnumSource(RocketType.class)
    void shouldGetRocketsByType(RocketType rocketType) throws Exception {
        //given
        List<Rocket> rockets = RocketTestDataByType.getListRocketsByType(rocketType);
        when(rocketService.getRocketsByType(rocketType)).thenReturn(rockets);

        //when, then
        mockMvc.perform(get("/api/v1/rockets/type/{type}", rocketType))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3));

        verify(rocketService, times(1)).getRocketsByType(rocketType);
    }

    @Test
    void shouldGetRocketsEndedTestPeriod() throws Exception {
        //given
        List<Rocket> rockets = RocketTestDataEndedTestPeriod.getListWithFiveRockets();
        when(rocketService.getRocketsEndedTestPeriod()).thenReturn(rockets);

        //when, then
        mockMvc.perform(get("/api/v1/rockets/ended"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(5));

        verify(rocketService, times(1)).getRocketsEndedTestPeriod();
    }

    @Test
    void shouldUpdateRocketById() throws Exception {
        //given
        UUID rocketId = RocketTestData.ROCKET_UUID;
        Rocket rocket = RocketTestData.getFillRocketForUpdate();
        Rocket updatedRocket = RocketTestData.getFillRocketForUpdate();
        String content = objectMapper.writeValueAsString(rocket);

        when(rocketService.updateRocket(rocketId, rocket)).thenReturn(updatedRocket);

        //when, then
        mockMvc.perform(post("/api/v1/rockets/{id}", rocketId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(RocketTestData.ROCKET_UUID.toString()))
                .andExpect(jsonPath("$.name").value(RocketTestData.ROCKET_NAME_UPDATE))
                .andExpect(jsonPath("$.rocketType").value(RocketTestData.ROCKET_TYPE_UPDATE.toString()))
                .andExpect(jsonPath("$.country").value(RocketTestData.ROCKET_COUNTRY_UPDATE))
                .andExpect(jsonPath("$.startTestPeriod").value(RocketTestData.CURRENT_DATE.toString()))
                .andExpect(jsonPath("$.endTestPeriod").value(RocketTestData.CURRENT_DATE_PLUS_MONTH.toString()))
        ;

        verify(rocketService, times(1)).updateRocket(rocketId, rocket);

    }

    @Test
    void shouldNotUpdateRocketById_whenRocketNotFound() throws Exception {
        //given
        UUID rocketId = RocketTestData.ROCKET_UUID;
        Rocket updatedRocket = RocketTestData.getFillRocket();
        String content = objectMapper.writeValueAsString(updatedRocket);
        when(rocketService.updateRocket(rocketId, updatedRocket)).thenThrow(RocketNotFoundException.class);

        //when, then
        mockMvc.perform(post("/api/v1/rockets/{id}", rocketId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(status().isInternalServerError());

        verify(rocketService, times(1)).updateRocket(rocketId, updatedRocket);
    }
}