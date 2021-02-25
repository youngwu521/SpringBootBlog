package com.young.blog.Handler;




import org.dom4j.rule.Mode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Create by wuyang9769@163.com
 * Decorate:
 * 全局异常处理类
 * @author young_wu
 * @date 2020/12/16 0016 17:52
 * You can't be killed, it will only make you stronger
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    // 异常处理
    @ExceptionHandler({Exception.class})
    public ModelAndView handleException(HttpServletRequest request,Exception e) throws Exception {

        logger.error("Request URL : {} ,Exception : {} ",request.getRequestURL(),e);

        if (AnnotationUtils.findAnnotation(e.getClass(),ResponseStatus.class )!= null){

            throw e;
        }
        ModelAndView mav = new ModelAndView();
        mav.addObject("url",request.getRequestURL());
        mav.addObject("exception",e);
        mav.setViewName("error/error");
        return mav;
    }
}
