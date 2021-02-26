package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Order;

/**
 * Servlet implementation class AddOrderServlet
 */
@WebServlet("/addOrderServlet")
public class AddOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOrderServlet() {
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
		String name = request.getParameter("name");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String food = request.getParameter("food");
		String beverage = request.getParameter("beverage");
		
		int foodPrice = 5;
		int beveragePrice = 3;
		int total = (foodPrice + beveragePrice) * quantity;
		
		Order newOrder = new Order(name, quantity, food, beverage, total);
		Controller dao = new Controller();
		dao.createOrder(newOrder);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
