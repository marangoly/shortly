package com.neueda.shortly.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.neueda.shortly.entity.Url;

@Repository
public class UrlShortnerDAOImpl implements UrlShortnerDAO {

	
	// define field for entitymanager	
	private EntityManager entityManager;
			
	// set up constructor injection
	@Autowired
	public UrlShortnerDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public Url find(String urlCode) {
		// TODO Auto-generated method stub
		return new Url();
	}


	@Override
	public List<Url> getUrlList() {
	
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// create a query
		Query<Url> theQuery =
				currentSession.createQuery("from Url", Url.class);
			
		// execute query and get result list
		List<Url> urlList = theQuery.getResultList();
				
		// return the results		
		return urlList;	
		
	}

	@Override
	public Url getShortUrl(Url theUrl) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// create a query
		Query<Url> theQuery =
				currentSession.createQuery("from Url where long_url = ?1");
		
		// execute query and get result list
		Url url = theQuery.setParameter(1,theUrl.getLongUrl()).uniqueResult();
		
		System.out.println(url);
		
		// return the results		
		return url;	
		
	}
	
	@Override
	public Url saveShortUrl(Url theUrl) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		// save employee
		currentSession.saveOrUpdate(theUrl);
		
		return theUrl;
	}

	@Override
	public int getLastId() {
		
		int lastId;
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// create a query
		Url url = (Url) currentSession.createQuery("from Url ORDER BY id DESC").setMaxResults(1).uniqueResult();
		
		if(url == null) {
			lastId = 1;
		} else {
			lastId = url.getId();
		}
		
		return lastId;
	}
	
	@Override
	public Url getLongUrl(String shortCode) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// create a query
		Query<Url> theQuery =
				currentSession.createQuery("from Url where short_code = ?1");
		
		
		// execute query and get result list
		Url url = theQuery.setParameter(1,shortCode).uniqueResult();
		
		System.out.println(url);
		
		// return the results		
		return url;	
	}

}
