package Kodlama.io.Devs.business.requests.technologyRequests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateTechnologyRequests {

	private int id;
	private String name;
	private int languageId;
}
