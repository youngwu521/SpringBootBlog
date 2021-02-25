package com.young.blog.Service;

import com.young.blog.Entity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by wuyang9769@163.com
 * Decorate:
 *
 * @author young_wu
 * @date 2020/12/20 0020 16:27
 * You can't be killed, it will only make you stronger
 */
public interface CommentService {
    // 加载List评论
    List<Comment> listCommentByBlogId(Long blogId);

    // save
    Comment saveComment(Comment comment);
}
