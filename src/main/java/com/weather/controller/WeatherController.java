package com.weather.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weather.entity.Weather;
import com.weather.service.WeatherService;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

	@Autowired
	private WeatherService ws;
	@GetMapping("/getAllWeatherInfo")
	public List<Weather> getAllWeatherInfo(){
		return ws.getAllWeatherInfo();
	}
	@GetMapping("/getWeatherById/{id}")
	public Weather getWeatherInfoById(@PathVariable long id) {
		return ws.getWeatherInfoById(id);
	}
	@PostMapping("/insertNewWeather")
	public void insertNewWeather(@RequestBody Weather weather)
	{
		ws.insertNewWeather(weather);
	}
	@PutMapping("/updateWeatherById/{id}")
	public void updateWeather(@RequestBody Weather weather,@PathVariable long id) {
		ws.updateWeather(weather, id);
	}
	@DeleteMapping("/deleteClassroomById/{id}")
	public void deleteClassroomById(@PathVariable long id) {
		ws.deleteClassroomById(id);
	}
}
