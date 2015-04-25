package it.piergiuseppe82.hangapp.services;

import it.piergiuseppe82.hangapp.services.repositories.PersonRepository;
import it.piergiuseppe82.hangapp.services.repositories.PostRepository;
import it.piergiuseppe82.hangapp.services.repositories.model.Person;
import it.piergiuseppe82.hangapp.services.repositories.model.Post;
import it.piergiuseppe82.hangapp.services.supports.Utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.core.GraphDatabase;

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

	@Autowired PersonRepository personRepository;
	@Autowired PostRepository postRepository;

	@Autowired GraphDatabase graphDatabase;

	@SuppressWarnings("unused")
	public void run(String... args) throws Exception {

		Person piergiuseppe = new Person("Piergiuseppe");
		Person francesca = new Person("Francesca");
		Person luca = new Person("Luca");
		

	

		Transaction tx = graphDatabase.beginTx();
		try {
//			personRepository.save(piergiuseppe);
//			
//
//			piergiuseppe = personRepository.findByAccountId(piergiuseppe.getAccountId());
//			piergiuseppe.post(new Post("POST_DI_PIERGIUSEPPE", "image.jpg", "15.5555", "18.5646446"));
//			personRepository.save(piergiuseppe);
//
//						
//			
//			francesca.hang(piergiuseppe);
//			francesca.post(new Post("POST_DI_FRANCESCA", "imageF.jpg", "18.5666", "21.5646446"));
//			personRepository.save(francesca);
//			
//			luca.hang(francesca);
//			luca.hang(piergiuseppe);			
//			personRepository.save(luca);
			
			
			
			Iterable<Person> findAll = personRepository.findAll();
			for (Person person : findAll) {
				log.info(person);
				
			}
			Iterable<Post> findAll2 = postRepository.findAll();
			for (Post post : findAll2) {
				log.info(post);
			}

			tx.success();
		} finally {
			tx.close();
		}
	}

	public static void main(String[] args) throws Exception {
//		FileUtils.deleteRecursively(new File("/home/placava/devel/servers/neo4jHang/data/graph.db"));

		SpringApplication.run(Application.class, args);
	}
}
