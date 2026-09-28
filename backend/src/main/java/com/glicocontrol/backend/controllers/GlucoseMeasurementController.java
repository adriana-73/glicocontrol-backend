package com.glicocontrol.backend.controllers;

import com.glicocontrol.backend.models.GlucoseMeasurement;
import com.glicocontrol.backend.models.User;
import com.glicocontrol.backend.repositories.GlucoseMeasurementRepository;
import com.glicocontrol.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/measurements")
public class GlucoseMeasurementController {

    @Autowired
    private GlucoseMeasurementRepository measurementRepository;

    @Autowired
    private UserRepository userRepository;

    // 1. Endpoint para cadastrar uma nova medição de glicose
    // Exemplo de URL: POST http://localhost:8080/api/measurements?userId=1
    @PostMapping
    public ResponseEntity<Object> createMeasurement(
            @RequestParam("userId") Long userId,
            @RequestBody GlucoseMeasurement measurement) {

        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Usuário não encontrado com o ID informado.");
        }

        measurement.setUser(userOpt.get());

        // Se a data/hora não for enviada, define o horário atual automaticamente
        if (measurement.getMeasurementDateTime() == null) {
            measurement.setMeasurementDateTime(LocalDateTime.now());
        }

        GlucoseMeasurement savedMeasurement = measurementRepository.save(measurement);
        return ResponseEntity.ok(savedMeasurement);
    }

    // 2. Endpoint para listar todas as medições de um usuário específico
    // Exemplo de URL: GET http://localhost:8080/api/measurements/user/1
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<GlucoseMeasurement>> getMeasurementsByUser(@PathVariable("userId") Long userId) {
        List<GlucoseMeasurement> measurements = measurementRepository.findByUserId(userId);
        return ResponseEntity.ok(measurements);
    }
}
