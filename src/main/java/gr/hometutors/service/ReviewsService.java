package gr.hometutors.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hometutors.model.ProfAds;
import gr.hometutors.model.Reviews;
import gr.hometutors.repository.ReviewsRepository;

/*
 * Class in order to execute the business logic of the application
 * 
 * @author Dimitris
 */
@Service
public class ReviewsService {

	@Autowired
	ReviewsRepository reviewsRepository;

	@Autowired
	ProfAdsService profAdService;

	public List<Reviews> findAll() {
		return reviewsRepository.findAll();
	}

	public void createOne(Reviews review) {
		String reviewCodeTemp = review.getReviewCode();
		ProfAds profAd = new ProfAds();
		profAd = profAdService.findByReviewCode(reviewCodeTemp);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		review.setTimestamp(timestamp);
		profAd.getReviews().add(review);
		profAdService.update(profAd);
	}
}
