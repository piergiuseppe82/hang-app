package it.piergiuseppe82.hangapp.services.repositories;

import it.piergiuseppe82.hangapp.services.repositories.model.Person;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, String> {

    Person findByAccountId(String accountId);

    Iterable<Person> findByHangouts(String accountId);

}