package com.everis.alicante.courses.beca.summer17.friendsnet.manager.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.summer17.friendsnet.dao.PostDAO;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Like;
import com.everis.alicante.courses.beca.summer17.friendsnet.entity.Post;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.AbstractManager;
import com.everis.alicante.courses.beca.summer17.friendsnet.manager.PostManager;
@Service
public class PostManagerImpl extends AbstractManager<Post, Long> implements PostManager{
	
	@Autowired
	private PostDAO postdao;

	@Override
	public Post addLike(Like like) {
		return postdao.addLike(like);
	}


}
