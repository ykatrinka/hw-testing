package ru.clevertec.edu.ykv.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.clevertec.edu.ykv.common.RocketType;
import ru.clevertec.edu.ykv.domain.Rocket;
import ru.clevertec.edu.ykv.exception.RocketNotFoundException;
import ru.clevertec.edu.ykv.service.RocketService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class RocketController {

    private final RocketService rocketService;

    @PostMapping("/api/v1/rockets")
    public ResponseEntity<Rocket> createRocket(@RequestBody Rocket rocket) {
        Rocket createdRocket = rocketService.createRocket(rocket);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(createdRocket);
    }


    @GetMapping("/api/v1/rockets")
    public ResponseEntity<List<Rocket>> findAllRockets() {
        List<Rocket> rockets = rocketService.getRockets();
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(rockets);
    }

    @GetMapping("/api/v1/rockets/{id}")
    public ResponseEntity<Rocket> findRocketById(@PathVariable("id") UUID rocketId) {
        try {
            Rocket rocket = rocketService.getRocketById(rocketId);

            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(rocket);
        } catch (RocketNotFoundException e) {
            return ResponseEntity.internalServerError()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(null);
        }
    }

    @GetMapping("/api/v1/rockets/type/{type}")
    public ResponseEntity<List<Rocket>> findRocketsByType(@PathVariable("type") RocketType rocketType) {
        List<Rocket> rockets = rocketService.getRocketsByType(rocketType);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(rockets);
    }

    @GetMapping("/api/v1/rockets/ended")
    public ResponseEntity<List<Rocket>> findRocketsEndedTestPeriod() {
        List<Rocket> rockets = rocketService.getRocketsEndedTestPeriod();
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(rockets);
    }


    @PostMapping("/api/v1/rockets/{id}")
    public ResponseEntity<Rocket> updateRocket(@PathVariable("id") UUID rocketId, @RequestBody Rocket rocket) {
        try {
            Rocket updatedRocket = rocketService.updateRocket(rocketId, rocket);
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(updatedRocket);
        } catch (RocketNotFoundException e) {
            return ResponseEntity.internalServerError()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(null);
        }
    }


    @DeleteMapping("api/v1/rockets/{id}")
    public void deleteCake(@PathVariable("id") UUID rocketId) {
        rocketService.delete(rocketId);
    }

}
