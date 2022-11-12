package Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.business.requests.languageRequests.CreateLanguageRequest;
import Kodlama.io.Devs.business.requests.languageRequests.DeleteLanguageRequests;
import Kodlama.io.Devs.business.requests.languageRequests.UpdateLanguageRequests;
import Kodlama.io.Devs.business.responses.languageResponses.GetAllLanguagesResponse;
import Kodlama.io.Devs.business.responses.languageResponses.GetByIdLanguageResponse;
import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {

	private LanguageRepository languageRepository;

	
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;

	}

	@Override
	public List<GetAllLanguagesResponse> getAll() {

		List<Language> languages = languageRepository.findAll();
		List<GetAllLanguagesResponse> gAllResponse = new ArrayList<>();

		for (Language lng : languages) {
			GetAllLanguagesResponse responseItem = new GetAllLanguagesResponse();
			responseItem.setId(lng.getId());
			responseItem.setName(lng.getName());

			gAllResponse.add(responseItem);
		}

		return gAllResponse;
	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) throws Exception {

		if (createLanguageRequest.getName().isBlank()) {
			throw new Exception("Lütfen bir programlama dili ekleyiniz.");  
		}
		
		if (isNameExist(createLanguageRequest.getName())) {
			throw new Exception("Eklemek istediğiniz programlama dili zaten mevcut.");
		}
		
		Language language = new Language(); 
		language.setName(createLanguageRequest.getName());

		languageRepository.save(language);

	}

	@Override
	public void delete(DeleteLanguageRequests deleteLanguageRequests) throws Exception {
		if (!isIdExist(deleteLanguageRequests.getId())) {
			throw new Exception("Silmek istediğiniz İD ile programlama diline ait İD uyuşmuyor.");

		}

		Language language = new Language();
		language.setId(deleteLanguageRequests.getId());

		languageRepository.delete(language);

	}

	@Override
	public void update(UpdateLanguageRequests updateLanguageRequests) throws Exception {

		if (isNameExist(updateLanguageRequests.getName())) {
			throw new Exception("Aynı isimde bir programlama dili zaten mevcut.");
		}
		if (!isIdExist(updateLanguageRequests.getId())) {
			throw new Exception("Bu ID ile tanımlanmış programlama dili mevcut değil.");
		}
		Language language = new Language();
		language.setId(updateLanguageRequests.getId());
		language.setName(updateLanguageRequests.getName());

		languageRepository.save(language);

	}

	@Override
	public GetByIdLanguageResponse getByIdLanguage(int id) throws Exception {
		if (!isIdExist(id)) {
			throw new Exception("Bu ID ile tanımlanmış programlama dili yok !");
		}

//		Optional<Language> lOptional = languageRepository.findById(id);
		
		
		Language item = this.languageRepository.findById(id).get();

		GetByIdLanguageResponse getByIdLanguageResponse = new GetByIdLanguageResponse();
		getByIdLanguageResponse.setId(item.getId());
		getByIdLanguageResponse.setName(item.getName());

		return getByIdLanguageResponse;
	}

	private boolean isNameExist(String name) {
		for (Language lng : languageRepository.findAll()) {
			if (lng.getName().equalsIgnoreCase(name)) {
				
				return true;
			}
		}
		return false;
	}

	private boolean isIdExist(int id) {
		for (Language lng : languageRepository.findAll()) {
			if (lng.getId() == id) {
				return true;
			}
		}
		return false;
	}

}
