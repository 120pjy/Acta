import java.util.Scanner;
import java.util.Random;

public class BlackJack {
    public static void main(String[] args) {
        Random randGen = new Random();
        //Variables
        int gameNum;
        int option;
        boolean end = false;
        int point;
        point = 0;
        int NumOfPWin = 0;
        int NumOfDWin = 0;
        gameNum = 1;

        Scanner scnr = new Scanner(System.in);


        //Starting the game
        while (!end) {
            System.out.println("Start game #" + gameNum + "!\n");

            //Variables
            boolean end2 = false;
            int yourCard = randGen.nextInt(13) + 1;

            //Print the card
            System.out.print("Your card is a ");
            if (yourCard == 1) {
                System.out.println("ACE!");
            }
            else if (yourCard >= 2 && yourCard <= 10) {
                System.out.println(yourCard);
            }
            else if (yourCard == 11) {
                System.out.println("JACK!");
            }
            else if (yourCard == 12) {
                System.out.println("QUEEN!");
            }
            else if (yourCard == 13) {
                System.out.println("KING!");
            }
            //Sum
            if (yourCard <= 10) {
                point += yourCard;
            }
            else {
                point += 10;
            }
            //Print the hand
            System.out.println("Your hand is: " + point);
            System.out.println();
            //Options for the player
                while (!end2) {
                    System.out.println("1. Get another card");
                    System.out.println("2. Hold hand");
                    System.out.println("3. Print statistics");
                    System.out.println("4. Exit\n");
                    System.out.print("Choose an option: ");
                    option = scnr.nextInt();
                    System.out.println();
                //Prompt the user for the game
                if (option == 1) {
                    yourCard = randGen.nextInt(13) + 1;
                    System.out.print("Your card is a ");
                    if (yourCard == 1) {
                        System.out.println("ACE!");
                    }
                    else if (yourCard >= 2 && yourCard <= 10) {
                        System.out.println(yourCard);
                    }
                    else if (yourCard == 11) {
                        System.out.println("JACK!");
                    }
                    else if (yourCard == 12) {
                        System.out.println("QUEEN!");
                    }
                    else if (yourCard == 13) {
                        System.out.println("KING!");
                    }
                    //Sum
                    if (yourCard <= 10) {
                        point += yourCard;
                    }
                    else {
                        point += 10;
                    }
                    //Print the hand
                    System.out.println("Your hand is: " + point);
                    System.out.println();
                    //Over 21 will result in lost
                    if (point > 21) {
                        System.out.println("You exceeded 21! You lose.\n");
                        NumOfDWin++;
                        end2 = true;
                    }
                    if (point == 21) {
                        System.out.println("BLACKJACK! You win!\n");
                        NumOfPWin++;
                        end2 = true;
                    }
                }
                else if (option == 2) {
                    int Deal = randGen.nextInt(11) + 16;
                    System.out.println("Dealer's hand: " + Deal);
                    System.out.println("Your hand is: " + point);
                    if (point > Deal || Deal > 21) {
                        System.out.println("You win!\n");
                        NumOfPWin++;
                    }
                    else if (Deal > point) {
                        System.out.println("Dealer wins!\n");
                        NumOfDWin++;
                    }
                    else {
                        System.out.println("It's a tie! No one wins!\n");
                    }
                    end2 = true;
                }
                else if (option == 3) {
                    System.out.println("Number of Player wins: " + NumOfPWin);
                    System.out.println("Number of Dealer wins: " + NumOfDWin);
                    System.out.println("Total # of games played is " + gameNum);
                    double percent=((double)NumOfPWin / gameNum) * 100.0;
                    percent = Math.round(10.0*percent)/10.0;
                    System.out.println("Percentage of Player wins: "+percent+"%");
                }
                else if (option == 4) {
                    end = true;
                }
                else {
                    System.out.println("Invalid input!");
                    System.out.println("Please enter an integer value between 1 and 4.");
                }
                }
                gameNum++;
                point = 0;


        }
    }
}