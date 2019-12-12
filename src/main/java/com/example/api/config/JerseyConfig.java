package com.example.api.config;

import javax.inject.Named;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

/** Configurations for Jersey (JAX-RS) */
// ResourceConfig must be a Spring component. (@Named or @Component)
@Named
// Specify a base path of all APIs.
@ApplicationPath("/example")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		// Specify a package name to look for resource classes.
		packages("com.example");
		// Classes can also be registerd respectively with register method.
		//register(SampleResource.class);
	}
}