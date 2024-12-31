package com.weather.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weather.dao.WeatherDAO;
import com.weather.entity.Weather;

@Service
public class WeatherService {

	@Autowired
	private WeatherDAO wd;
	public List<Weather> getAllWeatherInfo(){
		return wd.getAllWeatherInfo();
	}
	public Weather getWeatherInfoById(long id) {
		return wd.getWeatherInfoById(id);
	}
	public void insertNewWeather(Weather weather) {
		wd.insertNewWeather(weather);
	}
	public void updateWeather(Weather weather,long id) {
		wd.updateWeather(weather, id);
	}
	public void deleteClassroomById(long id) {
		wd.deleteClassroomById(id);
	}
}
