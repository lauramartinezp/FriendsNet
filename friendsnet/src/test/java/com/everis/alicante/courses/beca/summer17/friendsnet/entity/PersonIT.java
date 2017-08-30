package com.everis.alicante.courses.beca.summer17.friendsnet.entity;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class PersonIT {
	
	private Person expectedPerson;

	private Long expectedId = 1L;

	private String expectedName = "Pepe";

	private String expectedSurname = "Gomez";

	private byte[] expectedPicture = null;

	private Set<Group> expectedGroups = new HashSet<Group>();

	private Set<Person> expectedPersons = new HashSet<Person>();

	private Set<Event> expectedEvents = new HashSet<Event>();

	private Set<Like> expectedLikes = new HashSet<>();

	private Set<Post> expectedPosts = new HashSet<>();

	@Before
	public void init() {
		this.expectedPerson = new Person();
		this.expectedPerson.setEvents(expectedEvents);
		this.expectedPerson.setGroups(expectedGroups);
		this.expectedPerson.setId(expectedId);
		this.expectedPerson.setLikes(expectedLikes);
		this.expectedPerson.setName(expectedName);
		this.expectedPerson.setSurname(expectedSurname);
		this.expectedPerson.setPicture(expectedPicture);
		this.expectedPerson.setPosts(expectedPosts);
	}


	@Test
	public void testPerson() {
		// Assert
		Assert.assertNotNull(expectedPerson);
	}
	
	@Test
	public void testGetId() {
		// Act
		final Long result = this.expectedPerson.getId();
		// Assert
		Assert.assertEquals(expectedId, result);
	}

	@Test
	public void testGetName() {
		// Act
		final String result = this.expectedPerson.getName();
		// Assert
		Assert.assertEquals(expectedName, result);
	}

	@Test
	public void testGetSurname() {
		// Act
		final String result = this.expectedPerson.getSurname();
		// Assert
		Assert.assertEquals(expectedSurname, result);
	}

	@Test
	public void testGetPicture() {
		// Act
		final byte[] result = this.expectedPerson.getPicture();
		// Assert
		Assert.assertEquals(expectedPicture, result);
	}

	//@Test
	//public void testGetPersons() {
		// Act
	//	final Set<Person> result = this.expectedPerson.getPersons();
	//	// Assert
	//	Assert.assertEquals(expectedPersons, result);
	//}

	

	@Test
	public void testGetGroups() {
		//Act
		final Set<Group> result = this.expectedPerson.getGroups();
		//Assert
		Assert.assertEquals(expectedGroups, result);
	}

	@Test
	public void testGetLikes() {
		//Act
		final Set<Like> result = this.expectedPerson.getLikes();
		//Assert
		Assert.assertEquals(expectedLikes, result);
	}

	@Test
	public void testGetPosts() {
		// Act
		final Set<Post> result = this.expectedPerson.getPosts();
		// Assert
		Assert.assertEquals(expectedPosts, result);
	}

	@Test
	public void testGetEvents() {
		// Act
		final Set<Event> result = this.expectedPerson.getEvents();
		// Assert
		Assert.assertEquals(expectedEvents, result);
	}

	@Test
	public void testSetId() {
		// Arrange
		final Person person = new Person();
		// Act
		person.setId(expectedId);
		// Assert
		Assert.assertEquals(expectedId, person.getId());

	}

	@Test
	public void testSetName() {
		// Arrange
		final Person person = new Person();
		// Act
		person.setName(expectedName);
		// Assert
		Assert.assertEquals(expectedName, person.getName());

	}

	@Test
	public void testSetSurname() {
		// Arrange
		final Person person = new Person();
		// Act
		person.setSurname(expectedSurname);
		// Assert
		Assert.assertEquals(expectedSurname, person.getSurname());

	}

	@Test
	public void testSetPicture() {
		// Arrange
		final Person person = new Person();
		// Act
		person.setPicture(expectedPicture);
		// Assert
		Assert.assertEquals(expectedPicture, person.getPicture());
	}

	//@Test
	//public void testSetPersons() {
		// Arrange
	//	final Person person = new Person();
		// Act
	//	person.setPersons(expectedPersons);
	//	// Assert
	//	Assert.assertEquals(expectedPersons, person.getPersons());
	//}


	@Test
	public void testSetGroups() {
		// Arrange
		final Person person = new Person();
		// Act
		person.setGroups(expectedGroups);
		// Assert
		Assert.assertEquals(expectedGroups, person.getGroups());
	}

	@Test
	public void testSetLikes() {
		// Arrange
		final Person person = new Person();
		// Act
		person.setLikes(expectedLikes);
		// Assert
		Assert.assertEquals(expectedLikes, person.getLikes());
	}

	@Test
	public void testSetPosts() {
		// Arrange
		final Person person = new Person();
		// Act
		person.setPosts(expectedPosts);
		// Assert
		Assert.assertEquals(expectedPosts, person.getPosts());
	}

	@Test
	public void testSetEvents() {
		// Arrange
		final Person person = new Person();
		// Act
		person.setEvents(expectedEvents);
		// Assert
		Assert.assertEquals(expectedEvents, person.getEvents());
	}


}
