import java.util.Random;
import java.util.Scanner;

public class BlackJack {
    int playerCard = 0;
    int compCard = 0;

    public static void main(String[] args) {
        new BlackJack().run();

    }

    private void run() {
        welcomePlayer();
        GiveStartingHand();
        playerChoices();


        while (playerCard < 21) {
            int nextCard = playerChoices();
            if (nextCard == 0) {
                break;
            }
            playerCard += nextCard;
            System.out.println("Your hand is now: " + playerCard);
        }
        while (compCard < 17) {
            int nextCard = generateNumber();
            compCard += nextCard;
            System.out.println("Computers hand is now: " + compCard);

        }
        determineWhoWon();
    }

        public int generateNumber () {
            Random random = new Random();
            int generateNumber = random.nextInt(13) + 1;
            if (generateNumber > 10) {
                generateNumber = 10;
            }
            return generateNumber;
        }

        public void welcomePlayer () {
            System.out.println("Welcome to blackjack!");
            System.out.println("You will be getting a starting card.");
            System.out.println("You can either hit, to get a new card, or stand to stay where you are ");
        }

        public void GiveStartingHand () {

            System.out.println("Your first hand is: " + (playerCard = generateNumber()));
            System.out.println("The computers starting hand is: " + (compCard = generateNumber()));


        }

        public int playerChoices () {
            Scanner in = new Scanner(System.in);


            String choice = "";

            while (true) {


                System.out.println("Do you wish to hit or stand?");
                choice = in.nextLine();

                if (choice.equalsIgnoreCase("hit")) {
                    return generateNumber();
                } else if (choice.equalsIgnoreCase("stand")) {
                    return 0;

                } else {
                    System.out.println("Oops, you made a typo:D type 'hit or 'stand ");
                }


            }


        }  public void determineWhoWon () {
        System.out.println("Your hand is: " + playerCard);
        System.out.println("The computers hand is: " + compCard);
        if (playerCard ==21) {
            System.out.println("You got blackjack! You won!");
        }
            if (playerCard>21) {
                System.out.println("You bust! try again!");
            }
            if (compCard>playerCard && compCard<21) {
                System.out.println("You have lost to the computer!");
            }
            if (playerCard> compCard && playerCard<21) {
                System.out.println("You've won over the computer!");
            } if (playerCard==compCard) {
            System.out.println("Its a tie!");
        }

        }
    }









