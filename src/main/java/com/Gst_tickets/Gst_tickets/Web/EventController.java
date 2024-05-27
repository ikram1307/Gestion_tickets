package com.Gst_tickets.Gst_tickets.Web;



import com.Gst_tickets.Gst_tickets.Entities.Evenement;
import com.Gst_tickets.Gst_tickets.Repository.EvenementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class EventController {

    @Autowired
    EvenementRepo evenementRepo;

    // Method to display the list of events
    @GetMapping("/evenement")
    public String getEvent(Model model) {
        // Retrieve the list of events from the repository
        List<Evenement> evenements = evenementRepo.findAll();

        // Ensure that each event has a date
        for (Evenement evenement : evenements) {
            if (evenement.getDate() == null) {
                // Set the date to the current time if it's null
                evenement.setDate(LocalDateTime.now());
            }
        }

        // Add the list of events to the model
        model.addAttribute("evenement", evenements);

        // Return the view name for displaying the list of events
        return "/evenement";
    }

    // Method to handle form submission and add a new event
    @PostMapping("/saveEvent")
    public String saveEvent(@ModelAttribute("evenement") Evenement evenement, RedirectAttributes redirectAttributes) {
        // Save the event using your repository
        evenementRepo.save(evenement);
        redirectAttributes.addFlashAttribute("evenements", evenementRepo.findAll());
        // Redirect to the page displaying the list of events
        return "redirect:/index";
    }
}

