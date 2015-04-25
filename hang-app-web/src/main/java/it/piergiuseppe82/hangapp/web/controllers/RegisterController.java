package it.piergiuseppe82.hangapp.web.controllers;

import it.piergiuseppe82.hangapp.services.bean.AccountServices;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
//	private static final Log log = LogFactory.getLog(RegisterController.class);

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
    		
    		int registerPerson = accountServices.registerPerson(allRequestParams.get("fullName"),
					username,allRequestParams.get("password"),allRequestParams.get("email"));
			if(registerPerson == 0)
				return "logon";
			model.addAttribute("toast","Account already exist.");
			return "register";
    	}
    	
    }
}