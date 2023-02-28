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
 * Servlet implementation class ManageConcertEditServlet
 */
@WebServlet("/manageConcertEditServlet")
public class ManageConcertEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageConcertEditServlet() {
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
		ConcertHelper concertDAO = new ConcertHelper();
		
		String venueName = request.getParameter("editVenueName");
		String venueAddress = request.getParameter("editVenueAddress");
		String bandName = request.getParameter("editBandName");
		String bandDescription = request.getParameter("editBandDescription");
		//catch the input from the date and set a local date object
		String date = request.getParameter("editConcertDate");
		String day = "";
		String month = "";
		String year = "";
		System.out.println(date + "in the edit servlet");
		//get the day month and year from the inputed string
		//convert to an array of char than  iterate and assign the right values to the day month year variables
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
		System.out.println(day + month + year);
		LocalDate concertDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		
		Integer holdId = Integer.parseInt(request.getParameter("id"));
		
		Concert concertUpdate = concertDAO.searchForVenueById(holdId);
		
		Venue holdVenue = concertUpdate.getLocationName();
		holdVenue.setVenueName(venueName);
		holdVenue.setVenueAddress(venueAddress);
		concertUpdate.setLocationName(holdVenue);
		concertUpdate.setBandName(bandName);
		concertUpdate.setBandDescription(bandDescription);
		concertUpdate.setConcertDate(concertDate);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		
	}

}
