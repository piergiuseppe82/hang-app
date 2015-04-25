package it.piergiuseppe82.hangapp.services.bean;

import it.piergiuseppe82.hangapp.services.bean.pojo.PersonPojo;

public interface AccountServices {
	
	public int registerPerson(String fullName, String accountId, String password, String email);
	
	public PersonPojo checkPerson(String username, String password);
}
