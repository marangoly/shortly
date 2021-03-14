package com.neueda.shortly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neueda.shortly.dao.UrlShortnerDAO;
import com.neueda.shortly.entity.Url;
import com.neueda.shortly.helper.UrlConverterHelper;

@Service
public class UrlShortnerServiceImpl implements UrlShortnerService {

	private UrlShortnerDAO urlShortnerDAO;
	
	@Autowired
	public UrlShortnerServiceImpl(UrlShortnerDAO theUrlShortnerDAO) {
		urlShortnerDAO = theUrlShortnerDAO;
	}
	
	@Override
	@Transactional
	public List<Url> getUrlList() {
		return urlShortnerDAO.getUrlList();
	}

	@Override
	@Transactional
	public Url getShortUrl(Url theUrl) {
		
		String shortCode;
		
		Url url = urlShortnerDAO.getShortUrl(theUrl);
		
		if(url==null) {
			int lastId = urlShortnerDAO.getLastId();
			int nextId = lastId+1;
			
			shortCode = UrlConverterHelper.convertUrl(theUrl, nextId);
			theUrl.setShortCode(shortCode);
			
			return urlShortnerDAO.saveShortUrl(theUrl);
		}
		else {
			return url;
		}
	}
	
	@Override
	public Url getLongUrl(String shortCode) {
		
		Url url = urlShortnerDAO.getLongUrl(shortCode);
		
		return url;
	}

}
