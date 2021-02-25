//package com.young.blog.Controller;
//
//import com.young.blog.Entity.Comment;
//import com.young.blog.Service.BlogService;
//import com.young.blog.Service.CommentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import javax.validation.Valid;
//
///**
// * Create by wuyang9769@163.com
// * Decorate:
// *
// * @author young_wu
// * @date 2020/12/20 0020 16:19
// * You can't be killed, it will only make you stronger
// */
//@Controller
//public class CommentController {
//
//    @Autowired
//    private CommentService commentService;
//
//    @Autowired
//    private BlogService blogService;
//
//    @Value("${comment.avatar}")
//    private String avatar;
//    // 打开博客页面,评论区加载片段
//    @GetMapping("/comments/{blogId}")
//    public String comments(@PathVariable Long blogId, Model model){
//        model.addAttribute("comments",commentService.listCommentByBlogId(blogId));
//        return "blog :: commentList";
//    }
//
//    // 点击发表评论按钮,发送Post请求
//    @PostMapping("/comments")
//    public String post(Comment comment){
//        // 博客和评论区建立联系
//        Long blogId = comment.getBlog().getId();
//        comment.setBlog(blogService.getBlog(blogId));
//        // 设置头像地址
//        comment.setAvatar(avatar);
//        commentService.saveComment(comment);
//        return "redirect:/comments/"+comment.getBlog().getId();
//    }
//
//
//}
