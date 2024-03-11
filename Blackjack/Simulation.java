/**
 * File: Blackjack.java
 * Author: Junnan Shimizu
 * Date: 09/18/2021
 */

public class Simulation {

    //runs the game 1000 times and records and prints the results.
    public static void main(String[] args){
        Blackjack game = new Blackjack(26);
        int playerWins = 0;
        int dealerWins = 0;
        int ties = 0;
        int result;

        //Ígame.game(true);
        for(int i = 0; i < 1000; i++){
            result = game.game(false);
            if(result == 0){
                ties++;
            }
            else if(result == 1){
                playerWins++;
            }
            else{
                dealerWins++;
            }
        }

        System.out.println("Player Wins: " + playerWins + " (" +(double)(playerWins)/10 + "%)");
        System.out.println("Dealer Wins: " + dealerWins + " (" + (double)(dealerWins)/10 + "%)");
        System.out.println("Pushes: " + ties + " (" + + (double)(ties)/10 + "%)");
    }
}
