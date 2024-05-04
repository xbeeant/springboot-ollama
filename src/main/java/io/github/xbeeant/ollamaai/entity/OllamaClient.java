package io.github.xbeeant.ollamaai.entity;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaobiao
 * @date 2024/4/30
 */
@Data
public class OllamaClient {

    private String host;

    private String model;

    public void streamChat(String content, HttpServletResponse response) throws IOException, InterruptedException {
        List<OllamaChat.Message> messages = new ArrayList<>();
        messages.add(new OllamaChat.Message(OllamaChat.Role.USER, content, null));

        OllamaChat chat = new OllamaChat();
        chat.setModel(model);
        chat.setMessages(messages);
        chat.setStream(true);

        response.setContentType("text/event-stream");
        response.setHeader("Cache-Control","no-store");
        response.setCharacterEncoding("UTF-8");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(getHost() + "/api/chat"))
                // 确保请求头包含正确的SSE类型
                .header("Accept", "text/event-stream")
                .POST(HttpRequest.BodyPublishers.ofString(JSON.toJSONString(chat)))
                .build();

        HttpResponse<InputStream> clientResponse = client.send(request, HttpResponse.BodyHandlers.ofInputStream());

        if (clientResponse.statusCode() == 200) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientResponse.body(), StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    // 处理SSE事件
                    // System.out.println(line);
                    response.getWriter().write(line + "\n");
                    response.flushBuffer();
                }
            }
        } else {
            System.err.println("Failed to receive SSE stream: " + clientResponse.statusCode());
        }
    }
}
