package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Venue;

/**
 * Servlet implementation class ManageVenueEditServlet
 */
@WebServlet("/manageVenueEditServlet")
public class ManageVenueEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageVenueEditServlet() {
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
		VenueHelper dao = new VenueHelper();
		String venueName = request.getParameter("addVenueName");
		String venueAddress = request.getParameter("addVenueAddress");
		Integer holdId = Integer.parseInt(request.getParameter("id"));
		
		Venue venueUpdate = dao.searchForVenueById(holdId);
		venueUpdate.setVenueName(venueName);
		venueUpdate.setVenueAddress(venueAddress);
		
		dao.updateVenue(venueUpdate);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
