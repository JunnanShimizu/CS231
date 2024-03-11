/**
 * File: Blackjack.java
 * Author: Junnan Shimizu
 * Date: 09/18/2021
 */

public class Card {
    private int value;

    //This constructor gives the card object the value of input v.
    public Card(int v){
        this.value = v;
    }

    //this method returns the value of the card
    public int getValue(){
        return this.value;
    }

    //This method returns the contents of the card in a String.
    public String toString(){
        return "" + this.getValue();
    }

    //This main method was used to test the class
    public static void main(String[] args){
        Card card1 = new Card(10);
        System.out.println(card1.toString());

    }
}
