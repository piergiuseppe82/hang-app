package it.piergiuseppe82.hangapp.services.bean.impl;

import it.piergiuseppe82.hangapp.services.bean.AccountServices;
import it.piergiuseppe82.hangapp.services.bean.pojo.PersonPojo;
import it.piergiuseppe82.hangapp.services.bean.utils.Assembler;
import it.piergiuseppe82.hangapp.services.repositories.PersonRepository;
import it.piergiuseppe82.hangapp.services.repositories.model.Person;
import it.piergiuseppe82.hangapp.services.supports.Utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.neo4j.graphdb.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.neo4j.core.GraphDatabase;
import org.springframework.stereotype.Service;

@Service("AccountServices")
public class AccountServicesBean implements AccountServices {
	private static final Log log = LogFactory.getLog(AccountServices.class);

	@Autowired PersonRepository personRepository;
	@Autowired GraphDatabase graphDatabase;
	
	@Override
	public int registerPerson(String fullName, String accountId, String password, String email) {
		Person person = new Person();
		
		person.setAccountCreationTime(System.currentTimeMillis());
		person.setAccountId(accountId);
		person.setEmail(email);
		
		
		int ret = 0;
		log.debug("Start Register - "+person);
		
		Transaction tx = graphDatabase.beginTx();
		try{
			person.setPassword(Utility.passwordEncode(password));
			personRepository.save(person);
			tx.success();
			
		}catch(DataIntegrityViolationException e){
			log.error("Registration error: Account already exist",e);
			ret = -1;
			tx.failure();
		}catch(Throwable t){
			log.error("Error during register",t);
			ret = -99999;
			tx.failure();
		}finally{		
			tx.close();
		}
		log.debug("End Register - "+person);
		return ret;
	}

	@Override
	public PersonPojo checkPerson(String username, String password) {
		Person person = personRepository.findByAccountId(username);
		password = Utility.passwordEncode(password);
		if(person != null){
			String passwordRegistered = person.getPassword();
			if(passwordRegistered.equalsIgnoreCase(password)){
				PersonPojo to = new PersonPojo();
				Assembler.toPojo(person,to);
				return to;
			}
		}
		return null;
	}
	
}
