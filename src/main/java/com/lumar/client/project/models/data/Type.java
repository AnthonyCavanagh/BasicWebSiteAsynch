package com.lumar.client.project.models.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Type {
	
	private Long id;
	private String name;
	private Long parentId;
	private List <Field> fields = new ArrayList<Field>();
	private List <Asset> assets = new ArrayList<Asset>();
	private List <Keywords> Keywords  = new ArrayList<Keywords>(); 
	private List<Schema> schemas = new ArrayList<Schema>();
	private List<State> states = new ArrayList<State>();
	private List<View> views = new ArrayList<View>();
	private List<Affiliation> affiliates = new ArrayList<Affiliation>();
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
	
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public List<Field> getFields() {
		return fields;
	}
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
	public List<Asset> getAssets() {
		return assets;
	}
	public void setAssets(List<Asset> assets) {
		this.assets = assets;
	}
	public List<Keywords> getKeywords() {
		return Keywords;
	}
	public void setKeywords(List<Keywords> keywords) {
		Keywords = keywords;
	}
	public List<Schema> getSchemas() {
		return schemas;
	}
	public void setSchemas(List<Schema> schemas) {
		this.schemas = schemas;
	}
	public List<State> getStates() {
		return states;
	}
	public void setStates(List<State> states) {
		this.states = states;
	}
	public List<View> getViews() {
		return views;
	}
	public void setViews(List<View> views) {
		this.views = views;
	}
	public List<Affiliation> getAffiliates() {
		return affiliates;
	}
	public void setAffiliates(List<Affiliation> affiliates) {
		this.affiliates = affiliates;
	}
	@Override
	public String toString() {
		return "Type [id=" + id + ", name=" + name + ", parentId=" + parentId + ", fields=" + fields + ", assets="
				+ assets + ", Keywords=" + Keywords + ", schemas=" + schemas + ", states=" + states + ", views=" + views
				+ ", affiliates=" + affiliates + "]";
	}
	
    
}
