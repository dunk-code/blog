package school.xauat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import school.xauat.service.BlogService;

/**
 * @author ：zsy
 * @date ：Created 2021/4/9 17:07
 * @description：关于我
 */
@Controller
public class AboutShowController {

    @Autowired
    BlogService blogService;

    @GetMapping("/about")
    public String about(Model model) {
        return "about";
    }
}
