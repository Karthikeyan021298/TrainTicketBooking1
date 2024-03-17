package com.example.train_ticket.repository;

import org.springframework.stereotype.Repository;

import com.example.train_ticket.dto.Ticket;

import java.util.HashMap;
import java.util.Map;

@Repository
public class TicketRepositoryImpl  implements TicketRepository{

    private final Map<String, Ticket> tickets = new HashMap<String, Ticket>();
    private final Map<String, String> userToTicketId = new HashMap<String, String>();

    public void saveTicket(Ticket ticket) {
        tickets.put(ticket.getId(), ticket);
        userToTicketId.put(ticket.getUser().getEmail(), ticket.getId());
    }

    public Ticket findTicketByEmail(String email) {
        String ticketId = userToTicketId.get(email);
        return tickets.get(ticketId);
    }

    public Map<String, String> getUsersBySection(String section) {
        Map<String, String> usersBySection = new HashMap<String, String>();
        for (Ticket ticket : tickets.values()) {
            if (ticket.getSection().equalsIgnoreCase(section)) {
                usersBySection.put(ticket.getUser().getEmail(), ticket.getSeat());
            }
        }
        return usersBySection;
    }

    public void removeTicketByEmail(String email) {
        String ticketId = userToTicketId.get(email);
        tickets.remove(ticketId);
        userToTicketId.remove(email);
    }

    public boolean modifySeatByEmail(String email, String newSeat) {
    	
    	boolean available = true;
    	 for (Ticket ticket : tickets.values()) {
             if (ticket.getSeat().equalsIgnoreCase(newSeat)) {
                 available = false;
             }
         }
    	if(available) {
    		String ticketId = userToTicketId.get(email);
            Ticket ticket = tickets.get(ticketId);
            String count[] = newSeat.split("Seat");
            ticket.setSection((Integer.parseInt(count[1]) % 2 == 0 ? "A" : "B"));
            ticket.setSeat(newSeat);
            
            tickets.put(ticketId, ticket);
            return true;
    	}
      return false;
    }
    
    
}
