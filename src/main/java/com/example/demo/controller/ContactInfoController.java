package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ContactEntity;
import com.example.demo.props.AppProperties;
import com.example.demo.repository.ContactRepository;

@RestController
public class ContactInfoController {
	@Autowired
	ContactRepository repo;
	@Autowired
	AppProperties appPropsReader;
	
	//Map<String,String> appData=appPropsReader.getMessages();
	

	@GetMapping("/getContactList")
	public List<ContactEntity> getContactList() {
		ContactEntity ce = new ContactEntity();
		ce.setActiveSwitch("Y");
		// Example em=Example.of(ce);
		return repo.findAll(Example.of(ce));
	}

	@GetMapping("/getContactById/{contactId}")
	public ContactEntity getContactById(@PathVariable Integer contactId) {
		Optional<ContactEntity> optional = repo.findById(contactId);
		ContactEntity contactEntity = optional.get();
		return contactEntity;
	}

	@PostMapping("/contact")
	public String saveContact(@RequestBody ContactEntity contactEntity) {
		contactEntity.setActiveSwitch("Y");
		ContactEntity conEntity = repo.save(contactEntity);
		Map<String,String> mess=appPropsReader.getMessages();
		// if(repo.existsById(contactEntity.getContactId()))
		// { ContactEntity contactEntity2 = repo.save(contactEntity);
		if (conEntity.getContactId() != null) {
			return mess.get("contactsavesucces");
		} else {
			return mess.get("contactnotsuccess");

		}
	}

	@PostMapping("/deleteContact/{contactId}")
	public String deleteContact(@RequestParam Integer contactId) {

		if (repo.existsById(contactId)) {
			ContactEntity contactEntity = repo.getById(contactId);
			contactEntity.setActiveSwitch("N");
			ContactEntity contactEntity2 = repo.save(contactEntity);
			if (contactEntity2.getContactId() != null) {
				return "record deleted successfully";
			} else {
				return "record is not deleted";

			}

		}
		return null;
	}

	@PostMapping("/update")
	public String updateContact(@RequestBody ContactEntity contactEntity) {
		if (repo.existsById(contactEntity.getContactId())) {
			ContactEntity contactEntity2 = repo.save(contactEntity);

			if (contactEntity2.getContactId() != null) {
				return "contact updated successfully";
			}

		}
		return "record is not found in the database";
	}
}
