package com.lumar.client.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lumar.client.project.models.data.Field;
import com.lumar.client.project.models.data.Type;
import com.lumar.client.project.models.requests.CreateTypeTemplate;
import com.lumar.client.project.models.requests.FieldsByTypesRequests;
import com.lumar.client.project.models.requests.TypeRequest;
import com.lumar.client.project.models.requests.TypeTemplate;
import com.lumar.client.project.models.responses.Fields;
import com.lumar.client.project.models.responses.TypeResp;
import com.lumar.client.project.models.view.FieldView;
import com.lumar.client.project.remoteservice.AsynchRemoteWebService;
import com.lumar.client.project.remoteservice.RemoteWebService;

import java.net.URISyntaxException;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class BuildAProjectServiceImp implements BuildAProjectService{
	
	ConcurrentHashMap<Long, Type> typeMap = new ConcurrentHashMap<Long, Type>();

	
	@Autowired
	private AsynchRemoteWebService asynchRemoteService;
	
	@Autowired
	private RemoteWebService remoteService;
	
	private static final Logger logger = LoggerFactory.getLogger(BuildAProjectServiceImp.class);
	
	@Override
	public void buildAType(Type type){
		CreateTypeTemplate typeRequest = new CreateTypeTemplate();
		typeRequest.setParentId(type.getId());
		TypeTemplate tt = new TypeTemplate();
		tt.setId(type.getId());
		tt.setName(type.getName());
		typeRequest.setType(tt);
		typeMap.put(type.getId(), type);
		logger.info("buildAType sending "+typeRequest.toString());
		asynchRemoteService.createType(typeRequest);
	}
	
	@Override
	public void buildASubType(Type type){
		CreateTypeTemplate subTypeRequest = new CreateTypeTemplate();
		Type parentType = typeMap.get(type.getParentId());
		if(parentType != null) {
			type.getFields().addAll(parentType.getFields());
		}
		typeMap.put(type.getId(), type);
		
		subTypeRequest.setParentId(type.getParentId());
		TypeTemplate tt = new TypeTemplate();
		tt.setId(type.getId());
		tt.setName(type.getName());
		subTypeRequest.setType(tt);
		logger.info("buildASubType sending "+subTypeRequest.toString());
		asynchRemoteService.createType(subTypeRequest);
	}
	

	@Override
	public void buildAField(FieldView fieldView) {
		logger.info("Build a field "+fieldView.toString());
		Type type = typeMap.get(fieldView.getTypeId());
		Fields fields = new Fields();
		Field field = new Field();
		field.setId(fieldView.getId());
		field.setName(fieldView.getName());
		field.setOptions(fieldView.getOptions());
		field.setPrimitive(fieldView.getPrimitive());
		fields.setTypeId(fieldView.getTypeId());
		fields.getFields().add(field);
		if(type != null){
			type.getFields().add(field);
			typeMap.put(fieldView.getTypeId(), type);
		}
		asynchRemoteService.createFields(fields);
	}

	@Override
	public Type displayType(Long typeId) throws URISyntaxException {
		Type type = typeMap.get(typeId);
		if(type != null){
			return type;
		}
		//Type is not in the cache build up from Data Store
		TypeRequest request = new TypeRequest();
		request.setId(typeId);
		TypeResp resp = remoteService.getType(request);
		logger.info("Returning  "+resp.toString());
		FieldsByTypesRequests fieldRequest = new FieldsByTypesRequests();
		fieldRequest.setSubTypeId(typeId);
		fieldRequest.getTypeIds().addAll(resp.getParentId());
		Fields fieldResp = remoteService.getFields(fieldRequest);
		type = new Type();
		type.setId(resp.getId());
		type.setName(resp.getName());
		type.setFields(fieldResp.getFields());
		typeMap.put(typeId, type);
		return type;
	}
	
}
