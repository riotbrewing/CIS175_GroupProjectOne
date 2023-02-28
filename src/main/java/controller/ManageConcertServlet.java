package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Concert;
import model.Venue;

/**
 * Servlet implementation class ManageConcertServlet
 */
@WebServlet("/manageConcertServlet")
public class ManageConcertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageConcertServlet() {
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
		// TODO Auto-generated method stub
		ConcertHelper dao = new ConcertHelper();
		String action = request.getParameter("doThisToItem");
		
		String path = "/manageConcertListServlet";
		
		if(action.equals("edit"))
		{
			try
			{
				Integer holdId = Integer.parseInt(request.getParameter("id"));
				Concert toEdit = dao.searchForVenueById(holdId);
				request.setAttribute("editItem", toEdit);
				path = "/manage_concert_edit.jsp";
				getServletContext().getRequestDispatcher(path).forward(request, response);
			}
			catch(NumberFormatException e)
			{
				System.out.println("Forgot to select an item");
				getServletContext().getRequestDispatcher(path).forward(request, response);
			}
		}
		else if(action.equals("delete"))
		{
			try
			{
				Integer holdId = Integer.parseInt(request.getParameter("id"));
				Concert toDelete = dao.searchForVenueById(holdId);
				dao.deleteConcert(toDelete);
				path = "/manageConcertListServlet";
				getServletContext().getRequestDispatcher(path).forward(request, response);
			}
			catch(NumberFormatException e)
			{
				System.out.println("Forgot to select an item");
				getServletContext().getRequestDispatcher(path).forward(request, response);
			}
		}
		else if(action.equals("add"))
		{
			path = "/manage_concert_add.jsp";
			getServletContext().getRequestDispatcher(path).forward(request, response);
		}
	
		
	}
	

}
