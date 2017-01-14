package gr.hometutors.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gr.hometutors.model.Professor;
import gr.hometutors.repository.ProfessorRepository;

/*
 * Class in order to execute the business logic of the application
 * 
 * @author Dimitris
 */
@Service
public class ProfessorService {

	@Autowired
	ProfessorRepository professorRepository;

	public Professor findById(Long id) {
		return professorRepository.findOne(id);
	}

	public List<Professor> findAll() {
		return professorRepository.findAll();
	}

	public void createOne(Professor professorNew) {
		professorRepository.save(professorNew);
	}

	public Professor findBySecretCode(String secretCode) {
		return professorRepository.findBySecretCode(secretCode);
	}

	public void update(Professor professor) {
		professorRepository.save(professor);
	}
}
