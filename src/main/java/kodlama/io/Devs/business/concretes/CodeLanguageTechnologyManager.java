package kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.CodeLanguageTechnologyService;
import kodlama.io.Devs.business.requests.CodeLanguageTechnology.CreateTechnologyRequests;
import kodlama.io.Devs.business.requests.CodeLanguageTechnology.DeleteTechnologyRequests;
import kodlama.io.Devs.business.requests.CodeLanguageTechnology.UpdateTechnologyRequests;
import kodlama.io.Devs.business.responses.CodeLanguageTechnology.GetAllTechnologyResponse;
import kodlama.io.Devs.business.responses.CodeLanguageTechnology.GetByIdTechnologyResponse;
import kodlama.io.Devs.dataAccess.abstracts.CodeLanguageRepository;
import kodlama.io.Devs.dataAccess.abstracts.CodeLanguageTechnologyRepository;
import kodlama.io.Devs.entities.concretes.CodeLanguage;
import kodlama.io.Devs.entities.concretes.CodeLanguageTechnology;

@Service
public class CodeLanguageTechnologyManager implements CodeLanguageTechnologyService {

	private CodeLanguageRepository codeLanguageRepository;
	private CodeLanguageTechnologyRepository codeLanguageTechnologyRepository;

	public CodeLanguageTechnologyManager(CodeLanguageRepository codeLanguageRepository,
			CodeLanguageTechnologyRepository codeLanguageTechnologyRepository) {
		this.codeLanguageRepository = codeLanguageRepository;
		this.codeLanguageTechnologyRepository = codeLanguageTechnologyRepository;
	}

	@Override
	public void add(CreateTechnologyRequests createTechnologyRequests) {
		Optional<CodeLanguage> codeLanguage = codeLanguageRepository
				.findById(createTechnologyRequests.getCodeLanguageId());
		CodeLanguageTechnology codeLanguageTechnology = new CodeLanguageTechnology();

		codeLanguageTechnology.setName(createTechnologyRequests.getName());
		codeLanguageTechnology.setCodeLanguage(codeLanguage.get());
		codeLanguageTechnologyRepository.save(codeLanguageTechnology);

	}

	@Override
	public void delete(DeleteTechnologyRequests deleteTechnologyRequests) throws Exception {
		if (!isIdExist(deleteTechnologyRequests.getId())) {
			throw new Exception("Silenecek id mevcut değil !!");
		}
		CodeLanguageTechnology codeLanguageTechnology = new CodeLanguageTechnology();
		codeLanguageTechnology.setId(deleteTechnologyRequests.getId());
		codeLanguageTechnologyRepository.delete(codeLanguageTechnology);

	}

	@Override
	public void update(UpdateTechnologyRequests updateTechnologyRequests) throws Exception {

		if (!isIdExist(updateTechnologyRequests.getId())) {
			throw new Exception("Güncellenecek id mevcut değil !!");

		}
		if (isNameValid(updateTechnologyRequests.getName())) {
			Optional<CodeLanguage> language = codeLanguageRepository
					.findById(updateTechnologyRequests.getCodeLanguageId());
			CodeLanguageTechnology codeLanguageTechnology = new CodeLanguageTechnology();
			codeLanguageTechnology.setId(updateTechnologyRequests.getId());
			codeLanguageTechnology.setName(updateTechnologyRequests.getName());
			codeLanguageTechnology.setCodeLanguage(language.get());
			codeLanguageTechnologyRepository.save(codeLanguageTechnology);

		}

	}

	@Override
	public List<GetAllTechnologyResponse> getAll() {
		List<CodeLanguageTechnology> languageTechnologies = codeLanguageTechnologyRepository.findAll();
		List<GetAllTechnologyResponse> technologyResponses = new ArrayList<>();
		for (CodeLanguageTechnology technology : languageTechnologies) {
			GetAllTechnologyResponse responseItem = new GetAllTechnologyResponse();
			responseItem.setId(technology.getId());
			responseItem.setName(technology.getName());
			responseItem.setCodeLanguageId(technology.getCodeLanguage().getId());
			responseItem.setCodeLanguageName(technology.getCodeLanguage().getName());
			technologyResponses.add(responseItem);
		}
		return technologyResponses;
	}

	@Override
	public GetByIdTechnologyResponse getById(int id) throws Exception {
		if(!isIdExist(id)) {
			throw new Exception("id mevcut değil");
		}
		Optional<CodeLanguageTechnology> technology = codeLanguageTechnologyRepository.findById(id);
		GetByIdTechnologyResponse responseItem = new GetByIdTechnologyResponse();
		responseItem.setName(technology.get().getName());
		return responseItem;
	}

	private boolean isIdExist(int id) {
		for (GetAllTechnologyResponse technologyResponse : getAll()) {
			if (technologyResponse.getId() == id) {
				return true;
			}
		}
		return false;
	}

	public boolean isNameValid(String name) throws Exception {

		if (name.isBlank()) {
			throw new Exception("İsim boş olamaz");
		}
		for (GetAllTechnologyResponse getAllTechnologyResponse : getAll()) {
			if (getAllTechnologyResponse.getName().equals(name)) {
				throw new Exception("İsim tekrar edemez");
			}
		}
		return true;

	}

}
