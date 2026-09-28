package com.glicocontrol.backend.repositories;


import com.glicocontrol.backend.models.GlucoseMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

    @Repository
    public interface GlucoseMeasurementRepository extends JpaRepository<GlucoseMeasurement, Long> {

        // Método customizado para buscar todas as medições de um usuário específico pelo ID dele
        List<GlucoseMeasurement> findByUserId(Long userId);
    }

