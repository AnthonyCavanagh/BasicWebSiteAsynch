package com.lumar.client.project.remoteservice;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lumar.client.project.models.requests.FieldsByTypesRequests;
import com.lumar.client.project.models.requests.TypeRequest;
import com.lumar.client.project.models.responses.Fields;
import com.lumar.client.project.models.responses.TypeResp;

@Service
public class RemoteWebService {
	
	private RestTemplate restTemplate;
	
	public RemoteWebService(RestTemplateBuilder templateBuilder){
		this.restTemplate = templateBuilder.build();
	}
	
	
	public TypeResp getType(TypeRequest request) throws URISyntaxException{
		URI uri = new URI ("http://localhost:8080/findType");
		RequestEntity <TypeRequest>requestEntity = new RequestEntity<TypeRequest>(request, HttpMethod.POST, uri);
		 ResponseEntity<TypeResp> type = restTemplate.exchange(requestEntity, TypeResp.class);
		return type.getBody();
	}
	
	public Fields getFields(FieldsByTypesRequests request) throws URISyntaxException{
		URI uri = new URI ("http://localhost:8080/findFieldsAncestors");
		RequestEntity <FieldsByTypesRequests>requestEntity = new RequestEntity<FieldsByTypesRequests>(request, HttpMethod.POST, uri);
		ResponseEntity<Fields> fields = restTemplate.exchange(requestEntity, Fields.class);
		return fields.getBody();
		
	}

}
