package Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.TechnologyService;
import Kodlama.io.Devs.business.requests.technologyRequests.CreateTechnologyRequest;
import Kodlama.io.Devs.business.requests.technologyRequests.DeleteTechnologyRequests;
import Kodlama.io.Devs.business.requests.technologyRequests.UpdateTechnologyRequests;
import Kodlama.io.Devs.business.responses.technologyResponses.GetAllTechnologiesResponse;
import Kodlama.io.Devs.business.responses.technologyResponses.GetByIdTechnologyResponse;
import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import Kodlama.io.Devs.entities.concretes.Language;
import Kodlama.io.Devs.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService {

	
	private TechnologyRepository technologyRepository;
	
	private LanguageRepository languageRepository;

	public TechnologyManager(TechnologyRepository technologyRepository, LanguageRepository languageRepository) {
		this.technologyRepository = technologyRepository;
		this.languageRepository = languageRepository;
	}

	@Override
	public List<GetAllTechnologiesResponse> getAll() {
		
		List<Technology> technologies = technologyRepository.findAll();
		List<GetAllTechnologiesResponse> gAllResponse = new ArrayList<>();
		for (Technology tc : technologies) {
			GetAllTechnologiesResponse responseItem = new GetAllTechnologiesResponse();
			responseItem.setId(tc.getId());
			responseItem.setName(tc.getName());
			responseItem.setLanguageId(this.languageRepository.findLanguageById(tc.getLanguage().getId()).getId());

			gAllResponse.add(responseItem);
		}
		return gAllResponse;
	}

	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception {

		if (isNameExist(createTechnologyRequest.getName())) {
			throw new Exception("Eklemek istediğiniz teknoloji zaten mevcut.");
		}
		
		Technology technology = new Technology();
		technology.setId(0);
		technology.setName(createTechnologyRequest.getName());
		Language language = this.languageRepository.getById(createTechnologyRequest.getLanguage_id());
		technology.setLanguage(language);
		this.technologyRepository.saveAndFlush(technology);
		
		
//		Technology technology = new Technology();
//        Language language = this.languageRepository.findLanguageById(createTechnologyRequest.getLanguage_id());
//        technology.setName(createTechnologyRequest.getName());
//        technology.setLanguage(language);
//        
//        technologyRepository.save(technology);

	}

	@Override
	public void delete(DeleteTechnologyRequests deleteTechnologyRequests) throws Exception {
		if (!isIdExist(deleteTechnologyRequests.getId())) {
			throw new Exception("Silmek istediğiniz İD ile teknolojiye ait İD uyuşmuyor.");
		}
		
		Technology technology = new Technology();
		technology.setId(deleteTechnologyRequests.getId());
		
		technologyRepository.delete(technology);
		
	}

	@Override
	public void update(UpdateTechnologyRequests updateTechnologyRequests) throws Exception {
		if (!isIdExist(updateTechnologyRequests.getId())) {
			throw new Exception("Bu ID ile tanımlanmış teknoloji mevcut değil.");
		}
		if (isNameExist(updateTechnologyRequests.getName())) {
			throw new Exception("Aynı isimde teknoloji zaten mevcut.");
		}
//		Optional<Technology> technology = this.technologyRepository.findById(updateTechnologyRequests.getId());
//		
//		GetByIdTechnologyResponse getByIdTechnologyResponse = new GetByIdTechnologyResponse();
//		getByIdTechnologyResponse.setId(updateTechnologyRequests.getId());
//		technology.get().setName(updateTechnologyRequests.getName());
//		
//		this.technologyRepository.save(technology.get());
		
		Technology technology = new Technology();
		technology.setId(updateTechnologyRequests.getId());
		technology.setName(updateTechnologyRequests.getName());
		
		Language language = languageRepository.findById(updateTechnologyRequests.getLanguageId()).get();
		
		technologyRepository.save(technology);
		
	}

	@Override
	public GetByIdTechnologyResponse getByIdTechnology(int id) throws Exception {
		if (!isIdExist(id)) {
			throw new Exception("Sistemde bu ID ile tanımlanmış teknoloji mevcut değil.");
		}
//		Optional<Technology> tecOptional = this.technologyRepository.findById(id);
//		
//		GetByIdTechnologyResponse getByIdTechnologyResponse = new GetByIdTechnologyResponse();
//		getByIdTechnologyResponse.setId(tecOptional.get().getId());
//		getByIdTechnologyResponse.setName(tecOptional.get().getName());
//		return getByIdTechnologyResponse;
		
		Technology item = technologyRepository.findById(id).get();
		
		GetByIdTechnologyResponse getByIdTechnologyResponse = new GetByIdTechnologyResponse();
		getByIdTechnologyResponse.setId(item.getId());
		
		return getByIdTechnologyResponse;
	}
	
	public boolean isIdExist(int id) {
		for (Technology tc : technologyRepository.findAll()) {
			if (tc.getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isNameExist(String name) {
		for (Technology tc : technologyRepository.findAll()) {
			if (tc.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}
	

}
