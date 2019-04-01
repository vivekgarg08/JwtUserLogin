package com.vivek.userLoginUtil;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.vivek.userLoginConfig.UserProfileConfiguration;


public class CustomLocalDateTimeSerializer extends StdSerializer<Date> {

	@Autowired
	private UserProfileConfiguration configuration;
	private static final long serialVersionUID = 1L;
	private SimpleDateFormat dateFormat;

	@PostConstruct
	public void CustomLocalDateTimeSerializerInit() {
		dateFormat = new SimpleDateFormat(configuration.getDateFormatVal());
	}

	

	public CustomLocalDateTimeSerializer() {
		this(null);
	}

	public CustomLocalDateTimeSerializer(Class<Date> t) {
		super(t);
	}

	@Override
	public void serialize(Date value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		// TODO Auto-generated method stub
		gen.writeString(dateFormat.format(value));
	}
}
