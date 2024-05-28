package br.game.lightisgone.lig.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "weatherClient", url = "https://api.weatherapi.com/v1")
public interface WeatherClient {
    @GetMapping("/current.json")
    String getCurrentWeather(@RequestParam("key") String apiKey, @RequestParam("q") String location);
}