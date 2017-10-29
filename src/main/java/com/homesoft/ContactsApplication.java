package com.homesoft;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.homesoft.dao.ContactRepository;
import com.homesoft.dao.entities.Contact;

@SpringBootApplication
public class ContactsApplication implements CommandLineRunner{

	@Autowired
	private ContactRepository contactRepository;
	public static void main(String[] args) {
		SpringApplication.run(ContactsApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
//		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//		contactRepository.save(new Contact("ahmed","ben", df.parse("08/12/1987"),"ahmed.ben.amor87@gmail.com","11","ahmed.png"));
//		contactRepository.findAll().forEach(c->{System.out.println(c.getNom());});
	}
}
