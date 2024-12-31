package com.weather.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.weather.entity.Weather;

@Repository
public class WeatherDAO {
	@Autowired
	private SessionFactory sf;

	public List<Weather> getAllWeatherInfo(){
		Session session=null;
		List<Weather> weather;
		try {
			session=sf.openSession();
			weather=session.createQuery("from Weather",Weather.class).getResultList();
		}finally {
			if (session != null) {
				session.close();
			}
		}
		return weather;
	}
	public Weather getWeatherInfoById(long id) {
		Session session=null;
		Weather weather=null;
		try {
			session=sf.openSession();
			weather=session.get(Weather.class, id);
		}finally {
			if (session != null) {
				session.close();
			}
		}
		return weather;
	}
	@Transactional(readOnly = true)
	public void insertNewWeather(Weather weather) {
		Session session=null;
		try {
			session=sf.openSession();
			session.save(weather);
			
		}finally {
			if (session != null) {
				session.close();
			}
		}
	}
	public void updateWeather(Weather weather,long id) {
		Session session=null;
		Weather w=null;
		try {
			session=sf.openSession();
			Transaction tx=session.beginTransaction();
			w=session.get(Weather.class, id);
			w.setTemperature(weather.getTemperature());
			w.setHumidity(weather.getHumidity());
			w.setDescription(weather.getDescription());
			w.setTime(weather.getTime());
			w.setDate(weather.getDate());
			session.update(w);
			tx.commit();
			
			
		}finally {
			if (session != null) {
				session.close();
			}
		}
	}
	public void deleteClassroomById(long id) {
		Session session=null;
		Weather w=null;
		try {
			session=sf.openSession();
			Transaction tx=session.beginTransaction();
			w=session.get(Weather.class, id);
			session.delete(w);
			tx.commit();
			
		}finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
