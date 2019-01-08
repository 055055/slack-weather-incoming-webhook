package com.ik.slackWeatherNotice.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonAutoDetect
public class MainWeatherDTO {
	@JsonProperty("temp")
	private String temp;
	@JsonProperty("pressure")
	private String pressure;
	@JsonProperty("humidity")
	private String humidity;
	@JsonProperty("temp_min")
	private String temp_min;
	@JsonProperty("temp_max")
	private String temp_max;
	@Override
	public String toString() {
		return "mainWeather [temp=" + temp + ", pressure=" + pressure + ", humidity=" + humidity + ", temp_min="
				+ temp_min + ", temp_max=" + temp_max + "]";
	}
}
