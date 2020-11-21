package com.cmpe275.GameApp;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameAppConfiguration {

	
	/** 
	 * Game App configuration file returning Model Mapper
	 * @return ModelMapper
	 */
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
}
