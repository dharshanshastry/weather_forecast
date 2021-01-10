package com.org;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.org.application.WeatherForecastApplication;
import com.org.controller.WeatherController;

@SpringBootTest(classes = WeatherForecastApplication.class)
class WeatherForecastApplicationTests {

	
	@Autowired
	private WeatherController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
