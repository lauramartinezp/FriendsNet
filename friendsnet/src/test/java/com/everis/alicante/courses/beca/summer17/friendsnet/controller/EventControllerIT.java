package com.everis.alicante.courses.beca.summer17.friendsnet.controller;
import static org.junit.Assert.*;

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

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.EventDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Event;
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
public class EventControllerIT {

	@LocalServerPort
    private int port;
	
	@Autowired
	private EventDAO dao;

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
    @DatabaseSetup("/initial-event.xml")
    @ExpectedDatabase(value = "/initial-event.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testFindAllWithContent() throws JSONException {
        //Arrange
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
       
        // Act
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/event"),
                HttpMethod.GET, null, String.class);
        // Assert
        JSONAssert.assertEquals("[{'id':1, 'name':'aaa'}, {'id':2, 'name':'bbb'}, {'id':3, 'name':'ccc'}]", response.getBody(), false);
    }

	@Test
	@DatabaseSetup("/initial-event.xml")
	@ExpectedDatabase(value = "/initial-event.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testGetById() throws JSONException {
	     //Arrange
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
       
        // Act
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/event/2"),
                HttpMethod.GET, null, String.class);
        // Assert
        JSONAssert.assertEquals("{'id':2, 'name':'bbb'}", response.getBody(), false);
	}

	@Test
	@DatabaseSetup("/initial-event.xml")
	@ExpectedDatabase(value = "/create-event.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testCreate() throws JSONException {
		//Arrange
		Event event = new Event();
		event.setName("ddd");
		
        HttpEntity<Event> entity = new HttpEntity<Event>(event, headers);
       
        // Act
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/event"),
                HttpMethod.POST, entity, String.class);

        // Assert
        JSONAssert.assertEquals("{'id':4, 'name':'ddd'}", response.getBody(), false);
	}

//	@Test
//	public void testRelate() {
//		fail("Not yet implemented");
//	}

	@Test
	@DatabaseSetup("/initial-event.xml")
	@ExpectedDatabase(value = "/remove-event.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testRemove() throws JSONException {
		//Arrange
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
       
        // Act
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/event/2"),
                HttpMethod.DELETE, null, String.class);
        // Assert
        JSONAssert.assertEquals(null, response.getBody(), false);
	}
}
