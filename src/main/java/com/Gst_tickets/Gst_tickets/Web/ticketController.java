package com.Gst_tickets.Gst_tickets.Web;

import com.Gst_tickets.Gst_tickets.Entities.Evenement;
import com.Gst_tickets.Gst_tickets.Entities.Tickets;
import com.Gst_tickets.Gst_tickets.Repository.EvenementRepo;
import com.Gst_tickets.Gst_tickets.Repository.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;


import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ticketController {
    @Autowired
    EvenementRepo evenementRepo;

    @GetMapping ("/buyTickets")
    public String showform() {
        return "buyTickets";
    }

    @GetMapping ("/index")
    public String index(Model model)
    {
        model.addAttribute("test","TEST");

        List<Evenement> evenements =  evenementRepo.findAll();
        System.out.println(evenements);
        //System.out.println(evenements.getFirst().toString());
        model.addAttribute("evenements", evenementRepo.findAll());

        return "index";
    }

    @GetMapping("/ticket")
    public String showtable() {
        return "ticket";
    }
    TicketRepo ticketRepo;
    @GetMapping("/buyTicket")
    public String getTicket(Model model) {
        // Retrieve the list of tickets from the repository
        List<Tickets> tickets = ticketRepo.findAll();

        // Ensure that each ticket has a date
        for (Tickets ticket : tickets) {
            if (ticket.getDate() == null) {
                // Set the date to the current time if it's null
                ticket.setDate(LocalDateTime.now());
            }
        }

        // Add the list of tickets to the model
        model.addAttribute("tickets", tickets);

        // Return the view name for displaying the list of tickets
        return "/ticket";
    }

    // Method to handle form submission and add a new ticket
    @PostMapping("/saveTicket")
    public String saveTicket(@ModelAttribute("tickets") Tickets ticket) {
        ticketRepo.save(ticket);
        return "redirect:/ticket";
    }
}


