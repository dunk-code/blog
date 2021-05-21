package school.xauat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import school.xauat.service.BlogService;

/**
 * @author ：zsy
 * @date ：Created 2021/4/9 17:07
 * @description：归档
 */
@Controller
public class ArchivesShowController {

    @Autowired
    BlogService blogService;

    @GetMapping("/archives")
    public String archives(Model model) {
        model.addAttribute("archiveMap", blogService.archiveBlog());
        model.addAttribute("blogCount", blogService.countBlog());
        return "archives";
    }
}
