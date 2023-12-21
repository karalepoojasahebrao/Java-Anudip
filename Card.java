package com.anudip.BuyGiftCardProject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="Cart")
public class Card {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int cardid;
	
	@Column(name="CardName",length=50)
   private String cardname;
	
	@Column(name="OwnerName",length=50)
	private String ownername;
	
	@Column(name="CardCode",length=50)
	private int cardcode;
	
	
	public String getCardname() {
		return cardname;
	}
	public void setCardname(String cardname) {
		this.cardname = cardname;
	}
	public String getOwnername() {
		return ownername;
	}
	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}
	
	
	public int getCardid() {
		return cardid;
	}
	public void setCardid(int cardid) {
		this.cardid = cardid;
	}
	public int getCardcode() {
		return cardcode;
	}
	public void setCardcode(int cardcode) {
		this.cardcode = cardcode;
	}
	
	

	public Card(int cardid, String cardname, String ownername, int cardcode) {
		super();
		this.cardid = cardid;
		this.cardname = cardname;
		this.ownername = ownername;
		this.cardcode = cardcode;
		
	}
	
	
	
	

}
