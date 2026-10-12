package com.glicocontrol.backend.repositories;

import com.glicocontrol.backend.models.GlucoseMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface GlucoseMeasurementRepository extends JpaRepository<GlucoseMeasurement, Long> {

    // Método para buscar todas as medições de um usuário específico ordenadas da mais recente para a mais antiga
    List<GlucoseMeasurement> findByUserIdOrderByMeasurementDateTimeDesc(Long userId);

    // Buscar histórico de um usuário em um intervalo de datas
    List<GlucoseMeasurement> findByUserIdAndMeasurementDateTimeBetweenOrderByMeasurementDateTimeDesc(Long userId, LocalDateTime startDate, LocalDateTime endDate);

}

