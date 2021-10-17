package platform.codeutils;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class CodeProvider {

    private String code = "public static void main(String[] args) {\n" +
            "    SpringApplication.run(CodeSharingPlatform.class, args);\n" +
            "}";


    public String getCode() {
        return code;
    }

    public String getCodeWrappedInHtml() {
        return "<html>\n" +
                "<head>\n" +
                "    <title>Code</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <pre>\n" +
                code +
                "</pre>\n" +
                "</body>\n" +
                "</html>";

    }

    public void setCode(String code) {
        this.code=code;
    }

}
