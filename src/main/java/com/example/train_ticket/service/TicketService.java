package com.example.train_ticket.service;

import java.util.Map;

import com.example.train_ticket.dto.Ticket;

public interface TicketService {
	
	public void purchaseTicket(Ticket ticket);
	
    public Ticket getReceipt(String email);
    
    public Map<String, String> getUsersBySection(String section);
    
    public void removeUser(String email);
    
    public boolean modifySeat(String email, String newSeat);

}
