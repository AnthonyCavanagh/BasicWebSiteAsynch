package com.lumar.client.project.models.responses;

import java.util.ArrayList;
import java.util.List;

import com.lumar.client.project.models.data.Field;

public class Fields {

	private Long typeId;
	private List <Field> fields = new ArrayList<Field> ();
	public Long getTypeId() {
		return typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	public List<Field> getFields() {
		return fields;
	}
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
}
