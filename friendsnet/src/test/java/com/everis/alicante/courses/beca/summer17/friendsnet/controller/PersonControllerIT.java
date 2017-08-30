package com.everis.alicante.courses.beca.summer17.friendsnet.controller;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

import static org.junit.Assert.*;


import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
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

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
public class PersonControllerIT {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	private ObjectMapper mapper;

	@Before
	public void setup() {
		this.mapper = new ObjectMapper();
	}

	@Test
	public void testFindAllNoContent() throws JSONException {
		// Arrange
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		// Act
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/person"), HttpMethod.GET, null, String.class);

		// Assert
		JSONAssert.assertEquals("[]", response.getBody(), false);
	}

    @Test
    @DatabaseSetup("/initial-person.xml")
    @ExpectedDatabase(value = "/initial-person.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testFindAllWithContent() throws JSONException {
        //Arrange
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
       
        // Act
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/person"),
                HttpMethod.GET, null, String.class);
        // Assert
        JSONAssert.assertEquals("[{'id':1, 'name':'Pepe', 'surname':'Martinez'}, {'id':2, 'name':'Jose', 'surname':'Martinez'}, {'id':3, 'name':'Luis', 'surname':'Martinez'}]", response.getBody(), false);
    }


	@Test
	@DatabaseSetup("/initial-person.xml")
	@ExpectedDatabase(value = "/initial-person.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testGetById() throws JSONException {
	     //Arrange
      //  HttpEntity<String> entity = new HttpEntity<String>(null, headers);
       
        // Act
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/person/1"),
                HttpMethod.GET, null, String.class);
        // Assert
        JSONAssert.assertEquals("{'id':1, 'name':'Pepe', 'surname':'Martinez'}", response.getBody(), false);
	}

	@Test
	@DatabaseSetup("/initial-person.xml")
	@ExpectedDatabase(value = "/create-person.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testCreate() throws JSONException {
		//Arrange
		Person person = new Person();
		person.setName("Pepito");
		person.setSurname("Martinez");
        HttpEntity<Person> entity = new HttpEntity<Person>(person, headers);
       
        // Act
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/person"),
                HttpMethod.POST, entity, String.class);

        // Assert
        JSONAssert.assertEquals("{'id':4, 'name':'Pepito', 'surname':'Martinez'}", response.getBody(), false);
	}

	@Test
	@DatabaseSetup("/initial-person.xml")
	@ExpectedDatabase(value = "/remove-person.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testRemove() throws JSONException {
        
		//Arrange
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
       
        // Act
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/person/3"),
                HttpMethod.DELETE, null, String.class);
        // Assert
        JSONAssert.assertEquals(null, response.getBody(), false);
	}
	
	 private String createURLWithPort(String uri) {
	        return "http://localhost:" + port + uri;
	    }
}