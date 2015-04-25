package it.piergiuseppe82.neo4jspring.entityrepository;

import it.piergiuseppe82.neo4jspring.entity.Person;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, String> {

    Person findByAccountId(String accountId);

    Iterable<Person> findByHangouts(String accountId);

}