package it.piergiuseppe82.hangapp.services.bean;

import it.piergiuseppe82.hangapp.services.repositories.model.Post;

import java.util.List;


public interface PostServices {
	public int addPost(String accountId, String postName,String latitude,String longitude, byte[] image );
	public List<Post> getPosts(String accountId, String latitude,String longitude);
}
