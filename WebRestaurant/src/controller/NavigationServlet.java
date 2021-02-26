package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Order;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
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
		Controller dao = new Controller();
		String act = request.getParameter("doThisToOrder");
		String path = "/viewAllOrders";
		
		if(act.equals("Delete")){
			try {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Order newOrder = dao.searchByOrderById(tempId);
			dao.deleteOrder(newOrder);
			}catch(NumberFormatException e) {
				System.out.println("Forgot to select an Order");
			}
		}else if(act.equals("Edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Order newOrder = dao.searchByOrderById(tempId);
				request.setAttribute("orderToEdit", newOrder);
				path = "/edit-order.jsp";
				}catch(NumberFormatException e) {
					System.out.println("Forgot to select an Order");
				}
			
		}else if(act.equals("Add")) {
			path = "/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
				
		
	}

}
