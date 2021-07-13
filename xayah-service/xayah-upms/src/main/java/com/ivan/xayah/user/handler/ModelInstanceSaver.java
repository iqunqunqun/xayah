package com.ivan.xayah.user.handler;

import com.ivan.xayah.dto.InstanceBuildContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>数据保存</p>
 *
 * @author ivan
 * @className ModelInstanceSaver
 * @since 2021/6/29 22:50
 */
public class ModelInstanceSaver implements ContextHandler<InstanceBuildContext>{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean handle(InstanceBuildContext context) {
        logger.info("--保存模型实例到相关DB表--");
        return true;
    }
}
