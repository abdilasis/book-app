package com.qa.service.repository;

public interface BookRepository {

	String getAll();

	String getOne(Long id);

	String create(String bookJson);

	String delete(Long id);

}