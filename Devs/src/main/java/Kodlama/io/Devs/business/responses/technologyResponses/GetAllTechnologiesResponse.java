package Kodlama.io.Devs.business.responses.technologyResponses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllTechnologiesResponse {

	private int id;
	private String name;
	private int languageId;
}
