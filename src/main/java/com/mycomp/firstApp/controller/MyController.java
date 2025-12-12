package com.mycomp.firstApp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycomp.firstApp.pojo.NumReq;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/myctrl")
public class MyController {
	
	private Logger logger = LoggerFactory.getLogger(MyController.class);
	
	@Value("${dp.ip}")
	private String dpIP;
	
	@GetMapping
	public String getMethod() {
		return "/index.html";
	}
	@PostMapping("/postm/{path1}/{path2}/process")
	public ResponseEntity<String> postMethod(@RequestParam("val1") int val1,
			@RequestParam("val1") int val2,
			@PathVariable String path1,
			@PathVariable String path2,
			@RequestHeader String myHeader,
			@RequestBody NumReq reqBody) {

//		logger.info("NumRequest:{}",reqBody);
		
		convertStringToObject(reqBody);
		
		String responseString = "Hello Spring postMethod()!"+" \nval1="+val1+
		" \nval2="+val2+"\nPath1="+path1+"\nPath2="+path2
		+"\nmyHeader="+myHeader+
		"\n|numReq = "+reqBody;
		
		if(val1 == 1) {
			return new ResponseEntity<>(
					responseString,HttpStatus.OK);
		}
		
		return new ResponseEntity<>(
				responseString,HttpStatus.ACCEPTED); 
	}
	private void convertStringToObject(NumReq reqBody) {
		logger.info("NumRequest:{}",reqBody);
	}
	@PostConstruct
	public void init() {
		logger.info("**********dpIP: {}",dpIP);
	}
}
