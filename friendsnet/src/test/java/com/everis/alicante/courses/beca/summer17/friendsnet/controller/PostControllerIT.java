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
import org.springframework.test.context.junit4.SpringRunner;


import com.everis.alicante.courses.beca.summer17.friendsnet.dao.PostDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Post;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostControllerIT {
	
	 @LocalServerPort
	    private int port;

	    @Autowired
	    private PostDAO dao;

	    TestRestTemplate restTemplate = new TestRestTemplate();

	    HttpHeaders headers = new HttpHeaders();

	    private ObjectMapper mapper;
	    
	    @Before
	    public void setup() {

	        this.mapper = new ObjectMapper();
	     
	    }

	@Test
	public void testGetAll() throws JSONException {
		   //Arrange
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        dao.save(new Post());
     

        // Act
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/post"),
                HttpMethod.GET, entity, String.class);

        // Assert
        JSONAssert.assertEquals("[{'id': 1}]", response.getBody(), false);
	}
	
	@Test
	public void testGetById() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetByPersonId() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemove() {
		fail("Not yet implemented");
	}
	   private String createURLWithPort(String uri) {
	        return "http://localhost:" + port + uri;
	    }
}
