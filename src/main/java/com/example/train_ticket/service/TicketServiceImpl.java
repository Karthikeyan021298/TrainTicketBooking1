package com.example.train_ticket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.train_ticket.dto.Ticket;
import com.example.train_ticket.repository.TicketRepository;

import java.util.Map;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public void purchaseTicket(Ticket ticket) {
        ticketRepository.saveTicket(ticket);
    }

    public Ticket getReceipt(String email) {
        return ticketRepository.findTicketByEmail(email);
    }

    public Map<String, String> getUsersBySection(String section) {
        return ticketRepository.getUsersBySection(section);
    }

    public void removeUser(String email) {
        ticketRepository.removeTicketByEmail(email);
    }

    public boolean modifySeat(String email, String newSeat) {
    	
    	
        return ticketRepository.modifySeatByEmail(email, newSeat);
    }
}
