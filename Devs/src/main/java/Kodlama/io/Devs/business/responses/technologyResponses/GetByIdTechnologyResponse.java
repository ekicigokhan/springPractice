package Kodlama.io.Devs.business.responses.technologyResponses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GetByIdTechnologyResponse {

	private int id;
	private String name;
	private int languageId;
}
