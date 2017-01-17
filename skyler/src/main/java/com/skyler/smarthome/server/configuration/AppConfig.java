package com.skyler.smarthome.server.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("com.skyler.smarthome.server")
@EnableAspectJAutoProxy
@EnableAsync
@EnableScheduling
public class AppConfig {


}
