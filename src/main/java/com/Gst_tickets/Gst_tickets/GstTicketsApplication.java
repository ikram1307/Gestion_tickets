package com.Gst_tickets.Gst_tickets;

import com.Gst_tickets.Gst_tickets.Entities.Organisateur;
import com.Gst_tickets.Gst_tickets.Repository.OrganisateurRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GstTicketsApplication {


	public static void main(String[] args) {
		SpringApplication.run(GstTicketsApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(OrganisateurRepo organisateurRepo) {
		return args -> {
			organisateurRepo.save(new Organisateur(null,"ikram", "Samami", "ikram@gmail.com",065225415));
			organisateurRepo.save(new Organisateur(null,"zineb", "Harragui", "zineb@gmail.com",065221555));

			organisateurRepo.findAll().forEach(o -> {
				System.out.println(o.getId());
				System.out.println("Organisateur Details:");
				System.out.println("ID: " + o.getId());
				System.out.println("First Name: " + o.getNom());
				System.out.println("Last Name: " + o.getPrenom());
				System.out.println("Email: " + o.getEmail());
				System.out.println("Phone: " + o.getTel());

			});
		};
	}

}
