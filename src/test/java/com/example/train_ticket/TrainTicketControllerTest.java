package com.example.train_ticket;
import com.example.train_ticket.controller.TrainTicketController;
import com.example.train_ticket.dto.PurchaseRequest;
import com.example.train_ticket.dto.Ticket;
import com.example.train_ticket.dto.User;
import com.example.train_ticket.service.TicketService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TrainTicketControllerTest {

    @Mock
    private TicketService ticketService;

    @InjectMocks
    private TrainTicketController trainTicketController;

    @SuppressWarnings("deprecation")
	@BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPurchaseTicket() {
        PurchaseRequest request = new PurchaseRequest();
        request.setFrom("London");
        request.setTo("France");
        User user = new User();
        user.setFirstName("Karthikeyan");
        user.setLastName("Marimuthu");
        user.setEmail("mkarthikeyanlucky0212@gmail.com");
        request.setUser(user);

        ResponseEntity<String> response = trainTicketController.purchaseTicket(request);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void testGetReceipt() {
        Ticket ticket = new Ticket("Thanjavur", "Chennai", new User("Karthikeyan", "Marimuthu", "mkarthikeyanlucky0212@gmail.com"), 20);
        when(ticketService.getReceipt("mkarthikeyanlucky0212@gmail.com")).thenReturn(ticket);

        ResponseEntity<Ticket> response = trainTicketController.getReceipt("mkarthikeyanlucky0212@gmail.com");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ticket, response.getBody());
    }

    @Test
    public void testGetUsersBySection() {
        Map<String, String> usersBySection = new HashMap<>();
        usersBySection.put("mkarthikeyanlucky0212@gmail.com", "Seat1");
        when(ticketService.getUsersBySection("A")).thenReturn(usersBySection);

        ResponseEntity<Map<String, String>> response = trainTicketController.getUsersBySection("A");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(usersBySection, response.getBody());
    }

    @Test
    public void testRemoveUser() {
        ResponseEntity<String> response = trainTicketController.removeUser("mkarthikeyanlucky0212@gmail.com");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("User removed successfully.", response.getBody());
    }

    @Test
    public void testModifySeat() {
        ResponseEntity<String> response = trainTicketController.modifySeat("mkarthikeyanlucky0212@gmail.com", "Seat2");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Seat modified successfully.", response.getBody());
    }
}
