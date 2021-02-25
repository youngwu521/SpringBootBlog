package com.young.blog.DAO;

import com.young.blog.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Create by wuyang9769@163.com
 * Decorate:
 * SpringBoot内置JPA
 * @author young_wu
 * @date 2020/12/17 0017 16:55
 * You can't be killed, it will only make you stronger
 */
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsernameAndPassword(String username,String password);

}
