package com.example.demo.props;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@ConfigurationProperties(prefix = "app")
@EnableConfigurationProperties
public class AppProperties {
	
	
	
	  public AppProperties() { super();
	  System.out.println("this is the default constructor!!!!"); }
	 

	private Map<String,String> messages=new HashMap<>();

}
