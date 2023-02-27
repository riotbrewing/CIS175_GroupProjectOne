package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Venue;

/**
 * Servlet implementation class ManageVenueServlet
 */
@WebServlet("/manageVenueServlet")
public class ManageVenueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageVenueServlet() {
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
		String action = request.getParameter("doThisToItem");
		
		String path = "/manageVenueListServlet";
		
		if(action.equals("edit"))
		{
			try
			{
				Integer holdId = Integer.parseInt(request.getParameter("id"));
				Venue toEdit = dao.searchForVenueById(holdId);
				request.setAttribute("editItem", toEdit);
				path = "/manage_venue_edit.jsp";
			}
			catch(NumberFormatException e)
			{
				System.out.println("Forgot to select an item");
			}
		}
		else if(action.equals("delete"))
		{
			try
			{
				Integer holdId = Integer.parseInt(request.getParameter("id"));
				Venue toDelete = dao.searchForVenueById(holdId);
				dao.deleteVenue(toDelete);
				path = "/manageVenueListServlet";
			}
			catch(NumberFormatException e)
			{
				System.out.println("Forgot to select an item");
			}
		}
		else if(action.equals("add"))
		{
			path = "/manage_venue_add.jsp";
		}
	
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}
}
