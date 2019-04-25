package com.lumar.client.project.services;


import java.net.URISyntaxException;

import com.lumar.client.project.models.data.Type;
import com.lumar.client.project.models.view.FieldView;

public interface BuildAProjectService {
	void buildAType(Type type);
	void buildASubType(Type type);
	void buildAField(FieldView fieldVuew);
	Type displayType(Long typeId) throws URISyntaxException;
	
}
