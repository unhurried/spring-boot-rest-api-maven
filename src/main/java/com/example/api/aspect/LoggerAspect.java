package com.example.api.aspect;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/** An aspect (Spring AOP) that logs HTTP method and path of API calls. */
// @Aspect and @Component are required to register an aspect.
@Aspect
@Component
// @Slf4j: Bind SLF4j logger instance to "log" filed of the class.
@Slf4j
public class LoggerAspect {

	// Spring components (Dependency Injection)
	@Inject
	private HttpServletRequest request;

	// @Before: Execute an advice before a join point.
	@Before("within(com.example.api.resource.ToDoResource)")
	public void before(JoinPoint joinPoint) {
		log.info("API call: " + request.getMethod() + " " + request.getPathInfo());
	}
}