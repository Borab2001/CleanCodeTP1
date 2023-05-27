package org.borab;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GameTest {
    private int player1Score;
    private int player2Score;
    private String expectedScore;

    public GameTest(int player1Score, int player2Score, String expectedScore) {
        this.player1Score = player1Score;
        this.player2Score = player2Score;
        this.expectedScore = expectedScore;

    }

    @Parameters
    public static Collection<Object[]> getAllScores() {
        return Arrays.asList(new Object[][]{
                {0, 0, "Love-Partout"},
                {1, 1, "Quinze-Partout"},
                {2, 2, "Trente-Partout"},
                {3, 3, "Égalité"},
                {4, 4, "Égalité"},

                {1, 0, "Quinze-Love"},
                {0, 1, "Love-Quinze"},
                {2, 0, "Trente-Love"},
                {0, 2, "Love-Trente"},
                {3, 0, "Quarante-Love"},
                {0, 3, "Love-Quarante"},
                {4, 0, "Le player1 a gagné"},
                {0, 4, "Le player2 a gagné"},

                {2, 1, "Trente-Quinze"},
                {1, 2, "Quinze-Trente"},
                {3, 1, "Quarante-Quinze"},
                {1, 3, "Quinze-Quarante"},
                {4, 1, "Le player1 a gagné"},
                {1, 4, "Le player2 a gagné"},

                {3, 2, "Quarante-Trente"},
                {2, 3, "Trente-Quarante"},
                {4, 2, "Le player1 a gagné"},
                {2, 4, "Le player2 a gagné"},

                {4, 3, "Avantage player1"},
                {3, 4, "Avantage player2"},
                {5, 4, "Avantage player1"},
                {4, 5, "Avantage player2"},
                {15, 14, "Avantage player1"},
                {14, 15, "Avantage player2"},

                {6, 4, "Le player1 a gagné"},
                {4, 6, "Le player2 a gagné"},
                {16, 14, "Le player1 a gagné"},
                {14, 16, "Le player2 a gagné"},
        });
    }

    public void checkScores(TennisGame game) {
        int theHighestScore = Math.max(this.player1Score, this.player2Score);
        for (int i = 0; i < theHighestScore; i++) {
            if (i < this.player1Score) {
                game.wonPoint(game.getPlayer1());
            }
            if (i < this.player2Score) {
                game.wonPoint(game.getPlayer2());
            }
        }
        assertEquals(this.expectedScore, game.getScore());
    }

    @Test
    public void checkScoresTennisGame() {
        Game game = new Game("player1", "player2");
        checkScores(game);
    }
}
