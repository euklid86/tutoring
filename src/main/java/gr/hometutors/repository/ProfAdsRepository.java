package gr.hometutors.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gr.hometutors.model.ProfAds;

/*
 * Interface that extends the JpaRepository in order to execute the CRUD queries in the database and more complex ones
 * 
 * @author Dimitris
 */
public interface ProfAdsRepository extends JpaRepository<ProfAds, Long> {

	public ProfAds findByReviewCode(String reviewCode);

}
