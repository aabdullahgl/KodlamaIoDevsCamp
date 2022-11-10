package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.business.requests.CodeLanguage.CreateLanguageRequests;
import kodlama.io.Devs.business.requests.CodeLanguage.DeleteLanguageRequests;
import kodlama.io.Devs.business.requests.CodeLanguage.UpdateLanguageRequests;
import kodlama.io.Devs.business.responses.CodeLanguage.GetAllLanguageResponse;
import kodlama.io.Devs.business.responses.CodeLanguage.GetByIdLanguageResponse;


public interface CodeLanguageService {

	void add(CreateLanguageRequests createLanguageRequests) throws Exception;

	void delete(DeleteLanguageRequests deleteLanguageRequests) throws Exception;

	void update(UpdateLanguageRequests updateLanguageRequests) throws Exception;

	List<GetAllLanguageResponse> getAll();

	GetByIdLanguageResponse getById(int id);

}
