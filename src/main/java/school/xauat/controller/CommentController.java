package school.xauat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import school.xauat.po.Comment;
import school.xauat.po.User;
import school.xauat.service.BlogService;
import school.xauat.service.CommentService;

import javax.servlet.http.HttpSession;

/**
 * @author ：zsy
 * @date ：Created 2021/4/8 20:12
 * @description：博客评论
 */
@Controller
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    BlogService blogService;

    @Value("${comment.avatar}")
    private String avatar;

    @GetMapping("comments/{blogId}")
    public String comments(@PathVariable Long blogId, Model model) {
        model.addAttribute("comments", commentService.ListCommentByBlogId(blogId));
        return "blog :: commentList";
    }

    @PostMapping("/comments")
    public String post(Comment comment, HttpSession session) {
        Long blogId = comment.getBlog().getId();
        comment.setBlog(blogService.getBlog(blogId));
        User user = (User) session.getAttribute("user");
        if (user != null) {
            comment.setAvatar(user.getAvatar());
            comment.setAdminComment(true);
            comment.setNickname(user.getNickname());
        } else {
            comment.setAvatar(avatar);
        }
        Comment c = commentService.saveComment(comment);
        return "redirect:comments/" + comment.getBlog().getId();
    }
}
