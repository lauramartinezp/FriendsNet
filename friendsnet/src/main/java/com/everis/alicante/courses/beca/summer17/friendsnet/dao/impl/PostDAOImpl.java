package com.everis.alicante.courses.beca.summer17.friendsnet.dao.impl;

import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.AbstractDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.dao.PostDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Like;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Post;

@Service
public class PostDAOImpl extends AbstractDAO<Post, Long> implements PostDAO {

	@Override
	public Post addLike(Like like) {
		// TODO Auto-generated method stub
		return null;
	}

}
