package io.github.xbeeant.ollamaai.entity;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * <p>Ollama实体类，用于定义Ollama的基本属性和配置。</p>
 *
 * @author xiaobiao
 * @since 2024/5/1
 */
@Data
public class Ollama {

    /**
     * 模型名称。
     */
    private String model;

    /**
     * 是否为流式处理。
     */
    private Boolean stream;

    /**
     * 数据格式。
     */
    private String format;

    /**
     * 配置选项。
     */
    private OllamaOptions options;

    /**
     * <p>保持活动状态设置。</p>
     * <p>此字段在JSON序列化时对应的名称为"keep_alive"，通过@JSONField注解指定。</p>
     */
    @JSONField(name = "keep_alive")
    private String keepAlive;
}
