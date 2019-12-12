package com.example.api.resource.bean;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

/** Data Transfer Object for request and response bodies of ToDoResource */
@Getter
@Setter
public class ToDoBean implements Serializable {
	private Long id;
	private String title;
	private String content;
	private LocalDate date;
}