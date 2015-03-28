package vn.smartdev.app.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import vn.smartdev.app.entities.Person;

public interface IPersonRepository extends CrudRepository<Person, String> {
	List<Person> findAll();
}
