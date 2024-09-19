package se.edvard.dicegame;

import java.util.Random;

public class Player {
    String name;
    int score;
    Random rand;

    public Player(String name)
    {
        this.name = name;
        rand = new Random();
    }

    public void throwDice(int amountOfDice)
    {
        score = 0;
        for (int i = 0; i < amountOfDice; i++) {
            score += rand.nextInt(6) + 1;
        }
    }

    public String getName()
    {
        return name;
    }

    public int getScore()
    {
        return score;
    }
}
