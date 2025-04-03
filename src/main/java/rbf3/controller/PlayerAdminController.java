package rbf3.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import rbf3.config.AppConfigV1;
import rbf3.data.Player;
import rbf3.service.PlayerService;

@Slf4j
@Controller
@ResponseBody
@RequestMapping("/admin/players")
public class PlayerAdminController {

    private final PlayerService playerService;

    public PlayerAdminController(PlayerService playerService) {
        this.playerService = playerService;
    }

//    http://localhost:8080/admin/players/view?id=1
    @GetMapping("/view")
    public String showPlayer(@RequestParam("id") int id) {
        Player player = playerService.getPlayer(id);
        log.info("Showing player: {}", player);
        return player.toString();
    }

//    http://localhost:8080/admin/players/register?name=aaa&age=15
    @GetMapping("/register")
    public String registerPlayer(@RequestParam("name") String name,
                                 @RequestParam("age") int age) {
        playerService.registerPlayer(name, age);
        log.info("Registered player: {}", name);
        return "ok";
    }

    @GetMapping("/beans")
    public String showBeans() {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            log.info(beanDefinitionName);

            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            log.info("beanDefinition = {}", beanDefinition);
        }

        return "beans";
    }
}
