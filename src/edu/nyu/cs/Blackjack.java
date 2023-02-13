package edu.nyu.cs;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
/**
 * A variation of the game of Blackjack.  
 * Complete this program according to the instructions in the README.md file as well as within the given comments below.
 */
public class Blackjack {
  /**
   * The main function is automatically called first in a Java program.
   * 
   * @param args An array of any command-line arguments.
   */
  public static void main(String[] args) throws Exception {
    // complete this function according to the instructions
    int playerTotal = 0;
    int currentCard = 0;
    ArrayList<Integer> hand = new ArrayList<Integer>();

    System.out.println("Welcome to the worst ever coded version of Blackjack!");
    currentCard = cardDraw();
    playerTotal += currentCard;
    hand.add(currentCard);

    currentCard = cardDraw();
    playerTotal += currentCard;
    hand.add(currentCard);

    handPrint(hand);

    try (Scanner sc = new Scanner(System.in)) {
      boolean gameContinue = true;
      while(gameContinue){
        System.out.println("Would you like to hit or stand?");
        String input = sc.nextLine();
        if (input.equals("hit")){

          currentCard = cardDraw();
          playerTotal += currentCard;
          hand.add(currentCard);

          handPrint(hand);
        }
        else if (input.equals("stand")||input.equals("pass")||input.equals("stop")){
          gameContinue = false;
          dealer(playerTotal,hand);
        }
        else{
          System.out.println("Not a valid input!");
        }
        if(playerTotal > 21){
          System.out.println("You have bust!");
          System.out.println("Dealer wins!");
          gameContinue = false;
        }
      }


      sc.close();
    }
  } // main




  public static void dealer(int playerTotal, ArrayList<Integer> playerHand) throws Exception{ //this method runs the dealer's side of the game
    int dealerTotal = 0;
    boolean dealerContinue = true;
    ArrayList<Integer> dealerHand = new ArrayList<Integer>();
    int currentCard = 0;

    currentCard = cardDraw();
    dealerTotal += currentCard;
    dealerHand.add(currentCard);

    currentCard = cardDraw();
    dealerTotal += currentCard;
    dealerHand.add(currentCard);


    do{
      if (dealerTotal<17){
        System.out.println("The dealer hits.");

        currentCard = cardDraw();
        dealerTotal += currentCard;
        dealerHand.add(currentCard);

      }
      else if (dealerTotal>21){
        System.out.println("The dealer stands.");

        handPrint(playerHand);
        dealerHandPrint(dealerHand);

        System.out.println("The dealer has bust!");
        System.out.println("You win!");

        dealerContinue = false;
      }
      else if (dealerTotal<=21){
        System.out.println("The dealer stands.");
        if (dealerTotal<playerTotal){
          
          handPrint(playerHand);
          dealerHandPrint(dealerHand);

          System.out.println("You win!");

          dealerContinue = false;
        }
        else if(dealerTotal > playerTotal){

          handPrint(playerHand);
          dealerHandPrint(dealerHand);

          System.out.println("Dealer wins!");

          dealerContinue = false;
        }
        else if (dealerTotal == playerTotal){
          handPrint(playerHand);
          dealerHandPrint(dealerHand);
          System.out.println("Tie!");
          dealerContinue = false;
        }
        else {
          System.out.println("What happened?");
          dealerContinue = false;
        }
      }
      else {
        System.out.println("How did we get here?");
        dealerContinue = false;
      }
    } while (dealerContinue);
  }



  public static int cardDraw() throws Exception{ //this method draws cards
    Random rand = new Random();
    int cardAmount = 0;
      cardAmount += rand.nextInt(10)+2;
return cardAmount;
  }



  public static void handPrint(ArrayList<Integer> hand) throws Exception{// this method shows the hand

    System.out.print("Your cards are: ");
    System.out.print(hand.get(0));
    for (int i = 1; i <hand.size()-1;i++){
      System.out.print(", "+hand.get(i));

    }
    System.out.print(" and ");
    System.out.print(hand.get(hand.size()-1));
    System.out.print("\n");
  }
  public static void dealerHandPrint(ArrayList<Integer> hand) throws Exception{// this method shows the hand

    System.out.print("The dealer's cards are: ");
    System.out.print(hand.get(0));
    for (int i = 1; i <hand.size()-1;i++){
      System.out.print(", "+hand.get(i));

    }
    System.out.print(" and ");
    System.out.print(hand.get(hand.size()-1));
    System.out.print("\n");
  }

}
