package com.everis.alicante.courses.beca.summer17.friendsnet.entity;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LikeTest {
	
	private Like expectedLike;
	private Long expectedId = 1L;
	private Date expectedDate = null;
	private LikeType expectedType = null;
	private Person expectedPerson;
	private Post expectedPost;
	
	@Before
	public void init() {
		this.expectedLike = new Like();
		this.expectedLike.setId(expectedId);
		this.expectedLike.setCreationDate(expectedDate);
		this.expectedLike.setType(expectedType);
		this.expectedLike.setLikesByPerson(expectedPerson);
		this.expectedLike.setLikesByPost(expectedPost);
	}
	
	
	@Test
	public void testLike() {
		// Assert
		Assert.assertNotNull(expectedLike);
	}

	@Test
	public void testGetId() {
		// Act
		final Long result = this.expectedLike.getId();
		// Assert
		Assert.assertEquals(expectedId, result);
	}

	@Test
	public void testGetCreationDate() {
		// Act
		final Date result = this.expectedLike.getCreationDate();
		// Assert
		Assert.assertEquals(expectedDate, result);
	}

	@Test
	public void testGetType() {
		// Act
		final LikeType result = this.expectedLike.getType();
		// Assert
		Assert.assertEquals(expectedType, result);
	}

	@Test
	public void testGetLikesByPerson() {
		//Act
		final Person result = this.expectedLike.getLikesByPerson();
		//Assert
		Assert.assertEquals(expectedPerson, result);
		
	}

	@Test
	public void testGetLikesByPost() {
		//Act
		final Post result = this.expectedLike.getLikesByPost();
		//Asset
		Assert.assertEquals(expectedPost, result);
	}

	@Test
	public void testSetId() {
		// Arrange
		final Like like = new Like();
		// Act
		like.setId(expectedId);
		// Assert
		Assert.assertEquals(expectedId, like.getId());
		
	}

	@Test
	public void testSetCreationDate() {
		// Arrange
		final Like like = new Like();
		// Act
		like.setCreationDate(expectedDate);
		//Assert
		Assert.assertEquals(expectedDate, like.getCreationDate());
	}

	@Test
	public void testSetType() {
		// Arrange
		final Like like = new Like();
		// Act
		like.setType(expectedType);
		//Assert
		Assert.assertEquals(expectedType, like.getType());
	}

	@Test
	public void testSetLikesByPerson() {
		// Arrange
		final Like like = new Like();
		// Act
		like.setLikesByPerson(expectedPerson);
		//Assert
		Assert.assertEquals(expectedPerson, like.getLikesByPerson());
		
	}

	@Test
	public void testSetLikesByPost() {
		// Arrange
		final Like like = new Like();
		// Act
		like.setLikesByPost(expectedPost);
		//Assert
		Assert.assertEquals(expectedPost, like.getLikesByPost());
	}



}
