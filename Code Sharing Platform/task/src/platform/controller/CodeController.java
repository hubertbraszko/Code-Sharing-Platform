package platform.controller;

import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import platform.codeutils.CodeProvider;
import platform.codeutils.CodeSnippet;


@Controller
public class CodeController {

    @Autowired
    private CodeProvider codeProvider;


    @PostMapping("/api/code/new")
    public ResponseEntity<String> postNewCode(@RequestBody CodeSnippet codeSnippet) {
        codeProvider.setCode(codeSnippet.getCode());

        return ResponseEntity.ok("");
    }


    @GetMapping("/api/code")
    public ResponseEntity<String> getCodeInJson() {

        return ResponseEntity.ok(codeProvider.getCodeAsJson());

    }

    @GetMapping("/code")
    public ResponseEntity<String> getCodeRaw() {

        return ResponseEntity.ok(codeProvider.getCodeWrappedInHtml());

    }

    @GetMapping("/code/new")
    public ModelAndView getNewCodeForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("newCode.html");
        return modelAndView;
    }


}
