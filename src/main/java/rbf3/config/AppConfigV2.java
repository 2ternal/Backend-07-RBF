package rbf3.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rbf3.controller.PlayerController;
import rbf3.repository.PlayerRepository;
import rbf3.repository.RetiredPlayerRepository;
import rbf3.service.PlayerService;

@Slf4j
//@Configuration
public class AppConfigV2 {

    @Bean(value = "repository")
    public RetiredPlayerRepository retiredPlayerRepository() {
        log.info("retiredPlayerRepository");
        return new RetiredPlayerRepository();
    }

    @Bean(name = "repository")
    public PlayerRepository playerRepository() {
        log.info("playerRepository");
        return new PlayerRepository();
    }

    @Bean
    public PlayerService playerService() {
        return new PlayerService(playerRepository());
    }

    @Bean
    public PlayerController playerController() {
        return new PlayerController(playerService());
    }
}
