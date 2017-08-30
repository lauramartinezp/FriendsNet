package com.everis.alicante.courses.beca.summer17.friendsnet.entity;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PostTest {
	
	private Post expectedPost;
	private Long expectedId = 1L;
	private String expectedText = "Hola";
	private Date expectedDate = null;
	private PostType expectedType = null;
	private byte[] expectedPicture = null;
	private Person expectedPerson;
	private Event expectedEvent;
	private Set<Like> expectedLikes = new HashSet<Like>();
	
	@Before
	public void init() {
		this.expectedPost = new Post();
		this.expectedPost.setId(expectedId);
		this.expectedPost.setText(expectedText);
		this.expectedPost.setCreationDate(expectedDate);
		this.expectedPost.setType(expectedType);
		this.expectedPost.setPicture(expectedPicture);
		this.expectedPost.setPostsByPerson(expectedPerson);
		this.expectedPost.setEvent(expectedEvent);
		this.expectedPost.setLikes(expectedLikes);
	}
	

	@Test
	public void testPost() {
		// Assert
		Assert.assertNotNull(expectedPost);
	}
	
	@Test
	public void testGetId() {
		// Act
		final Long result = this.expectedPost.getId();
		// Assert
		Assert.assertEquals(expectedId, result);
	}

	@Test
	public void testGetText() {
		//Act
		final String result = this.expectedPost.getText();
		//Assert
		Assert.assertEquals(expectedText, result);
	}

	@Test
	public void testGetCreationDate() {
		// Act
		final Date result = this.expectedPost.getCreationDate();
		// Assert
		Assert.assertEquals(expectedDate, result);
	}

	@Test
	public void testGetType() {
		// Act
		final PostType result = this.expectedPost.getType();
		// Assert
		Assert.assertEquals(expectedType, result);
	}

	@Test
	public void testGetPicture() {
		// Act
		final byte[] result = this.expectedPost.getPicture();
		// Assert
		Assert.assertEquals(expectedPicture, result);
	}

	@Test
	public void testGetPostsByPerson() {
		// Act
		final Person result = this.expectedPost.getPostsByPerson();
		// Assert
		Assert.assertEquals(expectedPerson, result);
	}

	@Test
	public void testGetEvent() {
		// Act
		final Event result = this.expectedPost.getEvent();
		// Assert
		Assert.assertEquals(expectedEvent, result);
	}

	@Test
	public void testGetLikes() {
		//Act
		final Set<Like> result = this.expectedPost.getLikes();
		//Assert
		Assert.assertEquals(expectedLikes, result);
	}

	@Test
	public void testSetId() {
		// Arrange
		final Post post = new Post();
		// Act
		post.setId(expectedId);
		// Assert
		Assert.assertEquals(expectedId, post.getId());
	}

	@Test
	public void testSetText() {
		// Arrange
		final Post post = new Post();
		// Act
		post.setText(expectedText);
		// Assert
		Assert.assertEquals(expectedText, post.getText());
	}

	@Test
	public void testSetCreationDate() {
		// Arrange
		final Post post = new Post();
		// Act
		post.setCreationDate(expectedDate);
		// Assert
		Assert.assertEquals(expectedDate, post.getText());
	}

	@Test
	public void testSetType() {
		// Arrange
		final Post post = new Post();
		// Act
		post.setType(expectedType);
		// Assert
		Assert.assertEquals(expectedType, post.getType());
	}

	@Test
	public void testSetPicture() {
		// Arrange
		final Post post = new Post();
		// Act
		post.setPicture(expectedPicture);
		// Assert
		Assert.assertEquals(expectedPicture, post.getPicture());
	}

	@Test
	public void testSetPostsByPerson() {
		// Arrange
		final Post post = new Post();
		// Act
		post.setPostsByPerson(expectedPerson);
		// Assert
		Assert.assertEquals(expectedPerson, post.getPostsByPerson());
	}

	@Test
	public void testSetEvent() {
		// Arrange
		final Post post = new Post();
		// Act
		post.setEvent(expectedEvent);
		// Assert
		Assert.assertEquals(expectedEvent, post.getEvent());
	}

	@Test
	public void testSetLikes() {
		// Arrange
		final Post post = new Post();
		// Act
		post.setLikes(expectedLikes);
		// Assert
		Assert.assertEquals(expectedLikes, post.getLikes());
	}

}
