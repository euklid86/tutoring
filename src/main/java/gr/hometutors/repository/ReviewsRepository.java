package gr.hometutors.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gr.hometutors.model.Reviews;

/*
 * Interface that extends the JpaRepository in order to execute the CRUD queries in the database and more complex ones
 * 
 * @author Dimitris
 */
public interface ReviewsRepository extends JpaRepository<Reviews, Long> {

}
