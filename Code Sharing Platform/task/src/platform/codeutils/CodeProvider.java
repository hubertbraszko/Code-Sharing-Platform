package platform.codeutils;

import com.google.gson.JsonObject;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CodeProvider {


    private final CodeRepository codeRepository;

    //private CodeSnippet codeSnippet;

    @Autowired
    public CodeProvider ( CodeRepository codeRepository) {
       // this.codeSnippet= codeSnippet;
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

//    public CodeSnippet getCodeSnippet() {
//        return codeSnippet;
//    }
//
//    public String getCode() {
//        return codeSnippet.getCode();
//    }

//    public String getCodeWrappedInHtml() {
//        return "<html>\n" +
//                "<head>\n" +
//                "    <title>Code</title>\n" +
//                "</head>\n" +
//                "<body>\n" +
//                "    <pre>\n" +
//                "<pre id=\"code_snippet\">" + codeSnippet.getCode() + "</pre>\n" +
//                "<span id=\"load_date\">" + codeSnippet.getLastModified().toString() + "</span>" +
//                "</pre>\n" +
//                "</body>\n" +
//                "</html>";
//
//    }

//    public String getCodeAsJson() {
//        JsonObject codeSnippetJson = new JsonObject();
//        codeSnippetJson.addProperty("code", codeSnippet.getCode());
//        codeSnippetJson.addProperty("date", codeSnippet.getLastModified().toString());
//
//        return codeSnippetJson.toString();
//    }
//
//    public void setCode(String code) {
//        codeSnippet.setCode(code);
//    }

}
