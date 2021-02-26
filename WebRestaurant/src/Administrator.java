import java.util.List;
import java.util.Scanner;

import controller.Controller;
import model.Order;

/**
 * @author Joel Martinez-Gonzalez - jmartinezgonzale
 * CIS175 - Spring 2021
 * Feb 18, 2021
 */
public class Administrator {
	static Scanner in = new Scanner(System.in);
	static Controller control = new Controller();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run();

	}
	
	public static void run() {
		boolean goAgain = true;
		System.out.println("Welcome to the Restaurant System");
		while(goAgain) {
		System.out.println("Enter the information about the order");
		
		System.out.println("--1-- For a new order");
		System.out.println("--2-- Edit an order");
		System.out.println("--3-- Delete an order");
		System.out.println("--4-- View all orders");
		int answer = in.nextInt();
		
		if(answer == 1) {
			addOrder();
		}else if(answer == 2) {
			editOrder();
		}else if(answer == 3) {
			deleteOrder();
		}else if(answer == 4) {
			showOrders();
		}
		}
	}
	
	/**
	 * 
	 */
	private static void editOrder() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to find the order");
		System.out.println("--1-- By name");
		System.out.println("--2-- By Food");
		int searching = in.nextInt();
		List<Order> orderFound;
		if(searching == 1) {
			System.out.println("Enter the name on the order: ");
			String name = in.next();
			 orderFound = control.searchOrdersByName(name);
		
		}else {
			System.out.println("Enter the Food ordered: ");
			String food = in.next();
			orderFound = control.searchOrderByFood(food);
		}
		if(!orderFound.isEmpty()) {
			System.out.println("Found Results.");
			for(Order order : orderFound) {
				System.out.println(order.getId() + order.returnDetails()); 
			}
			System.out.print("Which ID to edit" );
			int idToEdit = in.nextInt();
			
			Order order = control.searchByOrderById(idToEdit);
			System.out.println("Retrieved " + order.getName() + ", " + order.getFood());
			System.out.println("--1-- to Upadate name");
			System.out.println("--2-- to update quantity");
			System.out.println("--3-- to update food");
			System.out.println("--4-- to update beverage");
			int update = in.nextInt();
			
			if(update == 1) {
				System.out.println("Different Name: ");
				String newName = in.next();
				order.setName(newName);
			}else if(update == 2) {
				System.out.println("Different Quantity: ");
				int newQuantity = in.nextInt();
				order.setQuantity(newQuantity);
			}else if(update == 3) {
				System.out.println("Different Food: ");
				String newFood = in.next();
				order.setFood(newFood);
			}else if(update == 4) {
				System.out.println("Different Beverage: ");
				String newBeverage = in.next();
				order.setBeverage(newBeverage);
			}
			
			control.updateOrder(order);
			
		}else {
			System.out.println("----- No order found ---");
		}
	}

	/**
	 * 
	 */
	private static void deleteOrder() {
		// TODO Auto-generated method stub
		System.out.println("Enter the name on the order: ");
		String name = in.next();
		System.out.println("enter the food on the order: ");
		String food = in.next();
		Order order = new Order(name, food);
		control.deleteOrder(order);
		
	}

	/**
	 * 
	 */
	private static void showOrders() {
		// TODO Auto-generated method stub
		List<Order> allOrders = control.showOrders();
		for(Order order : allOrders) {
			System.out.println(order.returnDetails());
		}
		
	}

	public static void addOrder() {
		System.out.println("Enter the name for the order: ");
		String name = in.next();
		System.out.println("Enter the quantity: ");
		int quantity = in.nextInt();
		System.out.println("Enter the food: ");
		String food = in.next();
		System.out.println("Enter the beverage: ");
		String beverage = in.next();
		int foodPrice = 5;
		int beveragePrice = 3;
		int total = (foodPrice + beveragePrice) * quantity;
		System.out.println("Total is " + total);
		
		Order newOrder = new Order(name, quantity, food, beverage, total);
		control.createOrder(newOrder);
	}

}
