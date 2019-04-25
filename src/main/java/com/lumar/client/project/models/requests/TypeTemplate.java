package com.lumar.client.project.models.requests;

import java.util.ArrayList;
import java.util.List;

public class TypeTemplate {

	private Long id;
	private String name;
	private List <Long>parentIs = new ArrayList<Long>();
	
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
	public List<Long> getParentIs() {
		return parentIs;
	}
	public void setParentIs(List<Long> parentIs) {
		this.parentIs = parentIs;
	}
	@Override
	public String toString() {
		return "TypeTemplate [id=" + id + ", name=" + name + ", parentIs=" + parentIs + "]";
	}
}
