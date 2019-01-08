package com.ik.slackWeatherNotice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
public class WeatherDTO {
	@JsonProperty("main")
	private MainWeatherDTO mainWeather;

	@Override
	public String toString() {
		return "weaterDTO [mainWeather=" + mainWeather + "]";
	}
}
