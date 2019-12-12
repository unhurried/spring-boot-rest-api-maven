package com.example.api.resource;

import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.example.api.helper.BeanHelper;
import com.example.api.repository.ToDoRepository;
import com.example.api.repository.entity.ToDo;
import com.example.api.resource.bean.ListParam;
import com.example.api.resource.bean.ToDoBean;
import com.example.api.resource.exception.NotFoundException;

/** A JAX-RS (Jersey) resource class for ToDo items */
// Resource classes must be annotated with one of @Component, @Service, @Controller, @Repository.
// (Note: Spring AOP does't work if @Named is used instead.)
@Component
@Path("/api") // Base path for all methods in the class
@Consumes(MediaType.APPLICATION_JSON) // Content-Type of request body
@Produces(MediaType.APPLICATION_JSON) // Content-Type of response body
@Transactional // Make all the methods in the class transactional.
public class ToDoResource {

	// Spring components (Dependency Injection)
	@Inject
	private ToDoRepository repository;
	@Inject
	private BeanHelper beanHelper;

	/** GET /api/todos: Get a list of todo items. */
	@GET
	@Path("/todos")
	public Response getList(@BeanParam ListParam listParam) {
		Pageable pageable = PageRequest.of(listParam.getPage(), listParam.getSize());
		Iterable<ToDo> entityList = repository.findAll(pageable);
		Iterable<ToDoBean> beanList = beanHelper.createAndCopyIterable(entityList, ToDoBean.class);
		return Response.ok().entity(beanList).build();
	}

	/** POST /api/todos: Create a new todo item. */
	@POST
	@Path("/todos")
	public Response create(ToDoBean reqBean) {
		ToDo entity = beanHelper.createAndCopy(reqBean, ToDo.class, (ToDoBean src, ToDo target) -> {
			target.setId(null);
		});
		entity = repository.save(entity);
		ToDoBean resBean = beanHelper.createAndCopy(entity, ToDoBean.class);
		return Response.ok().entity(resBean).build();
	}

	/** GET /api/todos/{id}: Get a todo item. */
	@GET
	@Path("/todos/{id}")
	public Response get(@PathParam("id") Long id) {
		Optional<ToDo> result = repository.findById(id);
		if(result.isPresent()) {
			ToDoBean bean = beanHelper.createAndCopy(result.get(), ToDoBean.class);
			return Response.ok().entity(bean).build();
		} else {
			throw new NotFoundException();
		}
	}

	/** PUT /api/todos/{id}: Update a todo item. */
	@PUT
	@Path("/todos/{id}")
	public Response update(@PathParam("id") Long id, ToDoBean reqBean) {
		ToDo entity = beanHelper.createAndCopy(reqBean, ToDo.class, (ToDoBean src, ToDo target) -> {
			target.setId(id);
		});
		repository.save(entity);
		return Response.ok().entity(reqBean).build();
	}

	/** DELETE /api/todos/{id}: Delete a todo item. */
	@DELETE
	@Path("/todos/{id}")
	public Response remove(@PathParam("id") Long id) {
		Optional<ToDo> result = repository.findById(id);
		if(result.isPresent()) {
			repository.deleteById(id);
			return Response.ok().build();
		} else {
			throw new NotFoundException();
		}
	}
}