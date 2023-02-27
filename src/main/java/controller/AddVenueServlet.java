package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Venue;

/**
 * Servlet implementation class AddVenueServlet
 */
@WebServlet("/addVenueServlet")
public class AddVenueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVenueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//set the venue parameters
		String venueName = request.getParameter("addVenueName");
		String venueAddress = request.getParameter("addVenueAddress");
		//create a new venue object and add it to the database
		Venue addNewVenue = new Venue(venueName, venueAddress);
		VenueHelper dao = new VenueHelper();
		
		dao.addVenue(addNewVenue);
		
		getServletContext().getRequestDispatcher("/manage_venue_add.jsp").forward(request, response);
	}

}
