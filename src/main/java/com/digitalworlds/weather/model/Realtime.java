package com.digitalworlds.weather.model;

import com.digitalworlds.weather.model.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Realtime {

    private Double temperature;
    private Double temperatureApparent;
    private Location location;

}
