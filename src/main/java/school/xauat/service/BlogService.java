package school.xauat.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import school.xauat.po.Blog;

import java.util.List;
import java.util.Map;

/**
 * @author ：zsy
 * @date ：Created 2021/4/6 22:43
 * @description：博客
 */
public interface BlogService {

    Blog saveBlog(Blog blog);

    Blog getBlog(Long id);

    Page<Blog> listBlog(Pageable pageable);

    Page<Blog> listBlog(String query, Pageable pageable);

    Page<Blog> listBlog(Pageable pageable, Blog blog);

    Page<Blog> listBlog(Long tagId, Pageable pageable);

    Blog getAndConvert(Long id);

    List<Blog> listRecommendBlogTop(Integer size);

    Map<String, List<Blog>> archiveBlog();

    Long countBlog();

    Blog updateBlog(Long id, Blog blog);

    void deleteBlog(Long id);
}
