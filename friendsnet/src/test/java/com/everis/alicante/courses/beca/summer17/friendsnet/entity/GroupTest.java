package com.everis.alicante.courses.beca.summer17.friendsnet.entity;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GroupTest {
	
	private Group expectedGroup;
	private Long expectedId = 1L;
	private String expectedName = "Pepe";
	private byte[] expectedPicture = null;
	
	private Set<Person> expectedPersons = new HashSet<Person>();
	
	@Before
	public void init() {
		this.expectedGroup = new Group();
		this.expectedGroup.setId(expectedId);
		this.expectedGroup.setName(expectedName);
		this.expectedGroup.setPicture(expectedPicture);
		this.expectedGroup.setPersonsInGroup(expectedPersons);
	}
	

	@Test
	public void testGroup() {
		// Assert
				Assert.assertNotNull(expectedGroup);
	}
	
	@Test
	public void testGetId() {
		// Act
		final Long result = this.expectedGroup.getId();
		// Assert
		Assert.assertEquals(expectedId, result);
	}

	@Test
	public void testGetName() {
		// Act
		final String result = this.expectedGroup.getName();
		// Assert
		Assert.assertEquals(expectedName, result);
	}

	@Test
	public void testGetPicture() {
		// Act
		final byte[] result = this.expectedGroup.getPicture();
		// Assert
		Assert.assertEquals(expectedPicture, result);
	}

	@Test
	public void testGetPersonsInGroup() {
		//Act
		final Set<Person> result= this.expectedGroup.getPersonsInGroup();
		//Assert
		Assert.assertEquals(expectedPersons, result);
	}

	@Test
	public void testSetId() {

		// Arrange
		final Group group = new Group();
		// Act
		group.setId(expectedId);
		// Assert
		Assert.assertEquals(expectedId, group.getId());
	}

	@Test
	public void testSetName() {
		// Arrange
		final Group group = new Group();
		// Act
		group.setName(expectedName);;
		// Assert
		Assert.assertEquals(expectedName, group.getName());
	}

	@Test
	public void testSetPicture() {
		// Arrange
		final Group group = new Group();
		// Act
		group.setPicture(expectedPicture);
		// Assert
		Assert.assertEquals(expectedPicture, group.getPicture());
	}

	@Test
	public void testSetPersonsInGroup() {
		//Arrange
		final Group group = new Group();
		//Act
		group.setPersonsInGroup(expectedPersons);
		//Assert
		Assert.assertEquals(expectedPersons, group.getPersonsInGroup());
	}



}
