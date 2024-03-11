/**
 * File: Blackjack.java
 * Author: Junnan Shimizu
 * Date: 09/18/2021
 */

public class Blackjack {
        private Deck deck;
        private Hand playerHand;
        private Hand dealerHand;
        private int numBelow;

        //initializes the fields of Blackjack
        public Blackjack(int reshuffleCutoff){
            numBelow = reshuffleCutoff;
            deck = new Deck();
            deck.shuffle();
            playerHand = new Hand();
            dealerHand = new Hand();
        }

        //resets the player's hand and the dealer's hand, as well as create a new deck and shuffles that deck
        public void reset(){
            playerHand.reset();
            dealerHand.reset();

            if(deck.size() < numBelow){
                deck = new Deck();
                deck.shuffle();
            }
        }

        //adds a 2 cards to the dealer's and player's hand
        public void deal(){
            playerHand.add(deck.deal());
            dealerHand.add(deck.deal());
            playerHand.add(deck.deal());
            dealerHand.add(deck.deal());
        }

        //adds cards to the player's hand until the value is greater than or equal to 16
        //tests if the total value of the player's hand exceeds 21, returns true if it exceeds 21 and false otherwise.
        public boolean playerTurn(){
            while(playerHand.getTotalValue() <= 16) {
                playerHand.add(deck.deal());
            }

            if(playerHand.getTotalValue() > 21)
                return false;
            else
                return true;
        }

    //adds cards to the dealer's hand until the value is greater than or equal to 17
    //tests if the total value of the player's hand exceeds 21, returns true if it exceeds 21 and false otherwise.
        public boolean dealerTurn(){
            while(dealerHand.getTotalValue() <= 17){
                dealerHand.add(deck.deal());
            }

            if(dealerHand.getTotalValue() > 21)
                return false;
            else
                return true;
        }

        //sets the reshuffleCutoff value to a custom number
        public void setReshuffleCutoff(int cutoff){
            numBelow = cutoff;
        }

        //returns the reShuffleCutoff variable
        public int getReshuffleCutoff(){
            return numBelow;
        }

        //returns the values in PLayer's and Dealer's hand
        public String toString(){
            String result = "Current Game: ";
            result += "Player's " + playerHand.toString();
            result += ", Dealer's "+ dealerHand.toString();

            return result;
        }

        //runs one game of Blackjack and prints results if verbose equals true;
        //otherwise, returns -1 if the dealer wins, 1 if the player wins, 0 if it's a tie
        public int game(boolean verbose) {
            reset();
            this.deal();
            String playerInitial = "Player's Initial " + playerHand.toString();
            String dealerInitial = "Dealer's Initial " + dealerHand.toString();
            boolean playerResult = this.playerTurn();
            boolean dealerResult = this.dealerTurn();

            if(verbose){
                if (playerResult == false) {
                    System.out.println("The Winner: Dealer");
                    System.out.println(playerInitial);
                    System.out.println(dealerInitial);
                    System.out.println("Player's Final " + playerHand.toString());
                    System.out.println("Dealer's Final " + dealerHand.toString());

                }
                else if (dealerResult == true) {
                    if (playerHand.getTotalValue() == dealerHand.getTotalValue()){
                        System.out.println("The Winner is: Neither (Push)");
                        System.out.println(playerInitial);
                        System.out.println(dealerInitial);
                        System.out.println("Player's Final " + playerHand.toString());
                        System.out.println("Dealer's Final " + dealerHand.toString());
                    }

                    if ((21 - playerHand.getTotalValue()) < (21 - dealerHand.getTotalValue())) {
                        System.out.println("The Winner: Dealer");
                        System.out.println(playerInitial);
                        System.out.println(dealerInitial);
                        System.out.println("Player's Final " + playerHand.toString());
                        System.out.println("Dealer's Final " + dealerHand.toString());

                    } else {
                        System.out.println("The Winner: Player");
                        System.out.println(playerInitial);
                        System.out.println(dealerInitial);
                        System.out.println("Player's Final " + playerHand.toString());
                        System.out.println("Dealer's Final " + dealerHand.toString());
                    }
                } else {
                    System.out.println("The Winner: Player");
                    System.out.println(playerInitial);
                    System.out.println(dealerInitial);
                    System.out.println("Player's Final " + playerHand.toString());
                    System.out.println("Dealer's Final " + dealerHand.toString());

                }
            }

            if (playerResult == false) {
                return -1;
            }
            else if (dealerResult == true) {
                if (playerHand.getTotalValue() == dealerHand.getTotalValue()) {
                    return 0;
                }
                else if ((21 - playerHand.getTotalValue()) < (21 - dealerHand.getTotalValue())) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                return 1;
            }
        }

        //returns playerHand object, for extension
        public Hand getPlayerHand(){
            return playerHand;
        }

        //returns dealerHand object, for extension
        public Hand getDealerHand(){
            return dealerHand;
        }

        //adds top card of the deck to player's hand, for extension
        public void playerDraw(){
            playerHand.add(deck.deal());
        }

        //adds top card of the deck to the dealer's hand, for extension
        public void dealerDraw(){
            dealerHand.add(deck.deal());
        }

        // Main method used to test the methods within the class
        public static void main(String[] args){
            Blackjack game1 = new Blackjack(26);
//            game1.deal();
//            game1.playerTurn();
//            game1.dealerTurn();
//            System.out.println(game1.playerHand.toString());
//            System.out.println(game1.dealerHand.toString());

            game1.game(true);
            System.out.println();
            game1.game(true);
            System.out.println();
            game1.game(true);
        }
}
