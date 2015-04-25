package it.piergiuseppe82.hangapp.web.controllers.rest;

import it.piergiuseppe82.hangapp.services.bean.MediaServices;
import it.piergiuseppe82.hangapp.services.bean.pojo.PersonPojo;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {
	
	@Autowired MediaServices mediaServices;
	
	@RequestMapping(value = "/media/image/{imageId}", method = RequestMethod.GET)
    public byte[] getImage(@PathVariable String imageId,HttpSession session) {
		String accountId = null;
		PersonPojo person = (PersonPojo)session.getAttribute("user");
		if(person != null){
			accountId = person.getAccountId();
		}
		return mediaServices.getImage(imageId,accountId);
    	
    	
    }
}
