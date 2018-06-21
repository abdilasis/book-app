package com.qa.integration;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.service.repository.BookDBRepository;

@Path("/book")
public class BookEndpoint {

	@Inject
	private BookDBRepository repo;

	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getAll() {
		return repo.getAll();
	}

	@Path("/json/{id}")
	@GET
	@Produces({ "application/json" })
	public String getOne(@PathParam("id") Long id) {
		return repo.getOne(id);
	}

	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String create(String bookJson) {
		return repo.create(bookJson);
	}

	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String delete(@PathParam("id") Long id) {
		return repo.delete(id);
	}

	public void setRepo(BookDBRepository repo) {
		this.repo = repo;
	}
}
