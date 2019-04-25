package com.lumar.client.project.remoteservice;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.AsyncRestTemplate;

import com.lumar.client.project.models.requests.CreateTypeTemplate;
import com.lumar.client.project.models.responses.Fields;

@Service
public class AsynchRemoteWebService {

	private final AsyncRestTemplate asynch = new AsyncRestTemplate();
	
	public void createType(CreateTypeTemplate template){
		HttpEntity<CreateTypeTemplate> request = new  HttpEntity<CreateTypeTemplate>(template);
		asynch.postForLocation("http://localhost:8080/createType", request);
	}
	
	public void createFields(Fields cf){
		HttpEntity<Fields> request = new  HttpEntity<Fields>(cf);
		asynch.postForLocation("http://localhost:8080/createFields", request);
	}
	
}
