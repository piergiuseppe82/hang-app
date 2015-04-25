package it.piergiuseppe82.hangapp.web.controllers;

import it.piergiuseppe82.hangapp.services.bean.PostServices;
import it.piergiuseppe82.hangapp.services.repositories.model.Person;

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
import org.springframework.web.multipart.MultipartFile;

@Controller
public class NewItemController {
	private static final Log log = LogFactory.getLog(NewItemController.class);

	@Autowired PostServices postServices;
	
	
	@RequestMapping(value = "/newitem", method = RequestMethod.GET)
    public String newitem(@RequestParam Map<String,String> allRequestParams, Model model,HttpSession session) {
		if(session.getAttribute("user") == null){
			session.invalidate();
    		return "logon";
    	}    	
		
		return "newItem";
    }
    @RequestMapping(value = "/newitem", method = RequestMethod.POST)
    public String newitemConfirm(@RequestParam("imageFile") MultipartFile imageFile,@RequestParam("title") String title,@RequestParam("latitude") String latitude,@RequestParam("longitude") String longitude, Model model,HttpSession session) {
    	if(session.getAttribute("user") == null){
    		session.invalidate();
    		return "logon";
    	}  
    	try {
			postServices.addPost(((Person)session.getAttribute("user")).getAccountId(), title, latitude, longitude, imageFile.getBytes());
			return "welcome";
		} catch (Throwable e) {
			e.printStackTrace();
			log.error(e);
			model.addAttribute("toast", "Error during register post.");
		}
    	return "newItem";
    }
}