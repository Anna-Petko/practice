package ru.bellintegrator.practice.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

 
import ru.bellintegrator.practice.document.controller.DocumentController;
import ru.bellintegrator.practice.document.model.Document;
import ru.bellintegrator.practice.document.service.DocumentService;
import ru.bellintegrator.practice.view.DocumentView;

@RunWith(SpringRunner.class)
@WebMvcTest(DocumentController.class)
public class DocumentTest {

    @Autowired
    private EntityManager em;

    @Autowired
    private TestRestTemplate restTemplate;
   
    @MockBean DocumentService documentService;


	@Test
    public void getAllDocTypesTest() {
        ResponseEntity<List<DocumentView>> result = restTemplate.exchange("/api/docs", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<DocumentView>>() {
                });
        String stringQuery = "SELECT dt FROM DocType dt";
        TypedQuery<Document> query = em.createQuery(stringQuery, Document.class);
        List<Document> res = query.getResultList();
        Assert.assertEquals(res.size(), result.getBody().size());
        Assert.assertEquals(200, result.getStatusCodeValue());
    }

}
