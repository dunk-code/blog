package school.xauat.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import school.xauat.po.Comment;

import java.util.List;

/**
 * @author ：zsy
 * @date ：Created 2021/4/8 20:21
 * @description：博客评论
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByBlogIdAndParentCommentNull(Long blogId, Sort sort);
}
