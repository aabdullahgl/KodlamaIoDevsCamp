package kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.CodeLanguageService;
import kodlama.io.Devs.business.requests.CodeLanguage.CreateLanguageRequests;
import kodlama.io.Devs.business.requests.CodeLanguage.DeleteLanguageRequests;
import kodlama.io.Devs.business.requests.CodeLanguage.UpdateLanguageRequests;
import kodlama.io.Devs.business.responses.CodeLanguage.GetAllLanguageResponse;
import kodlama.io.Devs.business.responses.CodeLanguage.GetByIdLanguageResponse;

@RestController
@RequestMapping("/api/languages")
public class CodeLanguagesController {

	private CodeLanguageService codeLanguageService;

	@Autowired
	public CodeLanguagesController(CodeLanguageService codeLanguageService) {
		this.codeLanguageService = codeLanguageService;
	}

	@PostMapping("/add")
	void add(@RequestBody CreateLanguageRequests createLanguageRequests) throws Exception {
		codeLanguageService.add(createLanguageRequests);
	}

	@DeleteMapping("/delete")
	void delete(@RequestBody DeleteLanguageRequests deleteLanguageRequests) throws Exception {
		codeLanguageService.delete(deleteLanguageRequests);
	}

	@PutMapping("/update")
	void update(@RequestBody UpdateLanguageRequests updateLanguageRequests) throws Exception {
		codeLanguageService.update(updateLanguageRequests);
	}

	@GetMapping("/getall")
	List<GetAllLanguageResponse> getAll() {
		return codeLanguageService.getAll();
	}

	@GetMapping("/getbyid")
	GetByIdLanguageResponse getbyid(@RequestParam int id) {
		return codeLanguageService.getById(id);
	}

}
