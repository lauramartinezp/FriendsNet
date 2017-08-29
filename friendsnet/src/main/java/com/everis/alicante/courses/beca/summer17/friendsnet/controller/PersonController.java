package com.everis.alicante.courses.beca.summer17.friendsnet.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.PersonManager;

@RestController
@RequestMapping("/person")
@Transactional
public class PersonController {

	@Autowired
	private PersonManager manager;

	@GetMapping
	public List<Person> getAll() {
		return (List<Person>) manager.findAll();
	}

	@GetMapping("/{id}")
	public Person getById(@RequestParam Long id) {
		return manager.findOne(id);
	}

	@PostMapping
	public Person create(@RequestBody Person p) {
		return manager.save(p);
	}

	@PostMapping("/{id}/relate")
	public Person relate(@PathVariable Long id, @RequestBody List<Long> persons) {
		return manager.relatePersons(id, persons);
	}

	@DeleteMapping("/{id}")
	public void remove(Long id) {
		manager.delete(manager.findOne(id));
	}

}