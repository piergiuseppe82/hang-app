package it.piergiuseppe82.hangapp.web.controllers.rest;

import it.piergiuseppe82.hangapp.services.bean.PostServices;
import it.piergiuseppe82.hangapp.services.bean.pojo.PostPojo;
import it.piergiuseppe82.hangapp.services.bean.utils.Assembler;
import it.piergiuseppe82.hangapp.services.repositories.model.Post;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class PostsController {
	
		@Autowired 	PostServices postServices;
	
		@RequestMapping(value = "/posts")
	    public @ResponseBody List<PostPojo> posts(HttpSession session) {
			List<PostPojo> ret = null;
			List<Post> posts = postServices.getPosts(null, null, null);
			if(posts != null){
				ret = new ArrayList<>();
				for (Post from : posts) {					
					PostPojo to = new PostPojo();
					Assembler.toPojo(from, to);
					ret.add(to);
				}
			}
			return ret;
	    	
	    	
	    }
	    

}
