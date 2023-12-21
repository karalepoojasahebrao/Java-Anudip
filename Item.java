package com.anudip.BuyGiftCardProject;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.cfg.Configuration;

@Entity
@Table(name="Item")
public class Item {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemid;
	
	
	@Column(name="Category",length=50)
	private String category;
	
	@Column(name="ItemName",length=50)
	private String itemname;
	
	@Column(name="ItemPrice",length=10)
	private int itemprice;
	
	@Column(name="ItemQuantity",length=50)
	private int itemquantity;
	
	@Column(name="Review",length=50)
	private String review;
	
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	 Order order;
	

	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public int getItemprice() {
		return itemprice;
	}
	public void setItemprice(int itemprice) {
		this.itemprice = itemprice;
	}
	
	public int getItemquantity() {
		return itemquantity;
	}
	public void setItemquantity(int itemquantity) {
		this.itemquantity = itemquantity;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Item(int itemid, String category, String itemname, int itemprice, int itemquantity, String review) {
		super();
		this.itemid = itemid;
		this.category = category;
		this.itemname = itemname;
		this.itemprice = itemprice;
		this.itemquantity = itemquantity;
		this.review = review;
		
	}
	
	
	
}
