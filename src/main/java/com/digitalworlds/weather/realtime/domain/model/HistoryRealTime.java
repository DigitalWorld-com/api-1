package com.digitalworlds.weather.realtime.domain.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class HistoryRealTime {
    private LocalDateTime time;
    private Realtime realtime;
}
