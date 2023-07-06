package com.digitalworlds.weather.realtime.adapter.mapper;

import com.digitalworlds.weather.realtime.adapter.persistence.entity.HistoryRealtimeEntity;
import com.digitalworlds.weather.realtime.domain.model.HistoryRealTime;
import com.digitalworlds.weather.realtime.domain.model.Location;
import com.digitalworlds.weather.realtime.domain.model.Realtime;

import java.util.HashMap;

public class HistoryRealtimeMapper {

    private HistoryRealtimeMapper() {
    }

    public static HistoryRealtimeEntity toEntity(HistoryRealTime model) {
        return HistoryRealtimeEntity.builder()
                .temperature(model.getRealtime().getTemperature())
                .temperatureApparent(model.getRealtime().getTemperatureApparent())
                .locName(model.getRealtime().getLocation().getName())
                .locLatitude(model.getRealtime().getLocation().getLatitude())
                .locLongitude(model.getRealtime().getLocation().getLongitude())
                .build();
    }

    public static HistoryRealTime toModel(HistoryRealtimeEntity entity) {
        Realtime realtime = RealtimeMapper.toModel(entity);

        return HistoryRealTime.builder()
                .time(entity.getCreatedOn())
                .realtime(realtime)
                .build();
    }
}
