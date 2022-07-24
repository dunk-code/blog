package school.xauat.service;

import school.xauat.po.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> ListCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);
}
