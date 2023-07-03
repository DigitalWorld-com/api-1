package com.digitalworlds.weather.realtime.service.impl;

import com.digitalworlds.weather.realtime.mapper.RealtimeMapper;
import com.digitalworlds.weather.realtime.model.Realtime;
import com.digitalworlds.weather.realtime.dto.RealtimeDTO;
import com.digitalworlds.weather.realtime.feign.RealTimeWeatherAPICLient;
import com.digitalworlds.weather.realtime.feign.RealtimeTomorrowAPIClient;
import com.digitalworlds.weather.realtime.service.RealtimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@RequiredArgsConstructor
@Service
public class RealtimeServiceimpl implements RealtimeService {

    @Value("${tomorrow.api.key}")
    private String tomorrowApiKey;
    @Value("${weather-api.key}")
    private String weatherApiKey;

    private final RealtimeTomorrowAPIClient realtimeTomorrowAPIClient;
    private final RealTimeWeatherAPICLient realTimeWeatherAPICLient;

    @Override
    public Realtime getRealTime(RealtimeDTO request) {
        try {
            HashMap<String, Object> response = realTimeWeatherAPICLient.get(weatherApiKey, request.getLocation(), "no");
            return RealtimeMapper.fromWeatherApiResponseToModel(response);
        } catch (Exception e) {
            try {
                HashMap<String, Object> response = realtimeTomorrowAPIClient.get(request.getLocation(), request.getUnits(), tomorrowApiKey);
                return RealtimeMapper.fromTomorrowApiResponseToModel(response);
            } catch (Exception e2) {
                throw  new RuntimeException("Failed to communicate with APIs");
            }
        }
    }

}
