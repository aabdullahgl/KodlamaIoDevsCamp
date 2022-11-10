package kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.CodeLanguageService;
import kodlama.io.Devs.business.requests.CodeLanguage.CreateLanguageRequests;
import kodlama.io.Devs.business.requests.CodeLanguage.DeleteLanguageRequests;
import kodlama.io.Devs.business.requests.CodeLanguage.UpdateLanguageRequests;
import kodlama.io.Devs.business.responses.CodeLanguage.GetAllLanguageResponse;
import kodlama.io.Devs.business.responses.CodeLanguage.GetByIdLanguageResponse;
import kodlama.io.Devs.dataAccess.abstracts.CodeLanguageRepository;
import kodlama.io.Devs.entities.concretes.CodeLanguage;

@Service
public class CodeLanguageManager implements CodeLanguageService {

	private CodeLanguageRepository codeLanguageRepository;

	public CodeLanguageManager(CodeLanguageRepository codeLanguageRepository) {
		this.codeLanguageRepository = codeLanguageRepository;

	}

	@Override
	public void add(CreateLanguageRequests createLanguageRequests) throws Exception {
		CodeLanguage codeLanguage = new CodeLanguage();
		if (isNameValid(createLanguageRequests.getName())) {
			codeLanguage.setName(createLanguageRequests.getName());
			this.codeLanguageRepository.save(codeLanguage);
		}

	}

	@Override
	public void delete(DeleteLanguageRequests deleteLanguageRequests) throws Exception {
		if (!isIdExist(deleteLanguageRequests.getId())) {
			throw new Exception("Silenecek id mevcut değil !!");
		}
		CodeLanguage codeLanguage = new CodeLanguage();
		codeLanguage.setId(deleteLanguageRequests.getId());
		codeLanguageRepository.deleteById(deleteLanguageRequests.getId());

	}

	@Override
	public void update(UpdateLanguageRequests updateLanguageRequests) throws Exception {
		
		if(!isIdExist(updateLanguageRequests.getId())) {
			throw new Exception("Güncellenecek id mevcut değil !!");
		}
		if(isNameValid(updateLanguageRequests.getName())) {
			CodeLanguage codeLanguage=new CodeLanguage();
			codeLanguage.setId(updateLanguageRequests.getId());
			codeLanguage.setName(updateLanguageRequests.getName());
			codeLanguageRepository.save(codeLanguage);
		}

	}

	@Override
	public List<GetAllLanguageResponse> getAll() {

		List<CodeLanguage> codeLanguages = codeLanguageRepository.findAll();
		List<GetAllLanguageResponse> getAllLanguageResponses = new ArrayList<>();
		for (CodeLanguage language : codeLanguages) {
			GetAllLanguageResponse responseItem = new GetAllLanguageResponse();
			responseItem.setId(language.getId());
			responseItem.setName(language.getName());
			responseItem.setCodeLanguageTechnologies(language.getCodeLanguageTechnologies());
			getAllLanguageResponses.add(responseItem);

		}
		return getAllLanguageResponses;

	}

	@Override
	public GetByIdLanguageResponse getById(int id) {
		Optional<CodeLanguage> codeLanguage = codeLanguageRepository.findById(id);
		GetByIdLanguageResponse byIdLanguageResponse = new GetByIdLanguageResponse();
		byIdLanguageResponse.setId(id);
		byIdLanguageResponse.setName(codeLanguage.get().getName());
		return byIdLanguageResponse;
	}

	private boolean isIdExist(int id) {
		for (GetAllLanguageResponse codeLanguage : getAll()) {
			if (codeLanguage.getId() == id) {
				return true;
			}
		}
		return false;
	}

	public boolean isNameValid(String name) throws Exception {

		if (name.isBlank()) {
			throw new Exception("İsim boş olamaz");
		}
		for (GetAllLanguageResponse getAllLanguageResponse : getAll()) {
			if (getAllLanguageResponse.getName().equals(name)) {
				throw new Exception("İsim tekrar edemez");
			}
		}
		return true;

	}
}
