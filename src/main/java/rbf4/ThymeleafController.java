package rbf4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rbf4")
public class ThymeleafController {

    @GetMapping
    public String rbf4Index() {
        return "/rbf4/index";
    }
}
