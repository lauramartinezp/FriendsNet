package com.everis.alicante.courses.beca.summer17.friendsnet.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.LikeType;
import lombok.Data;

@Data
@Entity
@Table(name = "likeTable")
public class Like implements FNEntity {

	@Id
	@GeneratedValue
	@Column(name = "like_id", nullable = false, unique = true)
	private Long id;

	private Date creationDate;

	private LikeType type;

	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person likes;

	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post likesByPost;

}
