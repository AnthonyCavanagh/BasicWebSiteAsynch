package com.lumar.client.project.models.view;

public class FieldView {

	private Long id;
	private String name;
	private String primitive;
    private String options;
    
    private Long typeId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrimitive() {
		return primitive;
	}

	public void setPrimitive(String primitive) {
		this.primitive = primitive;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	@Override
	public String toString() {
		return "FieldView [id=" + id + ", name=" + name + ", primitive=" + primitive + ", options=" + options
				+ ", typeId=" + typeId + "]";
	}
}
