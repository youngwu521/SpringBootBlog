package com.young.blog.Service;

import com.young.blog.Entity.Blog;
import com.young.blog.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Create by wuyang9769@163.com
 * Decorate:
 *
 * @author young_wu
 * @date 2020/12/18 0018 17:25
 * You can't be killed, it will only make you stronger
 */
public interface BlogService {

    Blog getBlog(Long id);

    Page<Blog> listBlog(Pageable pageable,BlogQuery blog);
//    Page<Blog> listBlog(Pageable pageable,Blog blog);

    Page<Blog> listBlog(Pageable pageable);

    Blog saveBlog(Blog blog);

    Blog updateBlog(Long id,Blog blog);

    void deleteBlog(Long id);

    // 按时间排序
    List<Blog> listRecommendBlogTop(Integer size);


    // 全局搜锁
    Page<Blog> listBlog(String query,Pageable pageable);

    // markedown
    Blog getAndConvert(Long id);
}
