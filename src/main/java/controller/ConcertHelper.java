package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Concert;

/**
 * @author  Andrew Steele aeste - aesteele
 * CIS175 - Fall 2021
 * Feb 26, 2023
 */
public class ConcertHelper {
	
	// create the global entity factory
		static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("GroupProject");
		
	/*
	 * @ void add the passed in Concert object to the database 
	 */
	public void addConcert(Concert newConcert)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(newConcert);
		em.getTransaction().commit();
		em.close();
	}
	
	/*
	 * @ List return a list of all of the Concert objects in the database
	 */
	public List<Concert> viewAllConcerts()
	{
		EntityManager em = emfactory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Concert> allConcerts = em.createQuery("SELECT i FROM Concert i").getResultList();
		return allConcerts;
	}
	
	/*
	 * @ void delete the pass in object from the database
	 */
	public void deleteConcert(Concert toDelete)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Concert> typedQuery = em.createQuery("SELECT i FROM Concert i WHERE i.locationName = :selectedLocationName AND i.bandName = :selectedBandName AND i.bandDescription = :selectedBandDescription AND i.concertDate = :selectedConcertDate", Concert.class);
		//sub the parameters with the data from the passed in object
		typedQuery.setParameter("selectedLocationName", toDelete.getLocationName());
		typedQuery.setParameter("selectedBandName", toDelete.getBandName());
		typedQuery.setParameter("selectedBandDescription", toDelete.getBandDescription());
		typedQuery.setParameter("selectedConcertDate", toDelete.getConcertDate());
		
		//limit the results to one
		typedQuery.setMaxResults(1);
		//catch the result then delete from the database
		Concert result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	/*
	 * @ Concert uses the passed in parmeter to search through the database and return the selected object
	 */
	public Concert searchForVenueById(int toEdit)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Concert found = em.find(Concert.class, toEdit);
		em.close();
		return found;
	}
	
	
}
