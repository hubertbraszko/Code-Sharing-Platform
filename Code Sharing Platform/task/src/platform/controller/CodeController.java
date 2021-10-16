package platform.controller;

import com.google.gson.JsonObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodeController {

    private String code = "public static void main(String[] args) {\n" +
            "    SpringApplication.run(CodeSharingPlatform.class, args);\n" +
            "}";

    private String codeWrappedInHtml =
            "<html>\n" +
                    "<head>\n" +
                    "    <title>Code</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <pre>\n" +
                    code +
                    "</pre>\n" +
                    "</body>\n" +
                    "</html>";


    @GetMapping("api/code")
    public ResponseEntity<String> getCodeInJson() {

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("code",code);

        return ResponseEntity.ok(jsonObject.toString());

    }

    @GetMapping("/code")
    public ResponseEntity<String> getCodeRaw() {

        return ResponseEntity.ok(codeWrappedInHtml);

    }



}
