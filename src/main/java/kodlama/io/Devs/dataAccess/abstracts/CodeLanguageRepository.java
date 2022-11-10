package kodlama.io.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlama.io.Devs.entities.concretes.CodeLanguage;

@Repository
public interface CodeLanguageRepository extends JpaRepository<CodeLanguage,Integer> {

}
