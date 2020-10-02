package com.planet.customer.diary.customer_diary.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.number.NumberFormatAnnotationFormatterFactory;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;

@Configuration
public class AppConfiguration {

	@Bean
	public FormattingConversionService conversionService() {
		// Use the DefaultFormattingConversionService but do not register defaults
		final DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService(false);
		// Ensure @NumberFormat is still supported
		conversionService.addFormatterForFieldAnnotation(new NumberFormatAnnotationFormatterFactory());
		// Register date conversion with a specific global format
		final DateFormatterRegistrar registrar = new DateFormatterRegistrar();
		registrar.setFormatter(new DateFormatter("dd.MM.yyyy HH.mm"));
		registrar.registerFormatters(conversionService);
		return conversionService;
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
