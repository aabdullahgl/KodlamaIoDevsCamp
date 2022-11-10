package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.business.requests.CodeLanguageTechnology.CreateTechnologyRequests;
import kodlama.io.Devs.business.requests.CodeLanguageTechnology.DeleteTechnologyRequests;
import kodlama.io.Devs.business.requests.CodeLanguageTechnology.UpdateTechnologyRequests;
import kodlama.io.Devs.business.responses.CodeLanguageTechnology.GetAllTechnologyResponse;
import kodlama.io.Devs.business.responses.CodeLanguageTechnology.GetByIdTechnologyResponse;


public interface CodeLanguageTechnologyService {

	void add(CreateTechnologyRequests createTechnologyRequests);

	void delete(DeleteTechnologyRequests deleteTechnologyRequests) throws Exception;

	void update(UpdateTechnologyRequests updateTechnologyRequests) throws Exception;

	List<GetAllTechnologyResponse> getAll();

	GetByIdTechnologyResponse getById(int id) throws Exception;

}
