package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Joel Martinez-Gonzalez - jmartinezgonzale
 * CIS175 - Spring 2021
 * Feb 18, 2021
 */

@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="QUANTITY")
	private int quantity;
	@Column(name="FOOD")
	private String food;
	@Column(name="BEVERAGE")
	private String beverage;
	@Column(name="TOTAL")
	private int total;
	
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	public Order(String name, String food) {
		super();
		this.name = name;
		this.food = food;
	}




	public Order(String name, int quantity, String food, String beverage, int total) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.food = food;
		this.beverage = beverage;
		this.total = total;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getFood() {
		return food;
	}


	public void setFood(String food) {
		this.food = food;
	}


	public String getBeverage() {
		return beverage;
	}


	public void setBeverage(String beverage) {
		this.beverage = beverage;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}
	
	public String returnDetails(){
		return name + ", " + quantity + ", " + food + ", " + beverage + ", " + total;
	}
	
	
	
	

}
