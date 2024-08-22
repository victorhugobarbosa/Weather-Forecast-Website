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

    public void printWeatherInfo(String location) {
        try {
            String jsonResponse = weatherClient.getCurrentWeather(API_KEY, location);
            JSONObject jsonObject = new JSONObject(jsonResponse);

            if (jsonObject.has("location")) {
                JSONObject locationObj = jsonObject.getJSONObject("location");
                String name = locationObj.getString("name");
                String region = locationObj.getString("region");
                String country = locationObj.getString("country");
                String timeZone = locationObj.getString("tz_id");
                String localtime = locationObj.getString("localtime");

                System.out.println("Location Name: " + name);
                System.out.println("Region: " + region);
                System.out.println("Country: " + country);
                System.out.println("Time Zone: " + timeZone);
                System.out.println("Local Time: " + localtime);
            } else {
                System.err.println("A chave 'location' não foi encontrada no JSON.");
            }

            if (jsonObject.has("current")) {
                JSONObject current = jsonObject.getJSONObject("current");

                double tempC = current.getDouble("temp_c");
                double tempF = current.getDouble("temp_f");
                double feelslikeC = current.getDouble("feelslike_c");
                double feelslikeF = current.getDouble("feelslike_f");
                double windKph = current.getDouble("wind_kph");
                int humidity = current.getInt("humidity");
                int cloud = current.getInt("cloud");
                String conditionText = current.getJSONObject("condition").getString("text");
                String conditionIcon = current.getJSONObject("condition").getString("icon");

                System.out.println("Temperature (C): " + tempC);
                System.out.println("Temperature (F): " + tempF);
                System.out.println("Feels Like (C): " + feelslikeC);
                System.out.println("Feels Like (F): " + feelslikeF);
                System.out.println("Wind Speed (kph): " + windKph);
                System.out.println("Humidity (%): " + humidity);
                System.out.println("Cloud Cover (%): " + cloud);
                System.out.println("Condition: " + conditionText);
                System.out.println("Condition Icon URL: " + conditionIcon);
            } else {
                System.err.println("A chave 'current' não foi encontrada no JSON.");
            }
        } catch (JSONException e) {
            System.err.println("Erro ao processar o JSON: " + e.getMessage());
        }
    }
}