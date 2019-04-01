package com.vivek.userLoginConfig;

import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("basic")
public class UserProfileConfiguration {
	private String DateFormatVal;

	public String getDateFormatVal() {
		return DateFormatVal;
	}

	public void setDateFormatVal(String dateFormatVal) {
		DateFormatVal = dateFormatVal;
	}

	
}
