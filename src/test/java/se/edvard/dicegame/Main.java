package se.edvard.dicegame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Player p1;
        Player p2;
        String input = "";

        while(!input.equals("avsluta")) {

            System.out.println("Skriv in namnet på spelare 1");
            p1 = new Player(sc.nextLine());
            System.out.println("Skriv in namnet på spelare 2");
            p2 = new Player(sc.nextLine());
            input = "";

            while (!input.equals("avsluta") && !input.equals("starta om")) {
                System.out.println("Skriv 'spela' för att köra en match, 'starta om' för att starta om programmet eller 'avsluta' för att avsluta programmet'");
                input = sc.nextLine();
                if(!input.equals("avsluta") && !input.equals("starta om"))
                {
                    if(input.equals("spela"))
                    {
                        try {
                            playGame(p1, p2);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    else
                    {
                        System.out.println("Okänt kommando \n");
                    }
                }
            }
        }
    }
    public static void playGame(Player p1, Player p2) throws InterruptedException {
        Player winner;
        Player loser;
        p1.throwDice(2);
        p2.throwDice(2);
        winner = p1.getScore() > p2.getScore() ? p1 : p2;
        loser = p1.getScore() > p2.getScore() ? p2 : p1;

        System.out.println("\n\n\n");
        System.out.println(p1.getName() + " kastade sina tärningar och fick " + p1.getScore() + " poäng!");
        for (int i = 0; i < 3; i++)
        {
            Thread.sleep(1000);
            System.out.println("...");
        }
        System.out.println(p2.getName() + " kastade sina tärningar och fick " + p2.getScore() + " poäng!");
        for (int i = 0; i < 2; i++)
        {
            Thread.sleep(1000);
            System.out.println("...");
        }
        if(p1.getScore() == p2.getScore())
        {
            System.out.println("Det blev lika!");
        }
        else
        {
            System.out.println(winner.getName() + " med " + winner.getScore() + " poäng vann över " + loser.getName() + " med " + loser.getScore() + " poäng!");
        }
    }
}
