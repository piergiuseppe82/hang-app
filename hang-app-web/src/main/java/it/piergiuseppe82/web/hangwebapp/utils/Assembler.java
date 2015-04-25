package it.piergiuseppe82.web.hangwebapp.utils;

import it.piergiuseppe82.neo4jspring.entity.Post;
import it.piergiuseppe82.web.hangwebapp.rest.pojo.PostPojo;

public class Assembler {
	public static void toPojo(Post from, PostPojo to){
		to.setAccountId(from.getPerson().getAccountId());
		to.setLatitude(from.getLatitude());
		to.setId(from.getId());
		to.setLongitude(from.getLongitude());
		to.setPhotoPath(from.getPhotoPath());
		to.setPostName(from.getPostName());
		to.setPostCreationTime(from.getPostCreationTime());
	}
}
