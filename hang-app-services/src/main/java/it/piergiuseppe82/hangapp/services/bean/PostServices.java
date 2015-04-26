package it.piergiuseppe82.hangapp.services.bean;

import it.piergiuseppe82.hangapp.services.bean.pojo.PostPojo;

import java.util.List;


public interface PostServices {
	public int addPost(String accountId, String postName,String latitude,String longitude, byte[] image );
	public List<PostPojo> getPosts(String accountId, String latitude,String longitude);
	public List<PostPojo> getPostsNearly(String accountId, String latitude,String longitude);
}
