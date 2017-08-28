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
import org.springframework.web.bind.annotation.RestController;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Group;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.GroupManager;

@RestController
@RequestMapping("/group")
@Transactional
public class GroupController {
	
	@Autowired
	private GroupManager manager;
	
	@GetMapping
	public List<Group> getAll(){
		return (List<Group>) manager.findAll();
	}
	
	@GetMapping("/{id}")
	public Group getById(@PathVariable Long id) {
		return manager.findById(id);
	}
	
	@PostMapping
	public Group create(@RequestBody Group e) {
		return manager.save(e);
	}
	
	public Group getByPersonId(Long string) {
		//ACABAR
		return null;
	}
	
	
	public Person relate(Long string, List<Long> strings) {
		//ACABAR
		return null;
	}
	
	@DeleteMapping("/{id}")
	public void remove(@PathVariable Long id) {
		manager.remove(manager.findById(id));
	}
}