package kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.CodeLanguageTechnologyService;
import kodlama.io.Devs.business.requests.CodeLanguageTechnology.CreateTechnologyRequests;
import kodlama.io.Devs.business.requests.CodeLanguageTechnology.DeleteTechnologyRequests;
import kodlama.io.Devs.business.requests.CodeLanguageTechnology.UpdateTechnologyRequests;
import kodlama.io.Devs.business.responses.CodeLanguageTechnology.GetAllTechnologyResponse;
import kodlama.io.Devs.business.responses.CodeLanguageTechnology.GetByIdTechnologyResponse;

@RestController
@RequestMapping("/api/technologies")
public class CodeLanguageTechnologiesController {

	private CodeLanguageTechnologyService codeLanguageTechnologyService;

	@Autowired
	public CodeLanguageTechnologiesController(CodeLanguageTechnologyService codeLanguageTechnologyService) {
		this.codeLanguageTechnologyService = codeLanguageTechnologyService;
	}

	@PostMapping("/add")
	void add(@RequestBody CreateTechnologyRequests createTechnologyRequests) {
		codeLanguageTechnologyService.add(createTechnologyRequests);
	}

	@DeleteMapping("/delete")
	void delete(@RequestBody DeleteTechnologyRequests deleteTechnologyRequests) throws Exception {
		codeLanguageTechnologyService.delete(deleteTechnologyRequests);
	}

	@PutMapping("/update")
	void update(@RequestBody UpdateTechnologyRequests updateTechnologyRequests) throws Exception {
		codeLanguageTechnologyService.update(updateTechnologyRequests);
	}

	@GetMapping("/getall")
	List<GetAllTechnologyResponse> getAll() {
		return codeLanguageTechnologyService.getAll();
	}

	@GetMapping("/getbyid")
	GetByIdTechnologyResponse getById(@RequestParam int id) throws Exception {
		return codeLanguageTechnologyService.getById(id);
	}

}
