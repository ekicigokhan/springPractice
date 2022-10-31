package Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.Language;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {

	List<Language> languages;

	public InMemoryLanguageRepository() {

		languages = new ArrayList<Language>();
		languages.add(new Language(1, "C#"));
		languages.add(new Language(2, "Java"));
		languages.add(new Language(3, "Python"));

	}

	@Override
	public List<Language> getAllLanguages() {

		return languages;
	}

	@Override
	public void add(Language language) {

		languages.add(language);

	}

	@Override
	public void delete(int id) {

		languages.removeIf(item -> item.getId() == id);

	}

	@Override
	public void update(int id, Language language) {
		
		Language language2 = getById(id);
		language2.setName(language.getName());

	}

	@Override
	public Language getById(int id) {

		for (Language lng : languages) {
			if (lng.getId() == id) {
				return lng;
			}
		}
		return null;
		
	}

}
