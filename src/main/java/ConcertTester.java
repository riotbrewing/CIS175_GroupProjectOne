import java.time.LocalDate;
import java.util.List;

import controller.ConcertHelper;
import controller.VenueHelper;
import model.Concert;
import model.Venue;

/**
 * @author  Andrew Steele aeste - aesteele
 * CIS175 - Fall 2021
 * Feb 26, 2023
 */
public class ConcertTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// create  venue object
		Venue testOne = new Venue("Test Venue", "1111 Main Street");
		Venue testTwo = new Venue("Test Venue Two", "2222 Second Blvd");
		Venue testThree = new Venue("Test Venue Three", "3333 Third Ave");
		//create a data access object
		VenueHelper dao = new VenueHelper();
		//add the objects to the database
		dao.addVenue(testOne);
		dao.addVenue(testTwo);
		dao.addVenue(testThree);
		//create a new date
		LocalDate date = LocalDate.of(2023, 5, 1);
		LocalDate dateTwo = LocalDate.of(2023, 7, 3);
		LocalDate dateThree = LocalDate.of(2023, 9, 28);
		//create a new concert Object
		Concert concertTestOne = new Concert(testOne, "NOFX", "Punk", date);
		Concert concertTestTwo = new Concert(testTwo, "The Linda Lindas", "Punk", dateTwo);
		Concert concertTestThree = new Concert(testThree, "The Aquabats", "SKA", dateThree);
		//create a concert dao and add then view all of the objects
		ConcertHelper concertDao = new ConcertHelper();
		concertDao.addConcert(concertTestOne);
		concertDao.addConcert(concertTestTwo);
		concertDao.addConcert(concertTestThree);
		
		List<Concert> allConcerts = concertDao.viewAllConcerts();
		
		for(Concert x : allConcerts)
		{
			System.out.println(x);
		}
		
		//delete an item the output the new list
		
		concertDao.deleteConcert(concertTestOne);
		
		List<Concert> allConcertsTwo = concertDao.viewAllConcerts();
		
		for(Concert x : allConcertsTwo)
		{
			System.out.println(x);
		}
		
	}

}
