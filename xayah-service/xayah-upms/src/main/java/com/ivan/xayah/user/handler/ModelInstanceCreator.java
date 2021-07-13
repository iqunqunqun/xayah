package com.ivan.xayah.user.handler;

import com.ivan.xayah.dto.InstanceBuildContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>数据模型构建</p>
 *
 * @author ivan
 * @className ModelInstanceCreator
 * @since 2021/6/29 22:49
 */
public class ModelInstanceCreator implements ContextHandler<InstanceBuildContext>{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean handle(InstanceBuildContext context) {
        logger.info("--根据输入数据创建模型实例--");
        return true;
    }
}
