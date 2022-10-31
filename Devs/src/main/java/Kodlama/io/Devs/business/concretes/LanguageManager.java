package Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.LanguageService;

import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {

	private LanguageRepository languageRepository;

	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public List<Language> getAllLanguages() {

		return languageRepository.getAllLanguages();
	}

	@Override
	public void add(Language language) throws Exception {

		if (isIdExist(language.getId())) {
			throw new Exception("Bu ID zaten kayıtlı !");
		}
		if (isNameValid(language.getName())) {
			languageRepository.add(language);
		}

	}

	@Override
	public void delete(int id) throws Exception {

		if (!isIdExist(id)) {
			throw new Exception("ID bulunamadı  !");
		}
		
		languageRepository.delete(id);

	}

	@Override
	public void update(int id, Language language) throws Exception {

		if (!isIdExist(id)) {
			throw new Exception("İD bulunamadı !");
		}
		if (isNameValid(language.getName())) {
			languageRepository.update(id, language);
		}
	}

	@Override
	public Language getById(int id) throws Exception {
		if (!isIdExist(id)) {
			throw new Exception("ID bulunamadı.");
		}
		return languageRepository.getById(id);
	}

	public boolean isNameValid(String language) throws Exception {

		if (language.isBlank()) {
			throw new Exception("Boş geçilemez !");
		}

		for (Language lng : getAllLanguages()) {
			if (lng.getName().equalsIgnoreCase(language)) {
				throw new Exception("Bu dil zaten tanımlanmış.");
			}

		}
		return true;
	}

	public boolean isIdExist(int id) throws Exception {
		for (Language lng : getAllLanguages()) {
			if (lng.getId() == id) {
				return true;
			}
		}
		return false;
	}

}
