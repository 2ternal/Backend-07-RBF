package rbf3.repository;

import org.springframework.stereotype.Repository;
import rbf3.data.Player;

import java.util.HashMap;
import java.util.Map;

@Repository
public class RetiredPlayerRepository implements RepositoryInterface {

    private int sequence = 0;
    private Map<Integer, Player> players;

    public RetiredPlayerRepository() {
        players = new HashMap<>();
    }

    public Player getPlayer(int id) {
        return players.get(id);
    }

    public void putPlayer(Player player) {
        sequence++;
        player.setId(sequence);
        players.put(sequence, player);
    }
}
