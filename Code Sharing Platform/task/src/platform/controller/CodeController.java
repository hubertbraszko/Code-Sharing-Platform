package platform.controller;

import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import platform.codeutils.CodeProvider;

@RestController
public class CodeController {

    @Autowired
    private CodeProvider codeProvider;





    @GetMapping("api/code")
    public ResponseEntity<String> getCodeInJson() {

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("code",codeProvider.getCode());

        return ResponseEntity.ok(jsonObject.toString());

    }

    @GetMapping("/code")
    public ResponseEntity<String> getCodeRaw() {

        return ResponseEntity.ok(codeProvider.getCodeWrappedInHtml());

    }



}
