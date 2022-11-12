package Kodlama.io.Devs.business.requests.technologyRequests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateTechnologyRequest  {
	
	private String name;
	private int language_id;
}
