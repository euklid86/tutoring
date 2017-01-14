package gr.hometutors.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gr.hometutors.model.Reviews;
import gr.hometutors.service.ReviewsService;

/*
 * The controller of the reviews entity
 * 
 * @author Dimitris
 */
@RestController
@RequestMapping(path = "/reviews")
public class ReviewsResource {

	@Autowired
	ReviewsService reviewsService;

	@RequestMapping(path = "all", method = RequestMethod.GET)
	public ResponseEntity<List<Reviews>> getAll() {
		List<Reviews> reviewsList = new ArrayList<Reviews>();
		reviewsList = reviewsService.findAll();
		return ResponseEntity.ok(reviewsList);
	}

	@RequestMapping(path = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void createReview(@RequestBody Reviews review) {
		reviewsService.createOne(review);
	}
}
