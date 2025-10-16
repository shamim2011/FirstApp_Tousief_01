package com.mycomp.firstApp.config;

import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;

@Configuration
public class AppConfig {
	@Bean
	Random random() {
		return new Random();
	}
//	@Bean
	Gson gson() {
		return new Gson();
	}
}
