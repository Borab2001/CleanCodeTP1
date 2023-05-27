package org.borab;

public interface TennisGame {

    void wonPoint(Player player);
    String getScore();

    Player getPlayer1();
    Player getPlayer2();
}
