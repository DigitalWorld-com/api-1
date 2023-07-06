package com.digitalworlds.weather.realtime.application.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RequestRealtimeDTO {

    private String location;
    private String units;

}
