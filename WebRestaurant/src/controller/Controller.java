package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Order;

/**
 * @author Joel Martinez-Gonzalez - jmartinezgonzale
 * CIS175 - Spring 2021
 * Feb 18, 2021
 */
public class Controller {
	static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("WebRestaurant");
	
	public void createOrder(Order order) {
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(order);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public List<Order> showOrders(){
		EntityManager em = emFactory.createEntityManager();
		List<Order> allOrders = em.createQuery("SELECT o FROM Order o").getResultList();
		return allOrders;
	}
	
	public void deleteOrder(Order order) {
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Order> typedQuery = em.createQuery("select o from Order o where o.name =:selectedName and o.food =:selectedFood", Order.class);
		 
		typedQuery.setParameter("selectedName", order.getName());
		typedQuery.setParameter("selectedFood", order.getFood());
		
		typedQuery.setMaxResults(1);
		
		Order result = typedQuery.getSingleResult();
				
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * @param name
	 * @return
	 */
	public List<Order> searchOrdersByName(String name) {
		// TODO Auto-generated method stub
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Order> orderList = em.createQuery("select o from Order o where o.name=:selectedName", Order.class);
		orderList.setParameter("selectedName", name);
		
		List<Order> foundOrder = orderList.getResultList();
		em.close();
		
		return foundOrder;
	}

	/**
	 * @param food
	 * @return
	 */
	public List<Order> searchOrderByFood(String food) {
		// TODO Auto-generated method stub
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Order> orderList = em.createQuery("select o from Order o where o.food=:selectedFood", Order.class);
		orderList.setParameter("selectedFood", food);
		
		List<Order> foundOrder = orderList.getResultList();
		em.close();
		
		return foundOrder;
	}

	/**
	 * @param idToEdit
	 * @return
	 */
	public Order searchByOrderById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		Order orderFound = em.find(Order.class, idToEdit);
		em.close();
		return orderFound;
		
	}

	/**
	 * @param order
	 */
	public void updateOrder(Order order) {
		// TODO Auto-generated method stub
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(order);
		em.getTransaction().commit();
		
		em.close();
		
	}

}
