package br.game.lightisgone.lig.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.game.lightisgone.lig.client.WeatherClient;
import org.json.JSONObject;
import org.json.JSONException;

@Service
public class WeatherInfo {

    @Autowired
    private WeatherClient weatherClient;

    private static final String API_KEY = "59cbdfc750b6440b94903611242805"; 

    private JSONObject getWeatherData(String location) throws JSONException {
        String jsonResponse = weatherClient.getCurrentWeather(API_KEY, location);
        return new JSONObject(jsonResponse);
    }

    public String getLocationName(String location) throws JSONException {
        JSONObject jsonObject = getWeatherData(location);
        return jsonObject.getJSONObject("location").getString("name");
    }

    public String getRegion(String location) throws JSONException {
        JSONObject jsonObject = getWeatherData(location);
        return jsonObject.getJSONObject("location").getString("region");
    }

    public String getCountry(String location) throws JSONException {
        JSONObject jsonObject = getWeatherData(location);
        return jsonObject.getJSONObject("location").getString("country");
    }

    public String getTimeZone(String location) throws JSONException {
        JSONObject jsonObject = getWeatherData(location);
        return jsonObject.getJSONObject("location").getString("tz_id");
    }

    public String getLocalTime(String location) throws JSONException {
        JSONObject jsonObject = getWeatherData(location);
        return jsonObject.getJSONObject("location").getString("localtime");
    }

    public double getTemperatureC(String location) throws JSONException {
        JSONObject jsonObject = getWeatherData(location);
        return jsonObject.getJSONObject("current").getDouble("temp_c");
    }

    public double getTemperatureF(String location) throws JSONException {
        JSONObject jsonObject = getWeatherData(location);
        return jsonObject.getJSONObject("current").getDouble("temp_f");
    }

    public double getFeelsLikeC(String location) throws JSONException {
        JSONObject jsonObject = getWeatherData(location);
        return jsonObject.getJSONObject("current").getDouble("feelslike_c");
    }

    public double getFeelsLikeF(String location) throws JSONException {
        JSONObject jsonObject = getWeatherData(location);
        return jsonObject.getJSONObject("current").getDouble("feelslike_f");
    }

    public double getWindSpeedKph(String location) throws JSONException {
        JSONObject jsonObject = getWeatherData(location);
        return jsonObject.getJSONObject("current").getDouble("wind_kph");
    }

    public int getHumidity(String location) throws JSONException {
        JSONObject jsonObject = getWeatherData(location);
        return jsonObject.getJSONObject("current").getInt("humidity");
    }

    public int getCloudCover(String location) throws JSONException {
        JSONObject jsonObject = getWeatherData(location);
        return jsonObject.getJSONObject("current").getInt("cloud");
    }

    public String getConditionText(String location) throws JSONException {
        JSONObject jsonObject = getWeatherData(location);
        return jsonObject.getJSONObject("current").getJSONObject("condition").getString("text");
    }

    public String getConditionIcon(String location) throws JSONException {
        JSONObject jsonObject = getWeatherData(location);
        return jsonObject.getJSONObject("current").getJSONObject("condition").getString("icon");
    }
}