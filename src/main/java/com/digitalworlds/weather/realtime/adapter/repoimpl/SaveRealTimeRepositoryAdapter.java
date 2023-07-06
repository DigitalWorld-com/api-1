package com.digitalworlds.weather.realtime.adapter.repoimpl;

import com.digitalworlds.annotations.OutPortAdapter;
import com.digitalworlds.weather.realtime.adapter.mapper.RealtimeMapper;
import com.digitalworlds.weather.realtime.adapter.persistence.entity.HistoryRealtimeEntity;
import com.digitalworlds.weather.realtime.adapter.persistence.repository.CRUDHistoryRealtimeJPARepository;
import com.digitalworlds.weather.realtime.application.exception.RealTimeException;
import com.digitalworlds.weather.realtime.domain.model.Realtime;
import com.digitalworlds.weather.realtime.domain.repository.SaveRealTimeRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@RequiredArgsConstructor
@OutPortAdapter
public class SaveRealTimeRepositoryAdapter implements SaveRealTimeRepository {
    private final CRUDHistoryRealtimeJPARepository crudJPARepository;
    @Override
    public Realtime save(Realtime realtime) {
        Objects.requireNonNull(realtime, "Cannot save a Realtime null");

        HistoryRealtimeEntity entity = RealtimeMapper.toEntity(realtime);
        entity.setCreatedOn(LocalDateTime.now());

        try {
            entity = crudJPARepository.save(entity);
            return RealtimeMapper.toModel(entity);
        } catch (Exception e) {
            throw new RealTimeException("Fail to save HistoryRealTime", e);
        }
    }
}
