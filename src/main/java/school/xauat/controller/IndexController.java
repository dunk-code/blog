package school.xauat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import school.xauat.exception.NotFoundException;
import school.xauat.po.Blog;
import school.xauat.service.BlogService;
import school.xauat.service.CommentService;
import school.xauat.service.TagService;
import school.xauat.service.TypeService;
import school.xauat.util.RedisUtil;


/**
 * @author ：zsy
 * @date ：Created 2021/3/31 21:59
 * @description：首页请求
 */
@Controller
public class IndexController {

    @Autowired
    BlogService blogService;

    @Autowired
    TypeService typeService;

    @Autowired
    TagService tagService;

    @Autowired
    RedisUtil redisUtil;

    @GetMapping(value = {"/", "/index"})
    public String index(@PageableDefault(size = 5, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                        Model model) {
        model.addAttribute("page", blogService.listBlog(pageable));
        model.addAttribute("types", typeService.listTypeTop(6));
        model.addAttribute("tags", tagService.listTagTop(10));
        model.addAttribute("recommendBlogs", blogService.listRecommendBlogTop(8));
        return "index";
    }

    @PostMapping("/search")
    public String search(@PageableDefault(size = 8, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                         @RequestParam String query, Model model) {
        model.addAttribute("page", blogService.listBlog("%" + query + "%", pageable));
        model.addAttribute("query", query);
        return "search";
    }

    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.getAndConvert(id));
        return "blog";
    }

    @GetMapping("/footer/newBlog")
    public String newBlogs(Model model) {
        model.addAttribute("newBlogs", blogService.listRecommendBlogTop(3));
        return "_fragment :: newBlogList";
    }

    @GetMapping("/footer/blogMessage")
    public String blogMessage(Model model) {
        model.addAttribute("blogCount", blogService.countBlog());
        Long policyId = redisUtil.incrBy("policyId", 1);
        model.addAttribute("policyId", (long)policyId);
        return "_fragment :: blogMessage";
    }
}
