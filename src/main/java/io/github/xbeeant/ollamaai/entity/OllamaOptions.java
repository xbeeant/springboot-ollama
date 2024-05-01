package io.github.xbeeant.ollamaai.entity;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.util.List;

/**
 * Ollama选项配置实体类。<br>
 * 用于定义和存储Ollama模型的运行时参数配置。
 *
 * @author xiaobiao
 * @date 2024/5/1
 */
@Data
public class OllamaOptions {

    /**
     * 保留的最大生成序列数量。
     */
    @JSONField(name = "num_keep")
    private int numKeep;

    /**
     * 随机种子。
     */
    @JSONField(name = "seed")
    private int seed;

    /**
     * 预测生成的序列数量。
     */
    @JSONField(name = "num_predict")
    private int numPredict;

    /**
     * 用于选择的top词的数量。
     */
    @JSONField(name = "top_k")
    private int topK;

    /**
     * 选择概率最高的top_p比例的词汇。
     */
    @JSONField(name = "top_p")
    private double topP;

    /**
     * TFS（Token Frequency Scaled）参数Z值。
     */
    @JSONField(name = "tfs_z")
    private double tfsZ;

    /**
     * 典型性参数P。
     */
    @JSONField(name = "typical_p")
    private double typicalP;

    /**
     * 重复最后一个N个词。
     */
    @JSONField(name = "repeat_last_n")
    private int repeatLastN;

    /**
     * 生成中使用的温度参数。
     */
    @JSONField(name = "temperature")
    private double temperature;

    /**
     * 重复惩罚参数。
     */
    @JSONField(name = "repeat_penalty")
     private double repeatPenalty;

    /**
     * 存在性惩罚参数。
     */
    @JSONField(name = "presence_penalty")
    private double presencePenalty;

    /**
     * 频率惩罚参数。
     */
    @JSONField(name = "frequency_penalty")
    private double frequencyPenalty;

    /**
     * Mirostat间隔。
     */
    @JSONField(name = "mirostat")
    private int mirostat;

    /**
     * Mirostat的τ参数。
     */
    @JSONField(name = "mirostat_tau")
    private double mirostatTau;

    /**
     * Mirostat的η参数。
     */
    @JSONField(name = "mirostat_eta")
    private double mirostatEta;

    /**
     * 是否对换行符进行惩罚。
     */
    @JSONField(name = "penalize_newline")
    private boolean penalizeNewline;

    /**
     * 停止词汇列表。
     */
    @JSONField(name = "stop")
    private List<String> stop;

    /**
     * 是否使用NUMA架构优化。
     */
    @JSONField(name = "numa")
    private boolean numa;

    /**
     * 上下文窗口大小。
     */
    @JSONField(name = "num_ctx")
    private int numCtx;

    /**
     * 批量大小。
     */
    @JSONField(name = "num_batch")
    private int numBatch;

    /**
     * GQA（Generative Question Answering）问题数量。
     */
    @JSONField(name = "num_gqa")
    private int numGqa;

    /**
     * 使用的GPU数量。
     */
    @JSONField(name = "num_gpu")
    private int numGpu;

    /**
     * 主要使用的GPU编号。
     */
    @JSONField(name = "main_gpu")
    private int mainGpu;

    /**
     * 是否使用低显存优化。
     */
    @JSONField(name = "low_vram")
    private boolean lowVram;

    /**
     * 是否使用半精度KV存储。
     */
    @JSONField(name = "f16_kv")
    private boolean f16Kv;

    /**
     * 是否仅使用词汇表。
     */
    @JSONField(name = "vocab_only")
    private boolean vocabOnly;

    /**
     * 是否使用内存映射。
     */
    @JSONField(name = "use_mmap")
    private boolean useMmap;

    /**
     * 是否锁定内存。
     */
    @JSONField(name = "use_mlock")
    private boolean useMlock;

    /**
     * ROPE（Relative Ordinal Position Encoding）频率基础值。
     */
    @JSONField(name = "rope_frequency_base")
    private double ropeFrequencyBase;

    /**
     * ROPE频率缩放值。
     */
    @JSONField(name = "rope_frequency_scale")
    private double ropeFrequencyScale;

    /**
     * 线程数量。
     */
    @JSONField(name = "num_thread")
    private int numThread;
}
