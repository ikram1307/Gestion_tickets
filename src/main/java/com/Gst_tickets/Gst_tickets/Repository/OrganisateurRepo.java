package com.Gst_tickets.Gst_tickets.Repository;

import com.Gst_tickets.Gst_tickets.Entities.Organisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface OrganisateurRepo extends JpaRepository<Organisateur,Long> {


//    String getId();
}
