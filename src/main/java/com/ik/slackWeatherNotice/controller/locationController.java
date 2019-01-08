package com.ik.slackWeatherNotice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
public class locationController {
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(){


        return "main";
    }
}
