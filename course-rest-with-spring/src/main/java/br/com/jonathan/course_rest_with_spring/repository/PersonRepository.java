package br.com.jonathan.course_rest_with_spring.repository;

import br.com.jonathan.course_rest_with_spring.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
