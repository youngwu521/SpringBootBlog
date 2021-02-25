package com.young.blog.DAO;

import com.young.blog.Entity.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Create by wuyang9769@163.com
 * Decorate:
 *
 * @author young_wu
 * @date 2020/12/17 0017 19:57
 * You can't be killed, it will only make you stronger
 */
public interface TypeRepositroy extends JpaRepository<Type,Long> {
    Type findByName(String name);

    // index页面拿数据
    @Query("select t from Type t")
    List<Type> findTop(Pageable pageable);
}
