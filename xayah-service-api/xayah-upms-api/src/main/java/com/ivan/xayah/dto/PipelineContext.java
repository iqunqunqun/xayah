package com.ivan.xayah.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>传递到管道的上下文</p>
 *
 * @author ivan
 * @className PipelineContext
 * @since 2021/6/29 22:25
 */

@Data
public class PipelineContext {
    /**
     * 处理的开始时间
     */
    private LocalDateTime startTime;

    /**
     * 处理的结束时间
     */
    private LocalDateTime endTime;

    /**
     * 获取数据名称
     */
    public String getName() {
        return this.getClass().getName();
    }
}
