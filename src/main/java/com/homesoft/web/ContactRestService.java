package com.homesoft.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.homesoft.dao.ContactRepository;
import com.homesoft.dao.entities.Contact;

@RestController
@CrossOrigin("*")
public class ContactRestService {
	
	@Autowired
	private ContactRepository contactRepository;

	@RequestMapping(value="/contacts", method=RequestMethod.GET)
	public List<Contact> getContacts(){
		return contactRepository.findAll();
	}
	
	@RequestMapping(value="/contacts/{id}", method=RequestMethod.GET)
	public Contact getContact(@PathVariable Long id){
		return contactRepository.findOne(id);
	}
	
	@RequestMapping(value="/contacts", method=RequestMethod.POST)
	public Contact saveContact(@RequestBody Contact c){
		return contactRepository.save(c);
	}
	
	@RequestMapping(value="/contacts/{id}", method=RequestMethod.DELETE)
	public boolean deleteContact(@PathVariable Long id){
		contactRepository.delete(id);
		return true;
	}
	
	@RequestMapping(value="/contacts/{id}", method=RequestMethod.PUT)
	public Contact updateContact(@PathVariable Long id,@RequestBody Contact c){
		c.setId(id);
		return contactRepository.save(c);
	}
	
	@RequestMapping(value="/chercherContacts", method=RequestMethod.GET)
	public Page<Contact> chercherContacts(@RequestParam(name ="mc", defaultValue="")String mc,
			@RequestParam(name ="page", defaultValue="0")int page,
			@RequestParam(name ="size", defaultValue="5")int size
			){
		return contactRepository.chercher("%"+mc+"%", new PageRequest(page, size));
	}
	
}
