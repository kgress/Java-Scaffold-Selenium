package com.saucelabs.saucedemo.environment;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(value = "com.saucelabs.saucedemo")
@PropertySource("classpath:/application.properties")
public class SauceDemoConfig {
}