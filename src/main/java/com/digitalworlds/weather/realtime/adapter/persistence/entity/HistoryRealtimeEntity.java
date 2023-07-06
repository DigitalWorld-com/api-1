package com.digitalworlds.weather.realtime.adapter.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity()
@Table(name = "history_realtime")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class HistoryRealtimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double temperature;
    private Double temperatureApparent;
    private String locLongitude;
    private String locLatitude;
    private String locName;
    private LocalDateTime createdOn;
}
