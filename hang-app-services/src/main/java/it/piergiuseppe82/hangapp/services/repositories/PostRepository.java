package it.piergiuseppe82.hangapp.services.repositories;

import it.piergiuseppe82.hangapp.services.repositories.model.Person;
import it.piergiuseppe82.hangapp.services.repositories.model.Post;

import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, String> {

    Person findByPostName(String postName);


}