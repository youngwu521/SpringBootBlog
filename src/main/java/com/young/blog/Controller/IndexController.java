package com.young.blog.Controller;



import com.young.blog.NotFoundException;
import com.young.blog.Service.BlogService;
import com.young.blog.Service.TagService;
import com.young.blog.Service.TypeService;
import com.young.blog.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.metrics.StartupStep;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Create by wuyang9769@163.com
 * Decorate:
 *
 * @author young_wu
 * @date 2020/12/16 0016 17:38
 * You can't be killed, it will only make you stronger
 */
@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @GetMapping("/")
    public  String index(@PageableDefault(size = 8, sort = {"updateTime"},
                         direction = Sort.Direction.DESC) Pageable pageable,
                         BlogQuery blog,
                         Model model
                        ){
        // 拿到了分页的数据
        model.addAttribute("page",blogService.listBlog(pageable));
        model.addAttribute("types",typeService.listTypeTop(6));
        model.addAttribute("tags",tagService.listTagTop(10));
        model.addAttribute("recommendBlogs",blogService.listRecommendBlogTop(8));
        return "index";
    }

    @PostMapping("/search")
    public String search(@PageableDefault(size = 8, sort = {"updateTime"},
                         direction = Sort.Direction.DESC) Pageable pageable,
                         BlogQuery blog,
                         @RequestParam String query,
                         Model model
                        ){
        model.addAttribute("page",blogService.listBlog("%"+query+"%",pageable));
        model.addAttribute("query",query);
        return "search";
    }

    @GetMapping("/blog/{id}")
    public  String blog( @PathVariable  Long id,Model model){
        model.addAttribute("blog",blogService.getAndConvert(id));
        return "blog";
    }
}
