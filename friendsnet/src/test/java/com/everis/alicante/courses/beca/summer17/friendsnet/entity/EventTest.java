package com.everis.alicante.courses.beca.summer17.friendsnet.entity;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EventTest {
	
	private Event expectedEvent;
	private Long expectedId = 1L;
	private String expectedname = "Pepe";
	private Date expectedstartingDate = null;
	private Date expectedendingDate = null;
	private EventType expectedtype = null;
	private byte[] expectedpicture = null;
	private Set<Post> expectedPosts = new HashSet<Post>();

	private Set<Person> expectedPersons = new HashSet<Person>();
	
	@Before
	public void init() {
		this.expectedEvent = new Event();
		this.expectedEvent.setId(expectedId);
		this.expectedEvent.setName(expectedname);
		this.expectedEvent.setStartingDate(expectedstartingDate);
		this.expectedEvent.setEndingDate(expectedendingDate);
		this.expectedEvent.setType(expectedtype);
		this.expectedEvent.setPicture(expectedpicture);
		this.expectedEvent.setPosts(expectedPosts);
		this.expectedEvent.setPersonsEvent(expectedPersons);
		
	}
	

	@Test
	public void testEvent() {
		// Assert
		Assert.assertNotNull(expectedEvent);
	}
	
	@Test
	public void testGetId() {
		// Act
		final Long result = this.expectedEvent.getId();
		// Assert
		Assert.assertEquals(expectedId, result);
	}

	@Test
	public void testGetName() {
		// Act
		final String result = this.expectedEvent.getName();
		// Assert
		Assert.assertEquals(expectedname, result);
	}

	@Test
	public void testGetStartingDate() {
		// Act
		final Date result = this.expectedEvent.getStartingDate();
		// Assert
		Assert.assertEquals(expectedstartingDate, result);
	}

	@Test
	public void testGetEndingDate() {
		// Act
		final Date result = this.expectedEvent.getEndingDate();
		// Assert
		Assert.assertEquals(expectedendingDate, result);
	}

	@Test
	public void testGetType() {
		// Act
		final EventType result = this.expectedEvent.getType();
		// Assert
		Assert.assertEquals(expectedtype, result);
	}

	@Test
	public void testGetPicture() {
		// Act
		final byte[] result = this.expectedEvent.getPicture();
		// Assert
		Assert.assertEquals(expectedpicture, result);
	}

	@Test
	public void testGetPersonsEvent() {
		// Act
		final Set<Person> result = this.expectedEvent.getPersonsEvent();
		// Assert
		Assert.assertEquals(expectedPersons, result);
	}

	@Test
	public void testGetPosts() {
		// Act
		final Set<Post> result = this.expectedEvent.getPosts();
		// Assert
		Assert.assertEquals(expectedPosts, result);
	}

	@Test
	public void testSetId() {
		// Arrange
		final Event event = new Event();
		// Act
		event.setId(expectedId);
		// Assert
		Assert.assertEquals(expectedId, event.getId());
	}

	@Test
	public void testSetName() {
		// Arrange
		final Event event = new Event();
		// Act
		event.setName(expectedname);
		// Assert
		Assert.assertEquals(expectedname, event.getName());
	}

	@Test
	public void testSetStartingDate() {
		// Arrange
		final Event event = new Event();
		// Act
		event.setStartingDate(expectedstartingDate);
		// Assert
		Assert.assertEquals(expectedstartingDate, event.getStartingDate());
	}

	@Test
	public void testSetEndingDate() {
		// Arrange
		final Event event = new Event();
		// Act
		event.setEndingDate(expectedendingDate);
		// Assert
		Assert.assertEquals(expectedendingDate, event.getEndingDate());
	}

	@Test
	public void testSetType() {
		// Arrange
		final Event event = new Event();
		// Act
		event.setType(expectedtype);
		// Assert
		Assert.assertEquals(expectedtype, event.getType());
	}

	@Test
	public void testSetPicture() {
		// Arrange
		final Event event = new Event();
		// Act
		event.setId(expectedId);
		// Assert
		Assert.assertEquals(expectedId, event.getId());
	}

	@Test
	public void testSetPersonsEvent() {
		// Arrange
		final Event event = new Event();
		// Act
		event.setPersonsEvent(expectedPersons);
		// Assert
		Assert.assertEquals(expectedPersons, event.getPersonsEvent());
	}

	@Test
	public void testSetPosts() {
		// Arrange
		final Event event = new Event();
		// Act
		event.setPosts(expectedPosts);
		// Assert
		Assert.assertEquals(expectedPosts, event.getPosts());
	}

}
