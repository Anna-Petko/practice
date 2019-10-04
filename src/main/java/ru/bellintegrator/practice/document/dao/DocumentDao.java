package ru.bellintegrator.practice.document.dao;

import java.util.List;

import ru.bellintegrator.practice.document.model.Document;

/**
 * DAO for documents
 */

public interface DocumentDao {

	/**
	 * get all documents
	 *
	 * @return
	 */
	public List<Document> all();

	
	/**
	 * get document by id
	 * 
	 * @param id
	 * @return
	 */
	public Document loadById(Integer id);

	
	/**
	 * get document by name
	 * 
	 * @param name
	 * @return
	 */
	public List<Document> loadByName(String name);
	
	
	/**
	 * get document by code
	 * 
	 * @param code
	 * @return
	 */
	public List<Document> loadByCode(String code);

	/**
	 * add new or change an existing document
	 * 
	 * @param doc
	 */
	public void save(Document doc);


}
