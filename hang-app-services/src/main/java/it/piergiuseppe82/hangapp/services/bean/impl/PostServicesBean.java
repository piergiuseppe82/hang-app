package it.piergiuseppe82.hangapp.services.bean.impl;

import it.piergiuseppe82.hangapp.services.bean.MediaServices;
import it.piergiuseppe82.hangapp.services.bean.PostServices;
import it.piergiuseppe82.hangapp.services.bean.pojo.PostPojo;
import it.piergiuseppe82.hangapp.services.bean.utils.Assembler;
import it.piergiuseppe82.hangapp.services.repositories.PersonRepository;
import it.piergiuseppe82.hangapp.services.repositories.PostRepository;
import it.piergiuseppe82.hangapp.services.repositories.model.Person;
import it.piergiuseppe82.hangapp.services.repositories.model.Post;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.neo4j.graphdb.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.GraphDatabase;
import org.springframework.stereotype.Service;

@Service("PostServices")
public class PostServicesBean implements PostServices{
	private static final Log log = LogFactory.getLog(PostServices.class);

	@Autowired PersonRepository personRepository;
	@Autowired PostRepository postRepository;
	@Autowired GraphDatabase graphDatabase;
	@Autowired MediaServices mediaService;

	@Override
	public int addPost(String accountId, String postName,
			String latitude, String longitude, byte[] image) {
		int ret = 0;
		log.debug("Start - "+postName);
		
		Transaction tx = graphDatabase.beginTx();
		try{
			Person person = personRepository.findByAccountId(accountId);
			if(person !=null){
				String photoPath = mediaService.saveImage(image, accountId);				
				Post post = new Post(postName, photoPath, latitude, longitude);
				person.post(post);
				personRepository.save(person);
				tx.success();
			}else{
				tx.failure();
				ret =  -1;
			}
		}catch(Throwable t){
			log.error("Error during register",t);
			ret = -99999;
			tx.failure();
		}finally{		
			tx.close();
		}
		log.debug("End - "+postName);
		return ret;
	}

	@Override
	public List<PostPojo> getPosts(String accountId, String latitude,
			String longitude) {
		List<PostPojo> retList = null;
		Transaction tx = graphDatabase.beginTx();
		try{
			Iterable<Post> findAll = postRepository.getAllPostpaginate(0, 10);
			retList = Assembler.toPojoList(findAll);
			tx.success();
		}catch(Throwable t){
			log.error("Error during register",t);			
			tx.failure();
		}finally{		
			tx.close();
		}
		return retList;
	}

	
	

}
