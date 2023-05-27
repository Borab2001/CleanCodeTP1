package org.borab;

public class Game implements TennisGame {
    public static final String TRENTE = "Trente";
    public static final String QUINZE = "Quinze";
    public static final String LOVE = "Love";
    public static final String EGALITE = "Égalité";
    public static final String PARTOUT = "-Partout";
    public static final String QUARANTE = "Quarante";
    private Player player1;
    private Player player2;

    public Game(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public String getScore() {
        if (isPlayer1Won(player1.getScore(), player2.getScore())) {
            return "Le player1 a gagné";

        }
        if (isPlayer2Won(player1.getScore(), player2.getScore())) {
            return "Le player2 a gagné";
        }

        if (isAvantagePlayer1()) {
            return "Avantage player1";
        }

        if (isAvantagePlayer2()) {
            return "Avantage player2";
        }

        if (player1.getScore() == player2.getScore() && player1.getScore() >= 3) {
            return EGALITE;
        }

        if (player1.getScore() == player2.getScore()) {
            return translateScore(player1.getScore()) + PARTOUT;
        }

        return translateScore(player1.getScore()) + "-" + translateScore(player2.getScore());
    }

    private String translateScore(int score) {
        return switch (score) {
            case 0 -> LOVE;
            case 1 -> QUINZE;
            case 2 -> TRENTE;
            case 3 -> QUARANTE;
            default -> throw new IllegalArgumentException("Invalid score");
        };
    }

    private boolean isAvantagePlayer1() {
        return player1.getScore() > player2.getScore() && player2.getScore() >= 3;
    }

    private boolean isAvantagePlayer2() {
        return player2.getScore() > player1.getScore() && player1.getScore() >= 3;
    }

    private boolean isPlayer1Won(int player1Points, int player2Points) {
        return player1Points >= 4 && player2Points >= 0 && (player1Points - player2Points) >= 2;
    }

    private boolean isPlayer2Won(int player1Points, int player2Points) {
        return player2Points >= 4 && player1Points >= 0 && (player2Points - player1Points) >= 2;
    }

    @Override
    public void wonPoint(Player player) {
        if (player == player1) {
            player1.scores();
        } else {
            player2.scores();
        }
    }

    @Override
    public Player getPlayer1() {
        return player1;
    }

    @Override
    public Player getPlayer2() {
        return player2;
    }
}
