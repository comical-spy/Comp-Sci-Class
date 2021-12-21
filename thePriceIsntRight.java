import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class thePriceIsntRight {
    public static void main(String[] args) {
        // Setting up 

        String userName = "";
        // Util
        Scanner userInput = new Scanner(System.in);
        Random random = new Random();
        // Guesses
        int comOne = 0, comTwo = 0, comThree = 0;
        int usersGuess = 0;
        int overCount = 0;
        int high = 0, low = 0;
        // Winners
        ArrayList<Integer> winnerList = new ArrayList<Integer>();
        int winner = 0;
        // Item related
        int itemCost = 0;

        // Welcome Message
        System.out.println("Hello! and Welcome to Your Price Isn't Right! What should we call you?");
        userName = userInput.next();
        System.out.println("Welcome " + userName + "! \n\nYou and Three other players will compete to guess the price of a specified object. If your guess is over the actaul price, That sucks and you lose! Don't be Wrong and Good Luck!\n");
        
        // The Game begins
        System.out.println("\nALRIGHT CONTESTANTS. Today your item is... An RTX 3070! A Graphics card released by Nvidia that was supposed to have an MSRP of $500 but we'll tell you right now that is not the correct answer! This card is roughly the 13th best Graphics card \"Commercially Available.\"\n" + userName + "! You're Up first!");
        itemCost = 1600;

        // User guesses
        System.out.println("okay " + userName + ", what is your bid???");
        do {
            System.out.println("Bid: ");
            usersGuess = userInput.nextInt();
            if (usersGuess < 1) {
                System.out.println("Hey! Your guess can't be 0 or lower, give me another number.");
            }
        } while (usersGuess < 1);

        // Computer 1 & 2 guesses
        comOne = random.nextInt(2001) +1000; //2001 so the random can be 0-2k
        comTwo = random.nextInt(2000) +1;
        // Computer three guess
        if ((comOne-500) > (usersGuess+1)) {
            high = comOne - 500;
            low = usersGuess +1;
        } else {
            high = usersGuess +1;
            low = comOne - 500;
        }
        // ^ This determines whether the userGuess is lower or higher so comThree can guess within the correct range
        comThree = random.nextInt(high-low) + low;   
        
        //Print out Guesses
        System.out.println("Alright, Here is Everyone's guesses...");
        System.out.println(userName + ": " + usersGuess);
        System.out.println("Computer 1: " + comOne);
        System.out.println("Computer 2: " + comTwo);
        System.out.println("Computer 3: " + comThree);

        // Retail price
        System.out.println("The Price of your item was " + itemCost);
        
        // Results time
        System.out.println("\nThe Differences are: ");
        comOne = 3000; comTwo = 3000; comThree = 3000; usersGuess = 3000;
        // User
        if (usersGuess > itemCost) {
            System.out.println(userName + ": OVER");
            overCount++;
        } else {
            System.out.println(userName + ": " + (itemCost - usersGuess));
            winnerList.add(usersGuess);
        }
        
        // Computer 1
        if (comOne > itemCost) {
            System.out.println("Computer 1: OVER");
            overCount++;
        } else {
            System.out.println("Computer 1: " + (itemCost - comOne)); 
            winnerList.add(comOne);
            
        }

        // Computer 2
        if (comTwo > itemCost) {
            System.out.println("Computer 2: OVER");
            overCount++;
        } else {
            System.out.println("Computer 2: " + (itemCost - comTwo));
            winnerList.add(comTwo);
        }

        //Computer 3
        if (comThree > itemCost) {
            System.out.println("Computer 3: OVER");
            overCount++;
        } else {
             System.out.println("Computer 3: " + (itemCost - comThree));
             winnerList.add(comThree);
        }

        // Determining the winner
        if (overCount < 4) {
            Collections.sort(winnerList);
        winner = winnerList.get(winnerList.size()-1);
        }
        
        

        // Ugly if-else madness to announce winner
        if (overCount == 4) {
            System.out.println("WOW you ALL suck, NOBODY WINS!!!");
        } else if (usersGuess == winner) {
            System.out.println("CONGRATS, " + userName + " is the winner!!!");
        } else if (comOne == winner) {
            System.out.println("CONGRATS, Computer 1 is the winner!!!");
        } else if (comTwo == winner) {
            System.out.println("CONGRATS, Computer 2 is the winner!!!");
        } else if (comThree == winner) {
            System.out.println("CONGRATS, Computer 3 is the winner!!!");
        }
        
        // Cleaning up
        userInput.close();
    }
}
