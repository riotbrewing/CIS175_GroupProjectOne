package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainNavServlet
 */
@WebServlet("/mainNavServlet")
public class MainNavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainNavServlet() {
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
		
		String choice = request.getParameter("choice_selector");
		System.out.println(choice);
		
		String path = "/index.html";
		
		if(choice.equals("add_venue"))
		{
			//path to page for adding a venue
			path = "/manage_venue_add.jsp";
		}
		else if(choice.equals("edit_venue"))
		{
			//path to page for editing a venue
			
			path = "/manageVenueListServlet";
		}
		else if(choice.equals("delete_venue"))
		{
			//path to page for deleting a venue
			path = "/manageVenueListServlet";
		}
		else if(choice.equals("add_concert"))
		{
			//path to page for adding a concert
			path = "/manage_concert_add.jsp";
		}
		else if(choice.equals("edit_concert"))
		{
			//path to page for editing a concert
			path = "/manageConcertListServlet";
		}
		else if(choice.equals("delete_concert"))
		{
			//path to page for deleting a concert
			path = "/manageConcertListServlet";
		}
		else if(choice.equals("view_venues"))
		{
			//path to page for viewing all the venues
			path = "/manageVenueListServlet";
		}
		else if(choice.equals("view_concerts"))
		{
			//path to page for viewing all the concerts
			path = "/manageConcertListServlet";
		}
		else if(choice.equals("concerts_by_venue"))
		{
			//path to page for adding a viewing concerts based on venue
		}
		System.out.println(path);
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
