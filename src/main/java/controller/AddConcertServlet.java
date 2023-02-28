package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Concert;
import model.Venue;

/**
 * Servlet implementation class AddConcertServlet
 */
@WebServlet("/addConcertServlet")
public class AddConcertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddConcertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String venueName = request.getParameter("addLocationName");
		VenueHelper venueDAO = new VenueHelper();
		//search to see if the location exists and if not add it 
		Venue concertVenue = venueDAO.searchForVenueByName(venueName);
		venueDAO.addVenue(concertVenue);
		String bandName = request.getParameter("addBandName");
		String bandDescription = request.getParameter("addBandDescription");
		//catch the input from the date and set a localdate object
		String date = request.getParameter("addConcertDate");
		String day = "";
		String month = "";
		String year = "";
		System.out.println(date);
		//get the day month and year from the inputed string
		//convert to an array of char than  iterate and asssign the right values to the day month year variables
		char[] dateArray = date.toCharArray();
		for(int i = 0; i < dateArray.length; i++)
		{
			if(i < 4)
			{
				year += dateArray[i];
			}
			else if(i >=5 && i < 7)
			{
				month += dateArray[i];
			}
			else if(i >= 8)
			{
				day += dateArray[i];
			}
		}
		LocalDate concertDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		//System.out.println(month);
		//System.out.println(day);
		//System.out.println(year);
		Concert newConcert = new Concert(concertVenue, bandName, bandDescription, concertDate);
		ConcertHelper concertDAO = new ConcertHelper();
		concertDAO.addConcert(newConcert);
		
		getServletContext().getRequestDispatcher("/manage_concert_add.jsp").forward(request, response);
	}

}
