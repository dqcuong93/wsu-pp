import java.util.*;
class Card {
    private int cardValue;
    Random rand = new Random();
    
    public Card() {
        cardValue = rand.nextInt(52) + 1;
    }
    
    public int getCardValue() {
        return cardValue;
    }
    
    public void setCardValue(int val) {
        cardValue = val;
    }
    
    public void randomValue() {
        cardValue = rand.nextInt(52) + 1;
    }
}

public class PairOfCards {
    public static int sum(int val1, int val2) {
        return val1 + val2;
    }
    
    public static void main(String[] args) {
        Card card_1 = new Card();
        Card card_2 = new Card();
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Card 1 random value: " + card_1.getCardValue());
        System.out.println("Card 2 random value: " + card_2.getCardValue());
        System.out.println("Sum of 2 cards: " + sum(card_1.getCardValue(), card_2.getCardValue()));
        
        System.out.print("Set the value of card 1: ");
        card_1.setCardValue(scan.nextInt());
        System.out.print("Set the value of card 2: ");
        card_2.setCardValue(scan.nextInt());
        System.out.println("Card 1 value after set: " + card_1.getCardValue());
        System.out.println("Card 2 value after set: " + card_2.getCardValue());
        System.out.println("Sum of 2 cards: " + sum(card_1.getCardValue(), card_2.getCardValue()));
        
        card_1.randomValue();
        System.out.println("Card 1 value after random: " + card_1.getCardValue());
        card_2.randomValue();
        System.out.println("Card 2 value after random: " + card_2.getCardValue());
        System.out.println("Sum of 2 cards: " + sum(card_1.getCardValue(), card_2.getCardValue()));
    }
}
