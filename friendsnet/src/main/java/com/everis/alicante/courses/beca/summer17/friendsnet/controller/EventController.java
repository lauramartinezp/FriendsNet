package com.everis.alicante.courses.beca.summer17.friendsnet.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Event;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.EventManager;

@RestController
@RequestMapping("/event")
public class EventController {

	@Autowired
	EventManager manager;

	@GetMapping
	public List<Event> getAll() {
		List<Event> persons = (List<Event>) manager.findAll();
		return persons;
	}

	@GetMapping("/{id}")
	public Event getById(@RequestParam Long id) {
		return (Event) manager.findById(id);
	}

	@PostMapping
	public Event create(@RequestBody final Event event) {
		return manager.save(event);
	}

	@DeleteMapping("/{id}")
	public void remove(@RequestParam Long id) {
		manager.remove(manager.findById(id));
	}

}
