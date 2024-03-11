/**
 * File: Blackjack.java
 * Author: Junnan Shimizu
 * Date: 09/18/2021
 */

import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> deck = new ArrayList<Card>();

    //constructor calls the build method
    public Deck(){
        build();
    }

    //the build method creates a deck of 52 cards, 4 each of cards with values 2-9 and 11
    //and 16 cards with the value 10
    public void build(){
        for(int i = 0; i < 4; i++){
            for(int value = 2; value <= 11; value++){
                deck.add(new Card(value));
            }
        }

        for(int i = 0; i < 12; i++){
            deck.add(new Card(10));
        }
    }

    //returns the size of the deck
    public int size(){
        return deck.size();
    }

    //returns the card at index zero
    public Card deal(){
        Card temp = deck.get(0);
        deck.remove(0);
        return temp;
    }

    //returns the card at a specific index
    public Card pick(int i){
        Card temp = deck.get(i);
        deck.remove(i);
        return temp;
    }

    //shuffles the ArrayList of cards
    public void shuffle(){
        for(int i = 0; i < deck.size(); i++){
            int random = (int)(deck.size() * Math.random());
            Card temp = deck.get(i);
            Card temp2 = deck.get(random);
            deck.set(random, temp);
            deck.set(i, temp2);
        }
    }

    //returns the values of the cards in the deck in order.
    public String toString(){
        String result = "Card Values in Order: ";

        for(int i = 0; i < deck.size() - 1; i++){
            result += deck.get(i) + ", ";
        }

        result += deck.get(deck.size() - 1);

        return result;
    }

    //main method used to test methods within the class
    public static void main(String[] args){
        Deck deck1 = new Deck();
        Hand hand1 = new Hand();
        Hand hand2 = new Hand();


        System.out.println(deck1.size());
        deck1.shuffle();
        System.out.println(deck1.toString());
        hand1.add(deck1.deal());
        hand2.add(deck1.deal());
        hand1.add(deck1.pick(10));
        System.out.println(hand1.toString());
        System.out.println(hand2.toString());
    }
}
