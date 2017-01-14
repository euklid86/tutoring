package gr.hometutors.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gr.hometutors.model.Professor;

/*
 * Interface that extends the JpaRepository in order to execute the CRUD queries in the database and more complex ones
 * 
 * @author Dimitris
 */
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

	Professor findBySecretCode(String secretCode);
}
