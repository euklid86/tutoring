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

import gr.hometutors.model.Professor;
import gr.hometutors.service.ProfessorService;

/*
 * The controller of the professor entity
 * 
 * @author Dimitris
 */
@RestController
@RequestMapping(path = "/professor")
public class ProfessorResource {

	@Autowired
	ProfessorService professorService;

	@RequestMapping(path = "all", method = RequestMethod.GET)
	public ResponseEntity<List<Professor>> getAll() {
		List<Professor> profList = new ArrayList<Professor>();
		profList = professorService.findAll();
		return ResponseEntity.ok(profList);
	}

	@RequestMapping(path = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void register(@RequestBody Professor professor) {
		professorService.createOne(professor);
	}
}
