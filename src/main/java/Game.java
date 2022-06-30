import java.util.ArrayList;
import java.util.Collection;

public class Game {
    private Collection<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public Collection<Player> getAll() {
        return players;
    }

    public int getStr(String player) {
        for (Player players : players) {
            if (players.name == player) {
                return players.strength;
            }
        }
        throw new NotRegisteredException("Player " + (player) + " not found!");
    }

    public int round(String playerName1, String playerName2) {
        if (getStr(playerName1) > getStr(playerName2)) {
            return 1;
        }
        if (getStr(playerName1) == getStr(playerName2)) {
            return 0;
        }
        return 2;
    }
}