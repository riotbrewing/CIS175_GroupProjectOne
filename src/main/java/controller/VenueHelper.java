package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Venue;

/**
 * @author  Andrew Steele aeste - aesteele
 * CIS175 - Fall 2021
 * Feb 26, 2023
 */
public class VenueHelper {

	// create the global entity factory
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("GroupProject");
	
	/*
	 * @ void add a new Venue object to the database
	 */
	public void addVenue(Venue newVenue)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(newVenue);
		em.getTransaction().commit();
		em.close();
	}
	
	/*
	 * @ List return all of the Venues stored in the database
	 */
	public List<Venue> viewAllVenues()
	{
		EntityManager em = emfactory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Venue> allVenues = em.createQuery("SELECT i FROM Venue i").getResultList();
		return allVenues;
	}
	
	/*
	 * @ void delete the passed in Venue object
	 */
	public void deleteVenue(Venue toDelete)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Venue> typedQuery = em.createQuery("SELECT i FROM Venue i WHERE i.venueName = :selectedVenueName AND i.venueAddress = :selectedVenueAddress", Venue.class);
		//sub the parameter with the data from the passed in object
		typedQuery.setParameter("selectedVenueName", toDelete.getVenueName());
		typedQuery.setParameter("selectedVenueAddress", toDelete.getVenueAddress());
		//limit the results to one
		typedQuery.setMaxResults(1);
		//catch the result then delete from the database
		Venue result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	/*
	 * @ Venue uses the passed in parmeter to search through the database and return the selected object
	 */
	public Venue searchForVenueById(int toEdit)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Venue found = em.find(Venue.class, toEdit);
		em.close();
		return found;
	}
}
