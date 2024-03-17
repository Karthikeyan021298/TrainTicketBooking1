package com.example.train_ticket.dto;

public class PurchaseRequest {
    private String from;
    private String to;
    private User user;
    private int price_paid;
   
    
    public int getPrice_paid() {
		return price_paid;
	}


	public void setPrice_paid(int price_paid) {
		this.price_paid = price_paid;
	}


	public PurchaseRequest() {
    	
    }


    public PurchaseRequest(String from, String to, User user, int price_paid) {
    	this.from = from;
        this.to = to;
        this.user = user;
        this.price_paid= price_paid;
    }

	public static void setCount(int count) {
		Ticket.count = count;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
