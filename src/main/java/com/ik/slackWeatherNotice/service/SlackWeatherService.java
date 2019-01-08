package com.ik.slackWeatherNotice.service;



import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.ik.slackWeatherNotice.dto.SendSlackDTO;
import com.ik.slackWeatherNotice.dto.WeatherDTO;

@Slf4j
@Service
public class SlackWeatherService {
	@Value("${openWeather.api.key}")
	private String openWeatherKey;

	@Value("${openWeather.api.uri}")
	private String openWeatherUri;

	@Value("${slack.webHooks.uri}")
	private String slackWebHooksUri;

	@Autowired
	RestTemplate restTemplate;

	@Scheduled(cron="0 0/5 * * * *")
	public void getWeather() {
		WeatherDTO weatherDTO;
		UriComponents uriBuilder = UriComponentsBuilder.fromHttpUrl(openWeatherUri)
				.queryParam("q", "Seoul")
				.queryParam("units", "metric")
				.queryParam("appid", openWeatherKey)
				.build();
		ResponseEntity<WeatherDTO> result = restTemplate.getForEntity(uriBuilder.toString(), WeatherDTO.class);
		weatherDTO = result.getBody();

		SendSlackDTO sendSlackDTO = new SendSlackDTO();
		sendSlackDTO.setText(String.format("[오늘의 %s 날씨]\n 기온:%s\n 기압:%s\n 습도:%s\n 최고기온:%s\n 최저기온:%s\n","서울",weatherDTO.getMainWeather().getTemp()
				,weatherDTO.getMainWeather().getPressure(),weatherDTO.getMainWeather().getHumidity(),weatherDTO.getMainWeather().getTemp_max(),
				weatherDTO.getMainWeather().getTemp_min() ));

		try {
			restTemplate.postForObject(slackWebHooksUri, sendSlackDTO, String.class);

		}catch (RestClientException e) {
			e.printStackTrace();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
