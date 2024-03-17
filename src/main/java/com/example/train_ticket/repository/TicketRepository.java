package com.example.train_ticket.repository;

import java.util.Map;

import com.example.train_ticket.dto.Ticket;

public interface TicketRepository {

	
	public void saveTicket(Ticket ticket);

    public Ticket findTicketByEmail(String email);

    public Map<String, String> getUsersBySection(String section);

    public void removeTicketByEmail(String email);

    public boolean modifySeatByEmail(String email, String newSeat);
}
