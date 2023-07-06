package com.digitalworlds.weather.realtime.adapter.repoimpl;

import com.digitalworlds.annotations.OutPortAdapter;
import com.digitalworlds.weather.realtime.adapter.clients.RealTimeWeatherApiClient;
import com.digitalworlds.weather.realtime.adapter.clients.RealtimeApiTomorrowClient;
import com.digitalworlds.weather.realtime.adapter.mapper.HistoryRealtimeMapper;
import com.digitalworlds.weather.realtime.adapter.mapper.RealtimeMapper;
import com.digitalworlds.weather.realtime.adapter.persistence.entity.HistoryRealtimeEntity;
import com.digitalworlds.weather.realtime.adapter.persistence.repository.CRUDHistoryRealtimeJPARepository;
import com.digitalworlds.weather.realtime.application.exception.RealTimeException;
import com.digitalworlds.weather.realtime.domain.model.HistoryRealTime;
import com.digitalworlds.weather.realtime.domain.model.Realtime;
import com.digitalworlds.weather.realtime.domain.repository.GetRealTimeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@OutPortAdapter
@Slf4j
public class GeRealTimeRepositoryAdapter implements GetRealTimeRepository {
    @Value("${api-tomorrow.key}")
    private String tomorrowApiKey;
    @Value("${weather-api.key}")
    private String weatherApiKey;

    private final RealtimeApiTomorrowClient realtimeTomorrowAPIClient;
    private final RealTimeWeatherApiClient realTimeWeatherAPICLient;
    private final CRUDHistoryRealtimeJPARepository crudJPARepository;

    @Override
    public Realtime get(String location, String units) {
        try {
            log.info("Consulting ApiTomorrow");
            HashMap<String, Object> response = realTimeWeatherAPICLient.get(weatherApiKey, location, "no");
            return RealtimeMapper.fromWeatherApiResponseToModel(response);
        } catch (Exception e) {
            log.info("Fail ApiTomorrow");
            try {
                log.info("Consulting WeatherApi");
                HashMap<String, Object> response = realtimeTomorrowAPIClient.get(location, units, tomorrowApiKey);
                return RealtimeMapper.fromTomorrowApiResponseToModel(response);
            } catch (Exception e2) {
                throw  new RealTimeException("Failed to communicate with APIs", e2);
            }
        }
    }

    @Override
    public List<HistoryRealTime> getHistory() {
        List<HistoryRealtimeEntity> entities = crudJPARepository.findAll();
        return entities.stream().map(HistoryRealtimeMapper::toModel).collect(Collectors.toList());
    }
}
