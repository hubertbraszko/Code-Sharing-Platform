package platform.codeutils;

import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class CodeProvider {


    private CodeSnippet codeSnippet;

    @Autowired
    public CodeProvider (CodeSnippet codeSnippet) {
        this.codeSnippet= codeSnippet;
    }

    public String getCode() {
        return codeSnippet.getCode();
    }

    public String getCodeWrappedInHtml() {
        return "<html>\n" +
                "<head>\n" +
                "    <title>Code</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <pre>\n" +
                "<pre id=\"code_snippet\">" + codeSnippet.getCode() + "</pre>\n" +
                "<span id=\"load_date\">" + codeSnippet.getLastModified().toString() + "</span>" +
                "</pre>\n" +
                "</body>\n" +
                "</html>";

    }

    public String getCodeAsJson() {
        JsonObject codeSnippetJson = new JsonObject();
        codeSnippetJson.addProperty("code", codeSnippet.getCode());
        codeSnippetJson.addProperty("date", codeSnippet.getLastModified().toString());

        return codeSnippetJson.toString();
    }

    public void setCode(String code) {
        codeSnippet.setCode(code);
    }

}
