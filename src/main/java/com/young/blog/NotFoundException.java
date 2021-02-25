package com.young.blog;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Create by wuyang9769@163.com
 * Decorate:
 * 异常处理：页面不存在
 * @author young_wu
 * @date 2020/12/16 0016 18:18
 * You can't be killed, it will only make you stronger
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{
    public NotFoundException() {

    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
