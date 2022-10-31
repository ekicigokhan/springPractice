package Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.entities.concretes.Language;

public interface LanguageService {
	
	List<Language> getAllLanguages();
	
	void add(Language language)throws Exception;
	void delete(int id)throws Exception;
	void update(int id, Language language)throws Exception;
	
	Language getById(int id)throws Exception;
}
