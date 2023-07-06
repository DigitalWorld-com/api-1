package com.digitalworlds.weather.realtime.domain.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Realtime {
    private Double temperature;
    private Double temperatureApparent;
    private Location location;
}
