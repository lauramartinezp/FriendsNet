package com.everis.alicante.courses.beca.summer17.friendsnet.controller;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.PersonManager;

@RestController
@RequestMapping("/persons")
@Transactional
public class PersonController {

	@Autowired
	private PersonManager manager;

	@GetMapping
	public List<Person> getAll() {
		return (List<Person>) manager.findAll();
	}

	@GetMapping("/{id}")
	public Person getById(@PathVariable Long id) {
		return manager.findById(id);
	}

	@PostMapping
	public Person create(@RequestBody final Person person) {
		return manager.save(person);
	}

	@PostMapping("/{id}/relate")
	public Person relate(@PathVariable Long id,@RequestBody List<Long> ids) {
		return manager.relatePersons(id, ids);
	}

	@DeleteMapping("/{id}")
	public void remove(@PathVariable Long id) {
		manager.remove(manager.findById(id));
	}
}
