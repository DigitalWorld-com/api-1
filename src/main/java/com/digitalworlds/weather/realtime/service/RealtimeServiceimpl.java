package com.digitalworlds.weather.realtime.service;

import com.digitalworlds.weather.mapper.RealtimeMapper;
import com.digitalworlds.weather.model.Realtime;
import com.digitalworlds.weather.realtime.dto.RealtimeDTO;
import com.digitalworlds.weather.realtime.service.feign.RealtimeTomorrowAPIClient;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@RequiredArgsConstructor
@Service
public class RealtimeServiceimpl implements RealtimeService {

    @Value("${tomorrow.api.key}")
    private String apikey;
    private final RealtimeTomorrowAPIClient realtimeClient;

    @Override
    public Realtime getRealTime(RealtimeDTO request) {
        HashMap<String, Object> response = realtimeClient.get(request.getLocation(), request.getUnits(), apikey);
        return RealtimeMapper.toModel(response);
    }

}
