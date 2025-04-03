package rbf3.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rbf3.controller.PlayerController;
import rbf3.repository.PlayerRepository;
import rbf3.service.PlayerService;

@Slf4j
@Configuration
public class AppConfigV1 {

    @Bean
    public PlayerRepository playerRepository() {
        log.info("playerRepository");
        return new PlayerRepository();
    }

    @Bean
    public PlayerService playerService() {
        log.info("playerService");
        return new PlayerService(playerRepository());
    }

    @Bean
    public PlayerController playerController() {
        log.info("playerController");
        return new PlayerController(playerService());
    }
}
