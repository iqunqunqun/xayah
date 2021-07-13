package com.ivan.xayah.dto;

import lombok.Data;

import java.util.Map;

/**
 * <p>模型实例构建的上下文</p>
 *
 * @author ivan
 * @className InstanceBuildContext
 * @since 2021/6/29 22:44
 */
@Data
public class InstanceBuildContext extends PipelineContext{
    /**
     * 模型 id
     */
    private Long modelId;

    /**
     * 用户 id
     */
    private long userId;

    /**
     * 表单输入
     */
    private Map<String, Object> formInput;

    /**
     * 保存模型实例完成后，记录下 id
     */
    private Long instanceId;

    /**
     * 模型创建出错时的错误信息
     */
    private String errorMsg;

    @Override
    public String getName() {
        return "模型实例构建上下文";
    }
}
