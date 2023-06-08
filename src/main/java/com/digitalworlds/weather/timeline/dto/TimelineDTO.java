package com.digitalworlds.weather.timeline.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TimelineDTO {

    private String location;
    private String fields;
    private String timesteps;
    private String units;

}
