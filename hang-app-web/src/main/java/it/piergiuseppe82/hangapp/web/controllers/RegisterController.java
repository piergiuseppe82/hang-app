package it.piergiuseppe82.hangapp.web.controllers;

import it.piergiuseppe82.hangapp.services.bean.AccountServices;
import it.piergiuseppe82.hangapp.services.repositories.model.Person;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
	private static final Log log = LogFactory.getLog(RegisterController.class);

	@Autowired
	private AccountServices accountServices;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(@RequestParam Map<String,String> allRequestParams, Model model,HttpSession session) {
    	
		session.invalidate();
    	return "register";
    	
    	
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerConfirm(@RequestParam Map<String,String> allRequestParams, Model model,HttpSession session) {
    	
    	String username = allRequestParams.get("username");
    	if(username == null){
    		model.addAttribute("toast", "no username found");
    		return "register";
    	}else{
    		Person person = new Person();
    		person.setAccountId(username);
    		try {
				person.setPassword(new String(MessageDigest.getInstance("MD5").digest(allRequestParams.get("password").toString().getBytes())));
			} catch (NoSuchAlgorithmException e) {
				log.error("Error during digest password.",e);
				model.addAttribute("toast", "Error during digest password.");
				return "register";
			}
    		person.setFullName(allRequestParams.get("fullName"));
    		person.setEmail(allRequestParams.get("email"));
    		person.setAccountCreationTime(System.currentTimeMillis());
			int registerPerson = accountServices.registerPerson(person);
			if(registerPerson == 0)
				return "logon";
			model.addAttribute("toast","Account already exist.");
			return "register";
    	}
    	
    }
}