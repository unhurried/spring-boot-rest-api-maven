package com.example.api.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/** A JPA entity corresponding to request_record table */
// @Entity: Indicate that the class is a JPA entity.
@Entity
// @Table: Specifies the table name if it is not same as the class name.
@Table(name="request_record")
@Getter
@Setter
public class RequestRecordEntity {
	// @Id: Indicates that the field uniquely identifies the entity.
    @Id
    // @GeneratedValue(strategy=GenerationType.IDENTITY):
    //   Generates the primary key by using the identity columns of RDBMS.
    //   (ex. auto_increment in MySQL)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	private String method;
	private String path;
	private String pathParam;
	private String queryParam;
	private String body;
}