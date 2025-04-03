package rbf3.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rbf3.service.PlayerService;
import rbf3.data.Player;

@Slf4j
@Controller
@ResponseBody
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

//    http://localhost:8080/players/view?id=1
    @GetMapping("/view")
    public String showPlayer(@RequestParam("id") int id) {
        Player player = playerService.getPlayer(id);
        log.info("Showing player: {}", player);
        return player.toString();
    }

//    http://localhost:8080/players/register?name=aaa&age=15
    @GetMapping("/register")
    public String registerPlayer(@RequestParam("name") String name,
                                 @RequestParam("age") int age) {
        playerService.registerPlayer(name, age);
        log.info("Registered player: {}", name);
        return "ok";
    }
}
