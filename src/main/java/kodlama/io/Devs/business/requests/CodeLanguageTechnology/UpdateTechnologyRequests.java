package kodlama.io.Devs.business.requests.CodeLanguageTechnology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTechnologyRequests {

	private int id;
	private String name;
	private int codeLanguageId;
}
