package com.example.api.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.api.config.AppConfig;

/** A JAX-RS (Jersey) resource class for operational resources */
// Resource classes must be annotated with one of @Component, @Service, @Controller, @Repository.
// (Note: Spring AOP does't work if @Named is used instead.)@Component
@Consumes(MediaType.APPLICATION_JSON) // Content-Type of request body
@Produces(MediaType.APPLICATION_JSON) // Content-Type of response bod
public class ConfigResource {

	// Spring components (Dependency Injection)
	@Inject
	private AppConfig config;

	/** GET /config: Get the content of application.yaml. */
	@GET
	@Path("/config")
	public Response config() {
		return Response.ok().entity(config).build();
	}
}