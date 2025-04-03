package rbf3.service;

import org.springframework.stereotype.Service;
import rbf3.data.Player;
import rbf3.repository.PlayerRepository;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player getPlayer(int id) {
        return playerRepository.getPlayer(id);
    }

    public void registerPlayer(String name, int age) {
        Player player = new Player(name, age);
        playerRepository.putPlayer(player);
    }
}
