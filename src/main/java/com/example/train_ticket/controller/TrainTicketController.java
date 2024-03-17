package com.example.train_ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.train_ticket.dto.PurchaseRequest;
import com.example.train_ticket.dto.Ticket;
import com.example.train_ticket.service.TicketService;

import java.util.Map;

@RestController
@RequestMapping("/trainTicket")
public class TrainTicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/purchase")
    public ResponseEntity<String> purchaseTicket(@RequestBody PurchaseRequest request) {
        ticketService.purchaseTicket(new Ticket(request.getFrom(), request.getTo(), request.getUser(),request.getPrice_paid()));
        return ResponseEntity.status(HttpStatus.CREATED).body("Ticket purchased successfully.");
    }

    @GetMapping("/receipt/{email}")
    public ResponseEntity<Ticket> getReceipt(@PathVariable String email) {
        Ticket ticket = ticketService.getReceipt(email);
        if (ticket == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ticket);
    }

    @GetMapping("/users/{section}")
    public ResponseEntity<Map<String, String>> getUsersBySection(@PathVariable String section) {
        Map<String, String> usersBySection = ticketService.getUsersBySection(section);
        return ResponseEntity.ok(usersBySection);
    }

    @DeleteMapping("/remove/{email}")
    public ResponseEntity<String> removeUser(@PathVariable String email) {
        ticketService.removeUser(email);
        return ResponseEntity.ok("User removed successfully.");
    }

    @PutMapping("/modify/{email}")
    public ResponseEntity<String> modifySeat(@PathVariable String email, @RequestParam String newSeat) {
        if(ticketService.modifySeat(email, newSeat))
        	return ResponseEntity.ok("Seat modified successfully.");
        return ResponseEntity.ok("Seat Not Available.");
    }
}
