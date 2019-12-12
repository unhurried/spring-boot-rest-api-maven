package com.example.api.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

/** A component to load a configuration file (application.yaml). */
@Component
// Specify a base key (load properties starting with "app").
@ConfigurationProperties(prefix="app")
@Getter
@Setter
public class AppConfig {
	// "app.string"
	String string;
	// "app.list"
	List<String> list;
}