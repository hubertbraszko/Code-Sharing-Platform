package platform.codeutils;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CodeRepository extends CrudRepository<CodeSnippet,Long>  {

}
