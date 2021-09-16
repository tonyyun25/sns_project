package com.lytear.sns.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.lytear.sns.common.FileManagerService;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**")
		//.addResourceLocations("file:///C:\\Users\\01.Web개발\\memo\\upload\\images/");
		.addResourceLocations("file:///" + FileManagerService.FILE_UPLOAD_PATH);
	}
	
}
