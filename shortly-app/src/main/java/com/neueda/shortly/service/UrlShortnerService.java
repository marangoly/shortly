package com.neueda.shortly.service;

import java.util.List;

import com.neueda.shortly.entity.Url;

public interface UrlShortnerService {

	public List<Url> getUrlList();

	public Url getShortUrl(Url theUrl);
	
	public Url getLongUrl(String shortCode);
	
}
