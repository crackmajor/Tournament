import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;

public class GameTest {
    Game games = new Game();
    Player player1 = new Player(234, "Dandy", 79);
    Player player2 = new Player(235, "proxy", 66);
    Player player3 = new Player(236, "PARANOYA", 96);
    Player player4 = new Player(237, "Ursa", 80);
    Player player5 = new Player(238, "Villaribo", 78);
    Player player6 = new Player(239, "Villabago", 46);
    Player player7 = new Player(240, "HAGUBATOP2000", 49);
    Player player8 = new Player(241, "Sanya1", 46);

    @Test
    void addTest() {
        games.register(player1);
        games.register(player2);
        games.register(player3);
        games.register(player4);
        games.register(player5);
        games.register(player6);
        games.register(player7);
        games.register(player8);

        Collection<Player> actual = games.getAll();
        Collection<Player> expected = Arrays.asList(player1, player2, player3, player4, player5, player6, player7, player8);

        assertEquals(actual, expected);
    }

    @Test
    void roundTest() {
        games.register(player1);
        games.register(player2);
        games.register(player3);
        games.register(player4);
        games.register(player5);
        games.register(player6);
        games.register(player7);
        games.register(player8);

        int actual = games.round("Villabago", "Sanya1");
        int expected = 0;

        assertEquals(actual, expected);
    }

    @Test
    void roundWinFirstPlayerTest() {
        games.register(player1);
        games.register(player2);
        games.register(player3);
        games.register(player4);
        games.register(player5);
        int actual = games.round("PARANOYA", "Dandy");
        int expected = 1;
        assertEquals(actual, expected);
    }

    @Test
    void roundWinSecondPlayerTest() {
        games.register(player1);
        games.register(player2);
        games.register(player3);
        games.register(player4);
        games.register(player5);
        int actual = games.round("proxy", "PARANOYA");
        int expected = 2;
        assertEquals(actual, expected);
    }

    @Test
    void roundWithUnRegisteredPlayer() {
        games.register(player6);
        games.register(player7);
        games.register(player8);

        assertThrows(NotRegisteredException.class, () -> {
            games.round("Sanya1", "NotRegistered");
        });
    }
}