package com.young.blog.DAO;

import com.young.blog.Entity.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Create by wuyang9769@163.com
 * Decorate:
 *
 * @author young_wu
 * @date 2020/12/18 0018 18:00
 * You can't be killed, it will only make you stronger
 */
public interface TagRepository extends JpaRepository<Tag,Long> {

    Tag findByName(String name);

    // 首页拿数据
    @Query("select t from Tag t")
    List<Tag> findTop(Pageable pageable);

}
