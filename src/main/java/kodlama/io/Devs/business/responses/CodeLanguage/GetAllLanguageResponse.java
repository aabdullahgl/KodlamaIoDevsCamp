package kodlama.io.Devs.business.responses.CodeLanguage;

import java.util.List;

import kodlama.io.Devs.entities.concretes.CodeLanguageTechnology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllLanguageResponse {

	private int id;
	private String name;
	private List<CodeLanguageTechnology> codeLanguageTechnologies;
}
