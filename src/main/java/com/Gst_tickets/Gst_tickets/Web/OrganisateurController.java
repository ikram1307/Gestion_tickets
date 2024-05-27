package com.Gst_tickets.Gst_tickets.Web;


import com.Gst_tickets.Gst_tickets.Repository.EvenementRepo;
import com.Gst_tickets.Gst_tickets.Service.OrganisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.Gst_tickets.Gst_tickets.Entities.Organisateur;
import com.Gst_tickets.Gst_tickets.Repository.OrganisateurRepo;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller

public class OrganisateurController {
    @Autowired
    EvenementRepo evenementRepo;
    @Autowired
    OrganisateurRepo organisateurRepo;
    @GetMapping("/ListOrg")
    public String ListOrg(Model model) {
        List<Organisateur> organisateurs=organisateurRepo.findAll();
        model.addAttribute("listOrganisateur",organisateurs);
        return "ListOrg";
    }
    @GetMapping("/delete")
    public String deleteOrga(Long id ){
      organisateurRepo.deleteById(id);
       return "redirect:/ListOrg";
    }
    @GetMapping("/AddOrg")
    public String formOrg(Model model) {
        model.addAttribute("listOrganisateur",new Organisateur());
        return "AddOrg";
    }
    @PostMapping("/save")
    public String SaveOrg(Model model, Organisateur o) {

        organisateurRepo.save(o);
        return "redirect:/ListOrg";
    }
    @GetMapping("/edit")
    public String editOrg(@RequestParam Long id, Model model) {
        System.out.println("ID: "+id);
        Organisateur org=organisateurRepo.findById(id).orElse(null);
        if(org==null) throw new RuntimeException("Organisateur introuvable");
        System.out.println(org.toString());
        model.addAttribute("organisateur",org);
        return "EditOrg";
    }
}
