package info.ernestas.quartzexample.repository;

import info.ernestas.quartzexample.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {

}
