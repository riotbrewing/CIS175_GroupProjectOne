

import java.util.List;

import controller.VenueHelper;
import model.Venue;

/**
 * @author  Andrew Steele aeste - aesteele
 * CIS175 - Fall 2021
 * Feb 26, 2023
 */
public class VenueTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create three venue objects
		Venue testOne = new Venue("Test Venue", "1111 Main Street");
		Venue testTwo = new Venue("Test Venue Two", "2222 Backup Ave");
		Venue testThree = new Venue("Test Venue Thrww", "333 Third Street");
		//create a data access object
		VenueHelper dao = new VenueHelper();
		//add the objects to the database
		dao.addVenue(testOne);
		dao.addVenue(testTwo);
		dao.addVenue(testThree);
		//get all of the objects from the venue entity and output the results
		List<Venue> allVenueTest = dao.viewAllVenues();
		for(Venue x : allVenueTest)
		{
			System.out.println(x.toString());
		}
		//delete a object from the database and output again
		dao.deleteVenue(testTwo);
		List<Venue> allVenueTestTwo = dao.viewAllVenues();
		for(Venue x : allVenueTestTwo)
		{
			System.out.println(x.toString());
		}
	}

}
