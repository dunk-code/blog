package school.xauat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import school.xauat.po.Blog;
import school.xauat.po.Tag;
import school.xauat.service.BlogService;
import school.xauat.service.TagService;

import java.util.List;

/**
 * @author ：zsy
 * @date ：Created 2021/4/9 15:32
 * @description：标签展示
 */
@Controller
public class TagShowController {

    @Autowired
    TagService tagService;

    @Autowired
    BlogService blogService;

    @GetMapping("/tags/{id}")
    public String tags(@PageableDefault(size = 5, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                       @PathVariable Long id, Model model) {
        List<Tag> tags = tagService.listTag();
        if (id == -1) {
            id = tags.get(0).getId();
        }
        model.addAttribute("tags", tagService.listTag());
        model.addAttribute("page", blogService.listBlog(id, pageable));
        model.addAttribute("activeTagId", id);
        return "tags";
    }
}
