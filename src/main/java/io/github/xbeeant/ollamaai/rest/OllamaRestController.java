package io.github.xbeeant.ollamaai.rest;

import io.github.xbeeant.ollamaai.entity.OllamaClient;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author xiaobiao
 * @date 2024/4/30
 */
@RestController
@RequestMapping("/ollama")
public class OllamaRestController {

    @RequestMapping("/api/chat")
    public void hello(String message, HttpServletResponse response) throws IOException, InterruptedException {
        OllamaClient client = new OllamaClient();
        client.setHost("http://localhost:11434");
        client.setModel("codeqwen:7b-chat");

        client.streamChat(message, response);
    }
}
