package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Order;

/**
 * Servlet implementation class EditOrderServlet
 */
@WebServlet("/editOrderServlet")
public class EditOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditOrderServlet() {
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
		
		String name = request.getParameter("name");
		Integer quantity = Integer.parseInt(request.getParameter("quantity"));
		String food = request.getParameter("food");
		String beverage = request.getParameter("beverage");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Order updateOrder = dao.searchByOrderById(tempId);
		updateOrder.setName(name);
		updateOrder.setQuantity(quantity);
		updateOrder.setBeverage(beverage);
		
		dao.updateOrder(updateOrder);
		
		getServletContext().getRequestDispatcher("/viewAllOrders").forward(request, response);
		
	}

}