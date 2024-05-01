package io.github.xbeeant.ollamaai.entity;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 表示与Ollama AI服务聊天流交互的响应实体类。
 * 该类封装了聊天会话的详细信息，如时间戳、消息内容、完成状态以及处理和评估的持续时间。
 *
 * @author xiaobiao
 * @since 2024/5/1
 */
public class OllamaChatStreamResponse {
    /**
     * 聊天响应使用的AI模型标识。
     */
    private String model;

    /**
     * 响应创建的时间戳，按照JSONField注解指定的ISO 8601格式（带时区）。
     */
    @JSONField(format = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSZ")
    private LocalDateTime createdAt;

    /**
     * 聊天响应中的消息详情。
     */
    private Message message;

    /**
     * 标记聊天响应是否已完成。
     */
    private boolean done;

    /**
     * 处理请求的总时间，以毫秒计。
     */
    @JSONField(name = "total_duration")
    private long totalDuration;

    /**
     * 加载模型所需的时间，以毫秒计。
     */
    @JSONField(name = "load_duration")
    private long loadDuration;

    /**
     * 提示评估的次数。
     */
    @JSONField(name = "prompt_eval_count")
    private int promptEvalCount;

    /**
     * 所有提示评估的总耗时，以毫秒计。
     */
    @JSONField(name = "prompt_eval_duration")
    private long promptEvalDuration;

    /**
     * 在处理过程中进行的评估次数。
     */
    @JSONField(name = "eval_count")
    private int evalCount;

    /**
     * 所有评估的总耗时，以毫秒计。
     */
    @JSONField(name = "eval_duration")
    private long evalDuration;

    /**
     * 内部类，代表聊天流中的单个消息，包含发送者角色和消息内容。
     */
    @Data
    public static class Message {
        /**
         * 消息发送者的角色。
         */
        private String role;

        /**
         * 消息的具体内容。
         */
        private String content;
    }
}
