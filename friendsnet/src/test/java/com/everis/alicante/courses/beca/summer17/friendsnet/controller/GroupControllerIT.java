package com.everis.alicante.courses.beca.summer17.friendsnet.controller;


import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.GroupDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.dao.PersonDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Group;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class,
    TransactionalTestExecutionListener.class,
    DbUnitTestExecutionListener.class})
public class GroupControllerIT {
	
	@LocalServerPort
    private int port;
	
	@Autowired
	private GroupDAO dao;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    private ObjectMapper mapper;

    @Before
    public void setup() {
        this.mapper = new ObjectMapper();
//        Iterable<Person> persons = dao.findAll();
//        for (Person person : persons) {
//			dao.remove(person);
//		}
    }
    
    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

    @Test
    @DatabaseSetup("/initial-group.xml")
    @ExpectedDatabase(value = "/initial-group.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testFindAllWithContent() throws JSONException {
        //Arrange
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
       
        // Act
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/group"),
                HttpMethod.GET, null, String.class);
        // Assert
        JSONAssert.assertEquals("[{'id':1, 'name':'Pepe'}, {'id':2, 'name':'Jose'}, {'id':3, 'name':'Luis'}]", response.getBody(), false);
    }

	@Test
	@DatabaseSetup("/initial-group.xml")
	@ExpectedDatabase(value = "/initial-group.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testGetById() throws JSONException {
	     //Arrange
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
       
        // Act
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/group/2"),
                HttpMethod.GET, null, String.class);
        // Assert
        JSONAssert.assertEquals("{'id':2, 'name':'Jose'}", response.getBody(), false);
	}

	@Test
	@DatabaseSetup("/initial-group.xml")
	@ExpectedDatabase(value = "/create-group.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testCreate() throws JSONException {
		//Arrange
		Group group = new Group();
		group.setName("Pepito");
        HttpEntity<Group> entity = new HttpEntity<Group>(group, headers);
       
        // Act
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/group"),
                HttpMethod.POST, entity, String.class);

        // Assert
        JSONAssert.assertEquals("{'id':4, 'name':'Pepito'}", response.getBody(), false);
	}

//	@Test
//	public void testRelate() {
//		fail("Not yet implemented");
//	}

	@Test
	@DatabaseSetup("/initial-group.xml")
	@ExpectedDatabase(value = "/remove-group.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testRemove() throws JSONException {
		//Arrange
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
       
        // Act
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/group/2"),
                HttpMethod.DELETE, null, String.class);
        // Assert
        JSONAssert.assertEquals(null, response.getBody(), false);
	}

}
