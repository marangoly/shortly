package com.neueda.shortly.dao;

import java.net.URL;
import java.util.List;

import com.neueda.shortly.entity.Url;

public interface UrlShortnerDAO {

	//method to find long url from short code
	public Url find(String urlCode);
	
	public List<Url> getUrlList();

	public Url getShortUrl(Url theUrl);
	
	public Url saveShortUrl(Url theUrl);

	public int getLastId();
	
	public Url getLongUrl(String shortCode);
	
}
