package com.ivan.xayah.user.handler;

import com.ivan.xayah.dto.InstanceBuildContext;
import com.ivan.xayah.dto.PipelineContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * <p>数据预处理</p>
 *
 * @author ivan
 * @className InputDataPreChecker
 * @since 2021/6/29 22:46
 */
@Component
public class InputDataPreChecker implements ContextHandler<InstanceBuildContext>{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean handle(InstanceBuildContext context) {
        logger.info("--输入数据校验--");
        return true;
    }
}
