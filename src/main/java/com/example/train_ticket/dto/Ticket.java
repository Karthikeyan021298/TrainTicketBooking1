package com.example.train_ticket.dto;

public class Ticket {
    static int count = 0;

    private String id;
    private String from;
    private String to;
    private User user;
    private int price_paid;
    private String section;
    private String seat;

    public Ticket(String from, String to, User user, int price_paid) {
        this.id = "T" + (++count);
        this.from = from;
        this.to = to;
        this.user = user;
        this.setPrice_paid(price_paid);
        this.section = count % 2 == 0 ? "A" : "B"; // Assigning sections alternatively
        this.seat = "Seat" + count;
    }

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Ticket.count = count;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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



	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public int getPrice_paid() {
		return price_paid;
	}

	public void setPrice_paid(int price_paid) {
		this.price_paid = price_paid;
	}


}