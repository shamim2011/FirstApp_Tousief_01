package com.mycomp.firstApp.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.mycomp.firstApp.dto.MyReq;
import com.mycomp.firstApp.service.MyService;

@Component
public class MyServiceImpl implements MyService {

	private static final Logger logger = LoggerFactory.getLogger(MyServiceImpl.class);
	
	private Gson gson;
	
	public MyServiceImpl(Gson gson) {
		logger.info("MyServiceImpl constructor********** this:{}",this);
		this.gson = gson;
	}
	
	@Override
	public String add(int val1, int val2) {
		logger.info("val1: {}, val2: {}", val1, val2);
		
		int result = val1 + val2;
		logger.info("result: {}", result);
		
		MyReq myReq = new MyReq();
		myReq.setNum1(val1);
		myReq.setNum2(val2);
		
		logger.info("myReq: {}",myReq);
		
		// Converting myReq object to JSON String
		
		String jsonString = gson.toJson(myReq);
		
		logger.info("jsonString : {}",jsonString);
		
		
		return "From service : \n " + jsonString;
	}
	
}
