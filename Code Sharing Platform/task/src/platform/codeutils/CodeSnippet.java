package platform.codeutils;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CodeSnippet {

    private String code = "public static void main(String[] args) {\n" +
            "    SpringApplication.run(CodeSharingPlatform.class, args);\n" +
            "}";

    private LocalDateTime lastModified;

    public CodeSnippet() {
        this.lastModified = LocalDateTime.now();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
        updateLastModified();
    }

    private void updateLastModified() {
        lastModified = LocalDateTime.now();
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }
}
