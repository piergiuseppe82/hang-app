package it.piergiuseppe82.hangapp.web.utils;

import it.piergiuseppe82.hangapp.services.repositories.model.Post;
import it.piergiuseppe82.hangapp.web.rest.pojo.PostPojo;

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
