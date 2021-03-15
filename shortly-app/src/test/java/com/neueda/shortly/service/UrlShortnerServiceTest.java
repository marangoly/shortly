package com.neueda.shortly.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.neueda.shortly.dao.UrlShortnerDAOImpl;
import com.neueda.shortly.entity.Url;

@ExtendWith(MockitoExtension.class)
public class UrlShortnerServiceTest {

	@Mock
	UrlShortnerDAOImpl urlShortnerDAO;
	
	@InjectMocks
	UrlShortnerServiceImpl urlShortnerService;
	
	@Test
	public void whenShortCodeExistsRetunLongUrl() {
		String shortCode="b";
		Url url = new Url("b","https://google.com");
		Mockito.when(urlShortnerDAO.getLongUrl(shortCode)).thenReturn(url);
		assertEquals(url, urlShortnerService.getLongUrl(shortCode));
	}
	
	@Test
	public void whenShortCodeDoesNotExistsRetunNotFound() {
		String shortCode="asdaW";
		Mockito.when(urlShortnerDAO.getLongUrl(shortCode)).thenReturn(null);
		assertEquals(null, urlShortnerService.getLongUrl(shortCode));
	}
	
	@Test
	public void whenLongUrlShortenedExists() {
		Url url = new Url("","https://google.com");
		Url url_out = new Url("b","https://google.com");
		Mockito.when(urlShortnerDAO.getShortUrl(url)).thenReturn(url_out);
		assertEquals(url_out, urlShortnerService.getShortUrl(url));
	}
	
	@Test
	public void whenLongUrlShortenedDoesNotExists() {
		Url url = new Url("","https://google.com");
		Mockito.when(urlShortnerDAO.getShortUrl(url)).thenReturn(url);
		assertNotNull(urlShortnerDAO.getShortUrl(url).getShortCode());
	}
	
	
	
}
