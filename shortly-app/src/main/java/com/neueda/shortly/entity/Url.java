package com.neueda.shortly.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="url")
public class Url {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="short_code")
	private String shortCode;
	
	@Column(name="long_url")
	private String longUrl;

	public Url() {
		super();
	}

	public Url(String shortCode, String longUrl) {
		super();
		this.shortCode = shortCode;
		this.longUrl = longUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public String getLongUrl() {
		return longUrl;
	}

	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}

	@Override
	public String toString() {
		return "Url [id=" + id + ", shortCode=" + shortCode + ", longUrl=" + longUrl + "]";
	}
	
	
	
	
}
