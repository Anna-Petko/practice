package ru.bellintegrator.practice.document.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.bellintegrator.practice.document.service.DocumentService;
import ru.bellintegrator.practice.view.DocumentView;

@RestController
public class DocumentController {
	private DocumentService documentService;

	@Autowired
	public DocumentController(DocumentService documentService) {
		this.documentService = documentService;
	}

	/**
	 * responsible for mapping the list of all document types
	 */
	@RequestMapping(value = "api/docs", method = RequestMethod.GET)
	public List<DocumentView> all(){
		return documentService.getAllDocumentTypes();
	}


}
