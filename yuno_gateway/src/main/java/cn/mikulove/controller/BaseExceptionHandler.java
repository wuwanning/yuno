package cn.mikulove.controller;

import cn.mikulove.entity.Result;
import cn.mikulove.entity.StatusCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by Administrator on 2019/6/9.
 */
@RestControllerAdvice
public class BaseExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public Result error(Exception e) {
        return new Result(false, StatusCode.ERROR, e.getMessage());
    }
}
