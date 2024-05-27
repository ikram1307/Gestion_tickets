package com.Gst_tickets.Gst_tickets.Repository;

import com.Gst_tickets.Gst_tickets.Entities.Evenement;
import com.Gst_tickets.Gst_tickets.Entities.Organisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvenementRepo extends JpaRepository<Evenement,Long> {
}
