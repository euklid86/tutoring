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

import gr.hometutors.model.ProfAds;
import gr.hometutors.service.ProfAdsService;

/*
 * The controller of the profads entity
 * 
 * @author Dimitris
 */
@RestController
@RequestMapping(path = "/profads")
public class ProfAdsResource {

	@Autowired
	ProfAdsService profAdsService;

	@RequestMapping(path = "all", method = RequestMethod.GET)
	public ResponseEntity<List<ProfAds>> getAll() {
		List<ProfAds> profAdsList = new ArrayList<ProfAds>();
		profAdsList = profAdsService.findAll();
		return ResponseEntity.ok(profAdsList);
	}

	@RequestMapping(path = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void createOne(@RequestBody ProfAds profAd) {
		System.out.println(profAd.toString());
		profAdsService.createOne(profAd);
	}
}
