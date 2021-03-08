package com.ivan.xayah.tool.exception;


import com.ivan.xayah.tool.api.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <p></p>
 *
 * @author ivan
 * @className GlobalExceptionHandler
 * @since 2020/12/2 13:17
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public R handleIllegalArgumentException(IllegalArgumentException e) {
        return R.fail(e.getMessage());
    }

    @ExceptionHandler(BizException.class)
    public R handleBizException(BizException e) {
        return R.fail(e.getMessage());
    }

}
