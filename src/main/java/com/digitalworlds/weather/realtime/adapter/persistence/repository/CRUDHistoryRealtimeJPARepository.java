package com.digitalworlds.weather.realtime.adapter.persistence.repository;

import com.digitalworlds.weather.realtime.adapter.persistence.entity.HistoryRealtimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CRUDHistoryRealtimeJPARepository extends JpaRepository<HistoryRealtimeEntity, Long> {
}
