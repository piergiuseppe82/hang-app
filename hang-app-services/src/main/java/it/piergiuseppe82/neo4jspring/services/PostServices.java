package it.piergiuseppe82.neo4jspring.services;

import it.piergiuseppe82.neo4jspring.entity.Post;

import java.util.List;


public interface PostServices {
	public int addPost(String accountId, String postName,String latitude,String longitude, byte[] image );
	public List<Post> getPosts(String accountId, String latitude,String longitude);
}
