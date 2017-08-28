package com.everis.alicante.courses.beca.summer17.friendsnet.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Event")
public class Event implements FNEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "event_id", nullable = false, unique = true)
	private Long id;

	@Column(name ="name",length = 200)
	private String name;

	@Column(name ="startDate", length = 20)
	private Date startingDate;

	@Column(name="endingDate", length = 20)
	private Date endingDate;

	@Column(name ="type", length = 20)
	private EventType type;

	@Column(name ="picture")
	private byte[] picture;

}
