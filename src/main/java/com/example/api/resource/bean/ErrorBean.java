package com.example.api.resource.bean;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/** Data Transfer Object for request and response bodies in error responses */
@Getter
@Setter
public class ErrorBean implements Serializable {
	private String errorCode;
}