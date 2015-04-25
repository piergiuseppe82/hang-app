package it.piergiuseppe82.neo4jspring.entityrepository;

import it.piergiuseppe82.neo4jspring.entity.Person;
import it.piergiuseppe82.neo4jspring.entity.Post;

import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, String> {

    Person findByPostName(String postName);


}