package com.example.api.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;


@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	
	
	@GetMapping(value="/getApi")
	public ResponseEntity<?> getApi() {

		System.out.println("Methode is clalled");
String URL="http://data.bioontology.org/metadata/Ontology";
String API_KEY="7560431d-cc5c-4e02-9f81-c21bc60e8518";


RestTemplate restTemplate = new RestTemplate();
HttpHeaders headers = new HttpHeaders();
headers.setContentType(MediaType.APPLICATION_JSON);

headers.add("Authorization", "apikey token=" + API_KEY);

HttpEntity<String> entity = new HttpEntity<>( headers);

ResponseEntity<String> response=restTemplate.exchange(URL, HttpMethod.GET, entity, String.class);
		
	return new ResponseEntity<Object>(response,HttpStatus.FOUND);	
	}
	
	
	

}
