package org.borab;

public class Player {
    public String name;
    private int score;

    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void scores(){
        score++;
    }

    public int getScore() {
        return score;
    }

    public String getScoreName() {
        return name + ": " + score;
    }

    public boolean asWonOver(Player opponent){
        return this.score >= 4 && opponent.getScore() >= 0 && (this.score - opponent.getScore()) >= 2;
    }

    /*public boolean isEqualityWith(Player opponent){

    }*/

    public boolean hasAdvantageAgainst(Player opponent){
        return this.score > opponent.getScore() && opponent.getScore() >= 3;
    }
}
