package calculator;

import java.util.Arrays;

/**
 * This class will hold the methods to create a deck of cards for playing
 * poker (Texas Hold em)
 * 
 * @Author Adam Cichoski, Bennet Scott, Alex Bokaer, Natalie Hildreth, Joseph
 *         Holly
 */
public class Cards {
    private char[] cardType = { 'K', 'Q', 'J', '9', '8', '7', '6', '5', '4', '3', '2', 'A' };
    private String ten = "10";
    private char[] suit = { 'H', 'D', 'S', 'C' };
    private String yourHand;
    private int totalCards = 52;
    private boolean flop;

    /**
     * This is the Cards constructor
     */
    public Cards(String yourHand, boolean flop) {
        this.flop = flop;
        setTotalCards(flop);
        this.yourHand = setCards(yourHand);
    }

    /**
     * This method sets your current hand
     * 
     * @param newHand
     * @return
     */
    public String setCards(String newHand) {
        boolean validInput = false;
        if (newHand.length() > 3 || newHand.length() == 0) {
            return "Invalid Input";
        }
        if (newHand.length() == 3) {
            if (!newHand.substring(0, 1).equals(ten)) {
                return "Invalid Input";
            }
            for (int i = 0; i < suit.length; i++) {
                if (newHand.indexOf(newHand.length() - 1) == (suit[i])) {
                    validInput = true;
                }
            }

        } else {
            for (int i = 0; i < cardType.length; i++) {
                if (i == 3) {
                    continue;
                }
                if (newHand.charAt(0) == (cardType[i])) {
                    validInput = true;
                }
            }
        }

        return (validInput) ? newHand : "Invalid Input";
    }
    
    private String setTotalCards(boolean flop){
        totalCards -= (flop)? 3:0;
        return(totalCards <5)? "Too Many Players!!!":"";
    }
    /**
     * This method gets the players current hand
     * @return
     */
    public String getHand(){
        return this.yourHand;
    }
    /**
     * This method gets the total number of remaining cards in the deck
     */
    public int getTotalCards(){
        return this.totalCards;
    }
    /**
     * Sets the flop
     * @param flop
     */
    public void setFlop(boolean flop){
        this.flop = flop;
    }
    /**
     * Gets the flop
     * @return
     */
    public boolean getFlop(){
        return this.flop;
    }

}
