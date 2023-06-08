package com.digitalworlds.weather.mapper;

import com.digitalworlds.weather.model.Location;
import com.digitalworlds.weather.model.Realtime;

import java.math.BigDecimal;
import java.util.HashMap;

public class RealtimeMapper {

    private RealtimeMapper() {
    }

    public static Realtime toModel(HashMap<String, Object> object) {
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

}
