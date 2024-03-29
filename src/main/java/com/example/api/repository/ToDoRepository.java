package com.example.api.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.api.repository.entity.ToDo;

/** Spring Data JPA repository for ToDoEntity */
public interface ToDoRepository extends PagingAndSortingRepository<ToDo, Long> {}