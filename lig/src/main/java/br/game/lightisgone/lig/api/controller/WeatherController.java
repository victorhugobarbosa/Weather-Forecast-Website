package br.game.lightisgone.lig.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.game.lightisgone.lig.service.WeatherInfo;
import org.json.JSONException;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherInfo weatherInfo;

    @GetMapping("/location/name")
    public String getLocationName(@RequestParam String location) throws JSONException {
        return weatherInfo.getLocationName(location);
    }

    @GetMapping("/location/region")
    public String getRegion(@RequestParam String location) throws JSONException {
        return weatherInfo.getRegion(location);
    }

    @GetMapping("/location/country")
    public String getCountry(@RequestParam String location) throws JSONException {
        return weatherInfo.getCountry(location);
    }

    @GetMapping("/location/timezone")
    public String getTimeZone(@RequestParam String location) throws JSONException {
        return weatherInfo.getTimeZone(location);
    }

    @GetMapping("/location/localtime")
    public String getLocalTime(@RequestParam String location) throws JSONException {
        return weatherInfo.getLocalTime(location);
    }

    @GetMapping("/current/temp_c")
    public double getTemperatureC(@RequestParam String location) throws JSONException {
        return weatherInfo.getTemperatureC(location);
    }

    @GetMapping("/current/temp_f")
    public double getTemperatureF(@RequestParam String location) throws JSONException {
        return weatherInfo.getTemperatureF(location);
    }

    @GetMapping("/current/feelslike_c")
    public double getFeelsLikeC(@RequestParam String location) throws JSONException {
        return weatherInfo.getFeelsLikeC(location);
    }

    @GetMapping("/current/feelslike_f")
    public double getFeelsLikeF(@RequestParam String location) throws JSONException {
        return weatherInfo.getFeelsLikeF(location);
    }

    @GetMapping("/current/wind_kph")
    public double getWindSpeedKph(@RequestParam String location) throws JSONException {
        return weatherInfo.getWindSpeedKph(location);
    }

    @GetMapping("/current/humidity")
    public int getHumidity(@RequestParam String location) throws JSONException {
        return weatherInfo.getHumidity(location);
    }

    @GetMapping("/current/cloud")
    public int getCloudCover(@RequestParam String location) throws JSONException {
        return weatherInfo.getCloudCover(location);
    }

    @GetMapping("/current/condition/text")
    public String getConditionText(@RequestParam String location) throws JSONException {
        return weatherInfo.getConditionText(location);
    }

    @GetMapping("/current/condition/icon")
    public String getConditionIcon(@RequestParam String location) throws JSONException {
        return weatherInfo.getConditionIcon(location);
    }
}
