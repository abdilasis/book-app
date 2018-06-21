package com.qa.service.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.qa.domain.Book;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
public class BookDBRepository implements BookRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private JSONUtil util;

	public String getAll() {
		TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b ORDER BY b.id", Book.class);
		return util.getJSONForObject(query.getResultList());
	}

	public String getOne(Long id) {
		return util.getJSONForObject(em.find(Book.class, id));
	}

	@Transactional(REQUIRED)
	public String create(String bookJson) {
		Book book = util.getObjectForJSON(bookJson, Book.class);
		em.persist(book);
		return "{\"message\": \"Book successfully created\"}";
	}

	@Transactional(REQUIRED)
	public String delete(Long id) {
		Book bookToDelete = em.find(Book.class, id);
		if(bookToDelete.equals(null)) {
			return "{\"message\": \"ERROR: Book not found\"}";
		} else {
			em.remove(bookToDelete);
			return "{\"message\": \"Book successfully deleted\"}";
		}
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
