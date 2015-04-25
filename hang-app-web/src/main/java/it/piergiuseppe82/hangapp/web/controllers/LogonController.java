package it.piergiuseppe82.hangapp.web.controllers;

import it.piergiuseppe82.hangapp.services.bean.AccountServices;
import it.piergiuseppe82.hangapp.services.repositories.model.Person;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LogonController {

	@Autowired
	private AccountServices accountServices;
	
	@RequestMapping(value = "/logon", method = RequestMethod.GET)
    public String logon(@RequestParam Map<String,String> allRequestParams, Model model,HttpSession session) {
    	
		session.invalidate();
    	return "logon";
    	
    	
    }
    @RequestMapping(value = "/logon", method = RequestMethod.POST)
    public String logonConfirm(@RequestParam Map<String,String> allRequestParams, Model model,HttpSession session) {
    	
    	String username = allRequestParams.get("username");
    	String password = allRequestParams.get("password");
    	if(username == null || username.isEmpty() || password == null || password.isEmpty() ){
    		model.addAttribute("toast", "Insert Username and Password");
    	
    	}else{
    		try {
				password =new String(MessageDigest.getInstance("MD5").digest(password.getBytes()));
			} catch (NoSuchAlgorithmException e) {
				model.addAttribute("toast", "Error during digest password.");
				return "logon";
			}
    		if(verifyAccount(username,password,session)){
    			
    			return "welcome";
    		}else{
    			model.addAttribute("toast", "Username or Password error");
    		}
    	}
    	return "logon";
    }
    
    private boolean verifyAccount(String username, String password, HttpSession session) {
    	
		Person user = accountServices.checkPerson(username, password);
		if(user !=null){
			session.setAttribute("user", user);
			return true;
		}
		return false;
		
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model,HttpSession session) {
    	
    	
    		session.invalidate();
    		return "logon";
    	
    	
    }
}