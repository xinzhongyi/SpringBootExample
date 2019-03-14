package com.test1.exception;

import com.test1.dao.ResponseResult;
import com.test1.enums.ResultEnum;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.*;

/**
 * Created by Administrator on 2018/4/26.
 */
@ControllerAdvice
public class ExceptionHandle {
    /**
     * 拦截捕捉自定义异常 ConstraintViolationException.class
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseResult ConstraintViolationExceptionHandler(ConstraintViolationException ex) {
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
        List<String> msgList = new ArrayList<>();
        while (iterator.hasNext()) {
            ConstraintViolation<?> cvl = iterator.next();
            msgList.add(cvl.getMessageTemplate());
        }

        return ResponseResult.fail(400,msgList.toString()) ;
    }

    //添加全局异常处理流程，根据需要设置需要处理的异常，本文以MethodArgumentNotValidException为例
    @ExceptionHandler(value=MethodArgumentNotValidException.class)
    @ResponseBody
    public Object MethodArgumentNotValidHandler(HttpServletRequest request,
                                                MethodArgumentNotValidException exception) throws Exception
    {
        //按需重新封装需要返回的错误信息
        List<String> msgList = new ArrayList<>();
        //解析原错误信息，封装后返回，此处返回非法的字段名称，原始值，错误信息
        for (FieldError error : exception.getBindingResult().getFieldErrors()) {
            msgList.add(error.getDefaultMessage()) ;
        }

        return  ResponseResult.fail(400,msgList.toString()) ;
    }


    @ExceptionHandler(value = TestException.class)
    @ResponseBody
    public ResponseResult handleTestException(Exception e){
        TestException testException = (TestException) e;
        return ResponseResult.fail(testException.getCode(),testException.getMessage()) ;
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseResult handleException(Exception e){
        return ResponseResult.fail(ResultEnum.SYSTEM_ERROR.getCode(),ResultEnum.SYSTEM_ERROR.getMsg()) ;
    }
}
