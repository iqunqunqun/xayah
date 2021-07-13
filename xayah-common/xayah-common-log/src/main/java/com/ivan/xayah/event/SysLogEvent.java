package com.ivan.xayah.event;

import org.springframework.context.ApplicationEvent;

/**
 * <p></p>
 *
 * @author ivan
 * @className SysLogEvent
 * @since 2021/3/10 22:13
 */
public class SysLogEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public SysLogEvent(Object source) {
        super(source);
    }
}
