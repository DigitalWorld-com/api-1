package com.digitalworlds.weather.realtime.domain.service.impl;

import com.digitalworlds.weather.realtime.domain.model.HistoryRealTime;
import com.digitalworlds.weather.realtime.domain.model.Realtime;
import com.digitalworlds.weather.realtime.domain.repository.GetRealTimeRepository;
import com.digitalworlds.weather.realtime.domain.repository.SaveRealTimeRepository;
import com.digitalworlds.weather.realtime.domain.service.GetRealTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetRealtimeService implements GetRealTime {
    private final GetRealTimeRepository getRepository;
    private final SaveRealTimeRepository saveRepository;

    @Override
    public Realtime get(String location, String units) {
        return getRepository.get(location, units);
    }

    @Override
    public Realtime getAndRegister(String location, String units) {
        Realtime realtime = get(location, units);
        realtime = saveRepository.save(realtime);
        return realtime;
    }

    @Override
    public List<HistoryRealTime> getHistory() {
        return getRepository.getHistory();
    }
}
