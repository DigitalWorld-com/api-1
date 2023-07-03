package com.digitalworlds.weather.realtime.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Realtime {

    private Double temperature;
    private Double temperatureApparent;
    private Location location;

}
