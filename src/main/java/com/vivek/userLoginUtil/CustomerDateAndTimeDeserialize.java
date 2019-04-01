package com.vivek.userLoginUtil;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.vivek.userLoginConfig.UserProfileConfiguration;



public class CustomerDateAndTimeDeserialize extends JsonDeserializer<Date> {
   
	@Autowired 
	private UserProfileConfiguration configuration;
	private SimpleDateFormat dateFormat;
	 
	@PostConstruct
	public void  CustomerDateAndTimeDeserializeInit() {
		 dateFormat = new SimpleDateFormat(configuration.getDateFormatVal());
	}
   

	@Override
	public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		
		String str = p.getText().trim();
      try {
          return dateFormat.parse(str);
      } catch (ParseException e) {
          // Handle exception here
      }
      return ctxt.parseDate(str);
	}

}
