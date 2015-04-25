package it.piergiuseppe82.hangapp.services.bean.utils;

import it.piergiuseppe82.hangapp.services.bean.pojo.PersonPojo;
import it.piergiuseppe82.hangapp.services.bean.pojo.PostPojo;
import it.piergiuseppe82.hangapp.services.repositories.model.Person;
import it.piergiuseppe82.hangapp.services.repositories.model.Post;

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
	
	public static void toPojo(Person from, PersonPojo to){
		to.setAccountId(from.getAccountId());
		to.setEmail(from.getEmail());
		to.setId(from.getId());
		to.setFullName(from.getFullName());
		to.setPassword(from.getPassword());
		to.setAccountCreationTime(from.getAccountCreationTime());
	}
	
}
