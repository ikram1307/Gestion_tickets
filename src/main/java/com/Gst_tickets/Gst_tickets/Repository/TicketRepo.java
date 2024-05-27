package com.Gst_tickets.Gst_tickets.Repository;

import com.Gst_tickets.Gst_tickets.Entities.Organisateur;
import com.Gst_tickets.Gst_tickets.Entities.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepo extends JpaRepository<Tickets,Long> {
}
