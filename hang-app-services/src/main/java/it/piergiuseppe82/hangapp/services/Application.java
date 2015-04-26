package it.piergiuseppe82.hangapp.services;

import it.piergiuseppe82.hangapp.services.bean.AccountServices;
import it.piergiuseppe82.hangapp.services.bean.MediaServices;
import it.piergiuseppe82.hangapp.services.bean.PostServices;
import it.piergiuseppe82.hangapp.services.bean.pojo.PersonPojo;
import it.piergiuseppe82.hangapp.services.bean.pojo.PostPojo;
import it.piergiuseppe82.hangapp.services.supports.Utility;

import java.io.File;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.kernel.impl.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
	private static final Log log = LogFactory.getLog(Application.class);
	@Configuration
	@EnableNeo4jRepositories(basePackages = "it.piergiuseppe82.hangapp.services")
	static class ApplicationConfig extends Neo4jConfiguration {

		public ApplicationConfig() {
			setBasePackage("it.piergiuseppe82.hangapp.services");
		}

		@Bean
		GraphDatabaseService graphDatabaseService() {
			
				return new GraphDatabaseFactory().newEmbeddedDatabase(Utility.getDataPath()+"graph.db");
			

		}
	}
	
	@Autowired AccountServices accountServices;
	@Autowired PostServices postServices;
	@Autowired MediaServices mediaServices;
	
	@SuppressWarnings("unused")
	public void run(String... args) throws Exception {
		accountServices.registerPerson("Piergiuseppe La cava", "piergiuseppe82", "pippo", "pippo@pippo.it");
		PersonPojo checkPerson = accountServices.checkPerson("piergiuseppe82", "pippo");
		
		postServices.addPost(checkPerson.getAccountId(), "miopost", "41.9694054", "12.6705693", mediaServices.getImage("piergiuseppe82_1429435184967", "piergiuseppe82"));
		postServices.addPost(checkPerson.getAccountId(), "miopostLontano", "39.1818605", "16.6853901", mediaServices.getImage("piergiuseppe82_1429435184967", "piergiuseppe82"));
		postServices.addPost(checkPerson.getAccountId(), "miopostVicino", "41.9528272", "12.655506", mediaServices.getImage("piergiuseppe82_1429435184967", "piergiuseppe82"));
		
		List<PostPojo> postsNearly = postServices.getPostsNearly("piergiuseppe82", "41.9694054", "12.6705693");
		for (PostPojo postPojo : postsNearly) {
			System.out.println(postPojo);
		}
		
		
		
	}

	public static void main(String[] args) throws Exception {
		FileUtils.deleteRecursively(new File(Utility.getDataPath()+"graph.db"));

		SpringApplication.run(Application.class, args);
		
		
	}
}
