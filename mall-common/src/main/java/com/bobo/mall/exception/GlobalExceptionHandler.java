package com.bobo.mall.exception;

import com.bobo.mall.exception.GuliException;
import com.bobo.mall.entity.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 处理全局异常
 * @Date 2021/10/15 20:27
 * @Created by bobo
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e) {
        return R.error().message("服务端异常");
    }



    @ExceptionHandler(GuliException.class)
    @ResponseBody
    public R error(GuliException e) {
        return R.error().message(e.getMsg()).code(e.getCode());
    }
}
