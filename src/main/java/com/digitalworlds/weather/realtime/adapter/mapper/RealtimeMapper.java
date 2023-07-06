package com.digitalworlds.weather.realtime.adapter.mapper;

import com.digitalworlds.weather.realtime.adapter.persistence.entity.HistoryRealtimeEntity;
import com.digitalworlds.weather.realtime.domain.model.Location;
import com.digitalworlds.weather.realtime.domain.model.Realtime;

import java.util.HashMap;

public class RealtimeMapper {

    private RealtimeMapper() {
    }

    public static Realtime fromTomorrowApiResponseToModel(HashMap<String, Object> object) {
        if (object == null || object.isEmpty()) {
            return null;
        }
        HashMap<String, Object> data = (HashMap<String, Object>) object.get("data");
        HashMap<String, Object> locationMap = (HashMap<String, Object>) object.get("location");
        HashMap<String, Object> values = (HashMap<String, Object>) data.get("values");

        Location location = new Location();
        location.setName((String) locationMap.get("name"));
        location.setLatitude(locationMap.get("lat").toString());
        location.setLongitude(locationMap.get("lon").toString());

        Realtime realtime = new Realtime();
        realtime.setLocation(location);
        realtime.setTemperature((Double) values.get("temperature"));
        realtime.setTemperatureApparent((Double) values.get("temperatureApparent"));
        return realtime;
    }

    public static Realtime fromWeatherApiResponseToModel(HashMap<String, Object> object) {
        if (object == null || object.isEmpty()) {
            return null;
        }
        HashMap<String, Object> locationMap = (HashMap<String, Object>) object.get("location");
        HashMap<String, Object> data = (HashMap<String, Object>) object.get("current");

        String formatStr = "%s, %s, %s";

        Location location = new Location();
        location.setName(String.format(formatStr,
                locationMap.get("name").toString(),
                locationMap.get("region").toString(),
                locationMap.get("country").toString()));
        location.setLatitude(locationMap.get("lat").toString());
        location.setLongitude(locationMap.get("lon").toString());

        Realtime realtime = new Realtime();
        realtime.setLocation(location);
        realtime.setTemperature((Double) data.get("temp_c"));
        realtime.setTemperatureApparent((Double) data.get("feelslike_c"));
        return realtime;
    }

    public static HistoryRealtimeEntity toEntity(Realtime model) {
        return HistoryRealtimeEntity.builder()
                .temperature(model.getTemperature())
                .temperatureApparent(model.getTemperatureApparent())
                .locName(model.getLocation().getName())
                .locLatitude(model.getLocation().getLatitude())
                .locLongitude(model.getLocation().getLongitude())
                .build();
    }

    public static Realtime toModel(HistoryRealtimeEntity entity) {
        Location location = Location.builder()
                .latitude(entity.getLocLatitude())
                .longitude(entity.getLocLongitude())
                .name(entity.getLocName())
                .build();

        return Realtime.builder()
                .temperature(entity.getTemperature())
                .temperatureApparent(entity.getTemperatureApparent())
                .location(location)
                .build();
    }
}
