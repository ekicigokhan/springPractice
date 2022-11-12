package Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.business.requests.languageRequests.CreateLanguageRequest;
import Kodlama.io.Devs.business.requests.languageRequests.DeleteLanguageRequests;
import Kodlama.io.Devs.business.requests.languageRequests.UpdateLanguageRequests;
import Kodlama.io.Devs.business.responses.languageResponses.GetAllLanguagesResponse;
import Kodlama.io.Devs.business.responses.languageResponses.GetByIdLanguageResponse;


public interface LanguageService {
	
	List<GetAllLanguagesResponse> getAll();
	
	void add(CreateLanguageRequest createLanguageRequest)throws Exception;
	void delete(DeleteLanguageRequests deleteLanguageRequests)throws Exception;
	void update(UpdateLanguageRequests updateLanguageRequests)throws Exception;
	
	GetByIdLanguageResponse getByIdLanguage (int id)throws Exception;
}
