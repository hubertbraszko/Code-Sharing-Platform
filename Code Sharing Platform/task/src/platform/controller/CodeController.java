package platform.controller;

import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import platform.codeutils.CodeProvider;
import platform.codeutils.CodeSnippet;


@Controller
public class CodeController {

    @Autowired
    private CodeProvider codeProvider;


    @PostMapping("/api/code/new")
    public ResponseEntity<String> postNewCode(@RequestBody CodeSnippet codeSnippet) {
        //codeProvider.setCode(codeSnippet.getCode());
        CodeSnippet newCodeSnippet = codeProvider.save(codeSnippet);

        JsonObject json = new JsonObject();
        json.addProperty("id", newCodeSnippet.getId());

        return ResponseEntity.ok(json.toString());
    }


    @GetMapping("/api/code/{id}")
    public ResponseEntity<CodeSnippet> getCodeInJson(@PathVariable long id) {

        return ResponseEntity.ok(codeProvider.findCodeSnippetById(id));

    }



    @GetMapping("/code/{id}")
    public ModelAndView getCodeRaw(@PathVariable long id, Model model) {
        model.addAttribute("snippet", codeProvider.findCodeSnippetById(id));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("codeSnippet.html");
        return modelAndView;

    }

    @GetMapping("/code/new")
    public ModelAndView getNewCodeForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("newCode.html");
        return modelAndView;
    }


    @GetMapping("/code/latest")
    public ModelAndView getlatestSnippets(Model model) {
        model.addAttribute("snippets",codeProvider.get10LatestCodeSnippets());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("latestSnippets.html");
        return modelAndView;
    }

}
