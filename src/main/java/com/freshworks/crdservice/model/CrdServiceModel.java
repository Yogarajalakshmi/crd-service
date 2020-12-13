package com.freshworks.crdservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.json.simple.JSONObject;

@Entity
public class CrdServiceModel {

	@Id
	@Column(name="key")
	private String key;
	
	private JSONObject value;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public JSONObject getValue() {
		return value;
	}
	public void setValue(JSONObject value) {
		this.value = value;
	}
	public CrdServiceModel(String key, JSONObject value) {
		super();
		this.key = key;
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "CrdServiceModel [key=" + key + ", value=" + value + "]";
	}
	
}
