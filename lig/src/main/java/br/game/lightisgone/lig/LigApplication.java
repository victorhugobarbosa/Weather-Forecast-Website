package br.game.lightisgone.lig;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import br.game.lightisgone.lig.service.WeatherInfo;
import org.json.JSONObject;

import java.io.IOException;

@SpringBootApplication
@EnableFeignClients
public class LigApplication {
    public static void main(String[] args) {
        SpringApplication.run(LigApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(WeatherInfo weatherInfo) {
        return args -> {
            try {
                String location = getLocationByIp();
                weatherInfo.printWeatherInfo(location);
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }

    private String getLocationByIp() throws IOException {
        String ipServiceUrl = "https://ipinfo.io/json";
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(ipServiceUrl);
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                String jsonResponse = EntityUtils.toString(response.getEntity());
                JSONObject jsonObject = new JSONObject(jsonResponse);
                return jsonObject.getString("city") + "," + jsonObject.getString("region");
            }
        }
    }
}