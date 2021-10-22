package platform.codeutils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import platform.codeutils.repository.CodeRepository;

import java.util.List;

@Service
public class CodeProvider {


    private final CodeRepository codeRepository;



    @Autowired
    public CodeProvider ( CodeRepository codeRepository) {

        this.codeRepository = codeRepository;
    }

    public CodeSnippet save(CodeSnippet codeSnippet) {
        return codeRepository.save(codeSnippet);
    }

    public CodeSnippet findCodeSnippetById(Long id) {
        return codeRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Code not found for id = " + id));
    }

    public List<CodeSnippet> get10LatestCodeSnippets() {
        return codeRepository.findTop10ByOrderByIdDesc();
    }


}
