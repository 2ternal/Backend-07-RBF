package rbf4.article;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/rbf4/article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleRepository articleRepository;

    @GetMapping("/1")
    public String page1(Model model) {
        model.addAttribute("article", new Article());
        return "/rbf4/article/page1";
    }

    @GetMapping("/2")
    public String page2(Model model) {
        model.addAttribute("article", new Article());
        return "/rbf4/article/page2";
    }

    @PostMapping("/2")
    public String page2(@ModelAttribute("article") Article article) {
        articleRepository.save(article);
        log.info("article = {}", article);
        return "/rbf4/article/page2";
    }


}
