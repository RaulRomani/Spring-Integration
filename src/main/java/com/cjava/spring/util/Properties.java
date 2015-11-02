package com.cjava.spring.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Properties {
	
	@Value("mensaje")
	public String MENSAJE;

}
