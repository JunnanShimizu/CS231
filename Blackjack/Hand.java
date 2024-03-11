/**
 * File: Blackjack.java
 * Author: Junnan Shimizu
 * Date: 09/18/2021
 */

import java.util.ArrayList;

public class Hand {
    ArrayList<Card> hand;

    //Initializes the hand ArrayList
    public Hand(){
        hand = new ArrayList<Card>();
    }

    //clears the hand ArrayList
    public void reset(){
        hand.clear();
    }

    //adds the card input to the hand
    public void add(Card card){
        hand.add(card);
    }

    //returns the size of the hand
    public int size(){
        return hand.size();
    }

    //returns the card at the index of input i
    public Card getCard(int i){
        return hand.get(i);
    }

    //returns the sum of the cards in the hand
    public int getTotalValue(){
        int total = 0;
        for(int i = 0; i < this.size(); i++){
            total += hand.get(i).getValue();
        }
        return total;
    }

    //returns the cards in the hand as a String
    public String toString(){
        String cards = "";
        for(int i = 0; i < this.size(); i++){
            cards += " " + hand.get(i);
        }
        return "Hand: " + cards;
    }

    // main method used to test methods in the class
    public static void main(String[] args){
        Card card1 = new Card(10);
        Card card2 = new Card(7);
        Hand hand1 = new Hand();
        hand1.add(card1);
        hand1.add(card2);

        System.out.println("Size: " + hand1.size());
        System.out.println(hand1.getCard(1));
        System.out.println("Total Value: " + hand1.getTotalValue());
        System.out.println(hand1.toString());

        hand1.reset();
        System.out.println(hand1.toString());
    }
}
