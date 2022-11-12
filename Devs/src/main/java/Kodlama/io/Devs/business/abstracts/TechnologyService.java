package Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.business.requests.technologyRequests.CreateTechnologyRequest;
import Kodlama.io.Devs.business.requests.technologyRequests.DeleteTechnologyRequests;
import Kodlama.io.Devs.business.requests.technologyRequests.UpdateTechnologyRequests;
import Kodlama.io.Devs.business.responses.technologyResponses.GetAllTechnologiesResponse;
import Kodlama.io.Devs.business.responses.technologyResponses.GetByIdTechnologyResponse;

public interface TechnologyService {

	List<GetAllTechnologiesResponse>getAll();
	
	void add (CreateTechnologyRequest createTechnologyRequest) throws Exception;
	void delete(DeleteTechnologyRequests deleteTechnologyRequests)throws Exception;
	void update (UpdateTechnologyRequests updateTechnologyRequests)throws Exception;
	
	GetByIdTechnologyResponse getByIdTechnology(int id)throws Exception;
	
}
