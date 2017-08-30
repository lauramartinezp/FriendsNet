package com.everis.alicante.courses.beca.summer17.friendsnet.DAO;


import java.util.List;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.GroupDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Group;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
public class GroupDAOIT {

	@Autowired
	GroupDAO dao;
	
	private ObjectMapper mapper;


	@Before
	public void setup() {
		this.mapper = new ObjectMapper();
	}
	
	@Test
	@DatabaseSetup("/initial-group.xml")
	public void testFindAll() throws JSONException {
		// Act
		List<Group> all = (List<Group>) dao.findAll();
		// Assert
		Assert.assertEquals(3, all.size());
	}
	
	@Test
	@DatabaseSetup("/initial-group.xml")
	public void testSaveGroup() throws JSONException {
		// Arrange
		final Group group = new Group();
		group.setName("Lucas");
		// Act
		dao.save(group);
		// Assert
		List<Group> all = (List<Group>) dao.findAll();
		Assert.assertEquals(4, all.size());
	}
	@Test
	@DatabaseSetup("/initial-group.xml")
	@ExpectedDatabase(value = "/remove-group.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testRemoveEvent() throws JSONException {
		//Act
		dao.delete((long) 2);
		//Assert
		List<Group> all = (List<Group>) dao.findAll();
		Assert.assertEquals(2, all.size());
		
	}

}
