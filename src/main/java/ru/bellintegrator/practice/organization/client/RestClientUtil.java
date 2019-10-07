package ru.bellintegrator.practice.organization.client;
import java.net.URI;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import ru.bellintegrator.practice.organization.model.Organization;

public class RestClientUtil {

	public void getArticleByIdDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/{id}";
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<Organization> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Organization.class, 5);
		Organization article = responseEntity.getBody();
		System.out.println("Id:"+article.getId()+ ", Name:"+article.getName()
		+ ", Category:"+article.getInn());      
	}
	public void getAllArticlesDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/organization";
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<Organization[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Organization[].class);
		Organization[] orgs = responseEntity.getBody();
		for(Organization org : orgs) {
			System.out.println("Id:"+org.getId()+", Title:"+org.getName()
			+ ", Category: "+ org.getInn());
		}
	}
	public void addArticleDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/api/organization";
		Organization org1 = new Organization();
		org1.setName("Spring REST Security using Hibernate");
		org1.setInn("Spring");
		HttpEntity<Organization> requestEntity = new HttpEntity<Organization>(org1, headers);
		URI uri = restTemplate.postForLocation(url, requestEntity);
		System.out.println(uri.getPath());    	
	}
	public void updateArticleDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/api/organization";
		Organization objArticle = new Organization();
		objArticle.setName("Update:Java Concurrency");
		objArticle.setInn("Java");
		HttpEntity<Organization> requestEntity = new HttpEntity<Organization>(objArticle, headers);
		restTemplate.put(url, requestEntity);
	}

	public static void main(String args[]) {
		RestClientUtil util = new RestClientUtil();
		util.getArticleByIdDemo();
		//util.getAllArticlesDemo();
		//util.addArticleDemo();
		//util.updateArticleDemo();
	}    
} 