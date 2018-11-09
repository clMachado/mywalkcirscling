package br.com.clmDeveloper.mywalkcircling;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class ThimeleafConfiguracao implements WebMvcConfigurer{
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		
		WebMvcConfigurer.super.addFormatters(registry);
		
		//registry.addConverter(new LocalDateConverter());
		
		registry.addFormatter(new LocalDateFormatter());
	}

}
