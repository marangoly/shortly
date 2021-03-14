package com.neueda.shortly.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.neueda.shortly.entity.Url;
import com.neueda.shortly.service.UrlShortnerService;


@RestController
@CrossOrigin
@RequestMapping("api")
public class UrlShortnerRestController {

	private UrlShortnerService urlShortnerService;
	
	@Autowired
	public UrlShortnerRestController(UrlShortnerService theUrlShortnerService) {
		urlShortnerService = theUrlShortnerService;
	}
	
	@GetMapping("/urls")
	public List<Url> getUrlList(){
		return urlShortnerService.getUrlList();
	}
	
	@PostMapping("/urls")
	public Url getShortUrl(@RequestBody Url theUrl) {
		return urlShortnerService.getShortUrl(theUrl);
	}
	
	@GetMapping("/{shortCode}")
	public RedirectView getLongUrl(@PathVariable String shortCode){
		Url url = urlShortnerService.getLongUrl(shortCode);
		
		RedirectView redirectView = new RedirectView();
		if(url==null) {
			redirectView.setStatusCode(HttpStatus.NOT_FOUND);
			redirectView.setUrl("/");
		}
		else {
			redirectView.setUrl(url.getLongUrl());
		}
			
		return redirectView;
	}
	
}
