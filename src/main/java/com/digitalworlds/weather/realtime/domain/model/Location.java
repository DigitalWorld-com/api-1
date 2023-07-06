package com.digitalworlds.weather.realtime.domain.model;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Location {

    private String longitude;
    private String latitude;
    private String name;

}
