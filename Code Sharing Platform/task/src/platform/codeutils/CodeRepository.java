package platform.codeutils;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CodeRepository extends CrudRepository<CodeSnippet,Long>  {
    List<CodeSnippet> findTop10ByOrderByIdDesc();
}
