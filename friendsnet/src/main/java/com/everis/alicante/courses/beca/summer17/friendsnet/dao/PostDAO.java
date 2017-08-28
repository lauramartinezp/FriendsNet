package com.everis.alicante.courses.beca.summer17.friendsnet.dao;

import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Like;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Post;

public interface PostDAO extends EntityDAO<Post, Long> {

	public Post addLike(Like like);
}
