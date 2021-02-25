package com.young.blog.DAO;

import com.young.blog.Entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Create by wuyang9769@163.com
 * Decorate:
 *
 * @author young_wu
 * @date 2020/12/18 0018 17:31
 * You can't be killed, it will only make you stronger
 */
public interface BlogRepository extends JpaRepository<Blog,Long>, JpaSpecificationExecutor<Blog> {
    // 首页受推荐的博客
    @Query("select b from Blog b where b.recommend = true")
    List<Blog> findTop(Pageable pageable);

    // 全局搜索
    @Query("select b from Blog b where b.title like ?1 or b.content like ?1 ")
    Page<Blog> findByQuery(String query,Pageable pageable);
}
