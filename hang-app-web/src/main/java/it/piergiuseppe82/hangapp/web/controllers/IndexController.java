package it.piergiuseppe82.hangapp.web.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String showIndex(Model model,HttpSession session) {
    	
    	if(session.getAttribute("user") != null){
    		return "welcome";
    	}else{
    		return "logon";
    	}
    	
    }
    

}