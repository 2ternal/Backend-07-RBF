package rbf4.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rbf4/users")
public class UserController {

    @GetMapping("/admin")
    public String admin(Model model) {
        User user = new User("관리자A", "ADMIN");
        model.addAttribute("user", user);
        return "/rbf4/user/page3";
    }

    @GetMapping("/user")
    public String user(Model model) {
        User user = new User("유저B", "USER");
        model.addAttribute("user", user);
        return "/rbf4/user/page3";
    }

    @GetMapping("/developer")
    public String developer(Model model) {
        User user = new User("개발자C", "DEVELOPER");
        model.addAttribute("user", user);
        return "/rbf4/user/page3";
    }

    @GetMapping("/{outsider}")
    public String outsider(@PathVariable String outsider, Model model) {
        User user = new User("외부인", outsider);
        model.addAttribute("user", user);
        return "/rbf4/user/page3";
    }
}
