package io.github.xbeeant.ollamaai.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * OllamaChat类，表示一次与Ollama的聊天会话。
 *
 * @author xiaobiao
 * @since 2024/5/1
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class OllamaChat extends Ollama {
    /**
     * 存储聊天中的消息列表。
     */
    private List<Message> messages;

    /**
     * 聊天中消息的角色枚举。
     */
    public enum Role {
        /**
         * 系统消息角色。
         */
        SYSTEM,
        /**
         * 用户消息角色。
         */
        USER,
        /**
         * 助手消息角色。
         */
        ASSISTANT;
    }

    /**
     * OllamaChat的内部类，表示一条聊天消息。
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Message {
        /**
         * 消息的角色。
         */
        private Role role;

        /**
         * 消息的内容。
         */
        private String content;

        /**
         * 消息中包含的图片地址列表。
         */
        private String images;
    }
}
