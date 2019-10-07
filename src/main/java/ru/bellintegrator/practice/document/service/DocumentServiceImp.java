package ru.bellintegrator.practice.document.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.bellintegrator.practice.document.dao.DocumentDao;
import ru.bellintegrator.practice.document.model.Document;
import ru.bellintegrator.practice.view.DocumentView;
@Service
@Transactional
public class DocumentServiceImp implements DocumentService {
	private final DocumentDao documentDao;

	@Autowired
	public DocumentServiceImp(DocumentDao documentDao) {
		this.documentDao = documentDao;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<DocumentView> getAllDocumentTypes() {
		return mapAllDocuments(documentDao.all());
	}

	/**
	 * Mapping objects into entities
	 * 
	 * @param docs
	 * @return
	 */
	private List<DocumentView> mapAllDocuments(List<Document> documents) {
		List<DocumentView> views = new ArrayList<>();
		for (Document doc : documents) {
			DocumentView dv = mapDoc(doc);
			views.add(dv);
		}
		return views;
	}

	/**
	 * Mapping an object into its entity
	 * 
	 * @param doc
	 * @return
	 */
	private DocumentView mapDoc(Document doc) {
		DocumentView dv = new DocumentView();
		dv.setCode(doc.getCode());
		dv.setName(doc.getName());
		return dv;
	}

}
