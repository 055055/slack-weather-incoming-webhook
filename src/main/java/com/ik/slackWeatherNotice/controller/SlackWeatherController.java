package com.ik.slackWeatherNotice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ik.slackWeatherNotice.dto.WeatherDTO;
import com.ik.slackWeatherNotice.service.SlackWeatherService;


@RestController
public class SlackWeatherController {
	@Autowired
	SlackWeatherService slackWeatherService;
	
	@GetMapping("/getWeather")
	public WeatherDTO getWether() {
		System.out.println("@@");
		WeatherDTO weatherDTO = slackWeatherService.getWeather();
		return weatherDTO;
	} 
	
}
