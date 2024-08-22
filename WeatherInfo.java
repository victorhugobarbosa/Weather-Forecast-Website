import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;
import java.net.UnknownHostException;

public class WeatherInfo {
    private static final String API_KEY = "f637adf8a67344d3912140435241305";
    private static final String API_URL = "http://api.weatherapi.com/v1/current.json?key=" + API_KEY + "&q=";

    public static void main(String[] args) {
        try {
            // Obtém o endereço IP da máquina local
            String ip = InetAddress.getLocalHost().getHostAddress();
            System.out.println("Endereço IP da máquina: " + ip);

            // Obtém os dados do clima usando o IP da máquina
            JSONObject weatherData = getWeatherData(ip);
            if (weatherData != null) {
                double tempCelsius = weatherData.getJSONObject("current").getDouble("temp_c");
                double feelsLikeCelsius = weatherData.getJSONObject("current").getDouble("feelslike_c");
                double tempFahrenheit = weatherData.getJSONObject("current").getDouble("temp_f");
                double feelsLikeFahrenheit = weatherData.getJSONObject("current").getDouble("feelslike_f");
                double windSpeedKph = weatherData.getJSONObject("current").getDouble("wind_kph");
                int humidity = weatherData.getJSONObject("current").getInt("humidity");
                int cloud = weatherData.getJSONObject("current").getInt("cloud");
                String name = weatherData.getJSONObject("location").getString("name");
                String region = weatherData.getJSONObject("location").getString("region");
                String country = weatherData.getJSONObject("location").getString("country");
                String tz_id = weatherData.getJSONObject("location").getString("tz_id");
                String localtime = weatherData.getJSONObject("location").getString("localtime");
                String text = weatherData.getJSONObject("current").getJSONObject("condition").getString("text");
                String iconURL = weatherData.getJSONObject("current").getJSONObject("condition").getString("icon");

                System.out.println("Temperatura: " + tempCelsius + "°C (" + tempFahrenheit + "°F)");
                System.out.println("Sensação térmica: " + feelsLikeCelsius + "°C (" + feelsLikeFahrenheit + "°F)");
                System.out.println("Velocidade do vento: " + windSpeedKph + " km/h");
                System.out.println("Umidade do ar: " + humidity + "%");
                System.out.println("Situação das nuvens: " + cloud + "%");
                System.out.println("name: " + name);
                System.out.println("region: " + region);
                System.out.println("country: " + country);
                System.out.println("time zone: " + tz_id);
                System.out.println("localtime: " + localtime);
                System.out.println("text: " + text);
                System.out.println("iconURL: " + iconURL);
            }
        } catch (UnknownHostException e) {
            System.err.println("Erro ao obter o endereço IP: " + e.getMessage());
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    private static JSONObject getWeatherData(String ip) throws IOException {
        URL url = new URL(API_URL + ip);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            try {
                return new JSONObject(response.toString());
            } catch (JSONException e) {
                System.err.println("Erro ao criar JSONObject: " + e.getMessage());
                return null;
            }
        } else {
            System.out.println("Erro na requisição HTTP: " + responseCode);
            return null;
        }
    }
}
