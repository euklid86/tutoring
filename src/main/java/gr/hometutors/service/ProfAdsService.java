package gr.hometutors.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hometutors.model.ProfAds;
import gr.hometutors.model.Professor;
import gr.hometutors.repository.ProfAdsRepository;

/*
 * Class in order to execute the business logic of the application
 * 
 * @author Dimitris
 */
@Service
public class ProfAdsService {

	@Autowired
	ProfAdsRepository profAdsRepository;

	@Autowired
	ProfessorService professorService;

	public List<ProfAds> findAll() {
		return profAdsRepository.findAll();
	}

	public void createOne(ProfAds profAd) {
		String secretCodeTemp = profAd.getSecretCode();
		Professor professor = new Professor();
		professor = professorService.findBySecretCode(secretCodeTemp);
		professor.getProfAds().add(profAd);
		professorService.update(professor);
	}

	public void update(ProfAds profAd) {
		profAdsRepository.save(profAd);
	}

	public ProfAds findByReviewCode(String reviewCode) {
		return profAdsRepository.findByReviewCode(reviewCode);
	}
}
