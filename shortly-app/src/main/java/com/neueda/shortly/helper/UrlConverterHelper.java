package com.neueda.shortly.helper;

import com.neueda.shortly.entity.Url;

public class UrlConverterHelper {

	public static String convertUrl(Url theUrl, int nextId) {
		
		String charactersString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		char[] characterValues = charactersString.toCharArray();
		
		StringBuffer shortUrl = new StringBuffer();
		
		while(nextId>0) {
			int base62Digit = nextId % 62;
			shortUrl.append(characterValues[base62Digit]);
			nextId/=62;
		}
		
		return shortUrl.toString();
	}
	
}
