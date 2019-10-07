package ru.bellintegrator.practice.document.service;

import java.util.List;

import ru.bellintegrator.practice.view.DocumentView;

public interface DocumentService {
	
	/**
	 * getting all documents
	 * 
	 * @return
	 */
	public List<DocumentView> getAllDocumentTypes();


}
