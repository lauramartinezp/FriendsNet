package com.everis.alicante.courses.beca.summer17.friendsnet.controller;

import java.util.List;
import java.util.Set;

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
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Event;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Group;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.EventManager;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.PersonManager;

@RestController
@RequestMapping("/event")
@Transactional
public class EventController {

	@Autowired
	private EventManager manager;
	
	@Autowired
	private PersonManager personManager;

	@GetMapping
	public List<Event> getAll() {
		List<Event> persons = (List<Event>) manager.findAll();
		return persons;
	}

	@GetMapping("/{id}")
	public Event getById(@PathVariable Long id) {
		return (Event) manager.findOne(id);
	}

	@PostMapping
	public Event create(@RequestBody final Event event) {
		return manager.save(event);
	}

	@DeleteMapping("/{id}")
	public void remove(@PathVariable Long id) {
		manager.delete(manager.findOne(id));
	}
	
	@GetMapping("/person/{id}")
	public Set<Event> getByPersonId(@PathVariable Long id) {
		Person person = personManager.findOne(id);
		return person.getEvents();
	}
	
	@PostMapping("/{idEvent}/person/{idPerson}/add")
	public Event addPersons(@PathVariable Long idPerson, @PathVariable Long idEvent) {
		Person person = personManager.findOne(idPerson);
		Event event = manager.findOne(idEvent);
		event.getPersonsEvent().add(person);
		return manager.save(event);
	}

}