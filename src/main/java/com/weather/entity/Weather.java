package com.weather.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@javax.persistence.Entity
@Component
@Data
@NoArgsConstructor
@javax.persistence.Table(name="WeatherForecast")
public class Weather {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	private String cityname;
	@Column(nullable = false)
	private double temperature;
	@Column(nullable = false)
	private int humidity;
	@Column(nullable = false)
	private String description;
	@Column(nullable = false)
	private Time time;
	@Column(nullable = false)
	private Date date;
	
	

}
