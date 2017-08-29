package com.everis.alicante.courses.beca.summer17.friendsnet.controller;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Post;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.PersonManager;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.PostManager;

@RestController
@RequestMapping("/post")
@Transactional
public class PostController {

	@Autowired
	private PostManager manager;
	
	@Autowired
	private PersonManager personManager;
	
	@GetMapping
	public List<Post> getAll(){
		return (List<Post>) this.manager.findAll();
	}
	@GetMapping("/{id}")
	public Post getById(@RequestParam Long id) {
		return this.manager.findById(id);
	}
	@PostMapping
	public Post create(@RequestBody Post e) {
		return this.manager.save(e);
	}
	@GetMapping("{/person/{id}")
	public Set<Post> getByPersonId(@RequestParam Long id) {
		Person person = this.personManager.findById(id);
		return person.getPosts();
	}
	@DeleteMapping("/{id}")
	public void remove(Long id) {
		this.manager.remove(this.manager.findById(id));
	}
	
	
}
