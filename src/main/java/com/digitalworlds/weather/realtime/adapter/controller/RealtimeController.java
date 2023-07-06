package com.digitalworlds.weather.realtime.adapter.controller;

import com.digitalworlds.weather.realtime.application.usecase.GetRealtimeUseCase;
import com.digitalworlds.weather.realtime.domain.model.HistoryRealTime;
import com.digitalworlds.weather.realtime.domain.model.Realtime;
import com.digitalworlds.weather.realtime.application.dto.RequestRealtimeDTO;
import com.digitalworlds.weather.realtime.domain.service.GetRealTime;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "realtime")
public class RealtimeController {

    private final GetRealtimeUseCase getUseCase;

    @GetMapping
    private ResponseEntity<Realtime> get(RequestRealtimeDTO request) {
        try {
            Realtime realtime = getUseCase.getAndRegister(request);
            return ResponseEntity.ok(realtime);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/history")
    private ResponseEntity<List<HistoryRealTime>> get() {
        try {
            List<HistoryRealTime> history = getUseCase.getHistory();
            return ResponseEntity.ok(history);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
