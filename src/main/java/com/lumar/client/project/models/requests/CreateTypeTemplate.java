package com.lumar.client.project.models.requests;

public class CreateTypeTemplate {

	private Long parentId;
	private TypeTemplate type;

	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public TypeTemplate getType() {
		return type;
	}
	public void setType(TypeTemplate type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "SubTypeTemplate [parentId=" + parentId + ", type=" + type + "]";
	}
}
