package com.young.blog.Service;

import com.young.blog.Entity.User;

/**
 * Create by wuyang9769@163.com
 * Decorate:
 *
 * @author young_wu
 * @date 2020/12/17 0017 16:49
 * You can't be killed, it will only make you stronger
 */
public interface UserService {
    User checkUser(String username, String password);

}
