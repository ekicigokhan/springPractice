package Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.business.requests.languageRequests.CreateLanguageRequest;
import Kodlama.io.Devs.business.requests.languageRequests.DeleteLanguageRequests;
import Kodlama.io.Devs.business.requests.languageRequests.UpdateLanguageRequests;
import Kodlama.io.Devs.business.responses.languageResponses.GetAllLanguagesResponse;
import Kodlama.io.Devs.business.responses.languageResponses.GetByIdLanguageResponse;
import Kodlama.io.Devs.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {

	private LanguageService languageService;

	@Autowired
	public LanguageController(LanguageService languageService) {

		this.languageService = languageService;
	}

	@GetMapping
	public List<GetAllLanguagesResponse> getAll() {

		return languageService.getAll();
	}

	@PostMapping("/add")
	public void add(@RequestBody CreateLanguageRequest createLanguageRequest) throws Exception {

		languageService.add(createLanguageRequest);
	}

	@DeleteMapping("/delete")
	public void delete(@RequestBody DeleteLanguageRequests deleteLanguageRequests) throws Exception {

		languageService.delete(deleteLanguageRequests);
	}

	@PutMapping("/update")
	public void update(@RequestBody UpdateLanguageRequests updateLanguageRequests) throws Exception {

		languageService.update(updateLanguageRequests);
	}

	@GetMapping("/getbyid")
	public GetByIdLanguageResponse getByIdLanguage(@RequestParam int id)
			throws Exception {
		return languageService.getByIdLanguage(id);
	}

}
