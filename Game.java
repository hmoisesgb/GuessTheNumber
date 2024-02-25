import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDate;

public class Game {

    //This first 3 variables will keep track of how many times the user beats each level
    private int easyWins;
    private int mediumWins;
    private int hardWins;
    private int freeplayGames;

    // This random object will generate the random numbers to guess
    private Random randomNumber;

    public Game(){
        //The constructor is here to help me initialize the variables and the Random Object
        randomNumber = new Random();
        easyWins = 0;
        mediumWins = 0;
        hardWins = 0;
    }

    public void start(){
        //The scanner is here to get the inputs of the user
        Scanner reader = new Scanner(System.in);
        int menuOption = 0;

        //This while loop contains the menu and the game itself,
        //this loop asks the user to select an option and then executes the
        //desired option
        while (menuOption != 5) {

            System.out.println("Welcome to the guess the number game");
            System.out.println("Please select an option from the menu: ");
            System.out.println("1. Easy Difficulty");
            System.out.println("2. Medium Difficulty");
            System.out.println("3. Hard Difficulty");
            System.out.println("4. Free Play");
            System.out.println("5. Exit");
            menuOption = Integer.parseInt(reader.nextLine());
            

            //Option number 1 is the easy difficulty, this will select a random number between 1-10
            //and gives the user 3 attempts.
            if (menuOption == 1) {
                int answer = randomNumber.nextInt(10)+1;
                int guess = 0;
                int attempts = 1;
                System.out.println("Welcome to the Easy difficulty");
                System.out.println("You have to guess a number from 1-10, and you have 3 attempts. Good Luck!");

                 //This loop works as long as the user is within 3 attempts and then ends.
                while (attempts < 4) {
                    System.out.println("Please input your guess");
                    guess = Integer.parseInt(reader.nextLine());

                    if (guess == answer) {
                        System.out.println("Congratulations! You guessed the number correctly. It took you "+attempts+ " attempt(s) \n");
                        attempts = 4;
                        easyWins++;
                    } else if(guess > answer){
                        System.out.println("The number is lower");
                    }
                    else if(guess < answer){
                        System.out.println("The number is higher");
                    }
                    attempts++;
                }
                if (guess != answer) {
                    System.out.println("Unfortunately you were not able to guess the number in 3 attempts. The correct number was:"+ answer +" Try again!\n");
                }
            } 
            //Option number 2 is the medium difficulty, this will select a random number between 1-25
            //and gives the user 3 attempts.
            else if(menuOption == 2){
                int answer = randomNumber.nextInt(25)+1;
                int guess = 0;
                int attempts = 1;
                System.out.println("Welcome to the Medium difficulty");
                System.out.println("You have to guess a number from 1-25, and you have 3 attempts. Good Luck!");

                //This loop works as long as the user is within 3 attempts and then ends.
                while (attempts < 4) {
                    System.out.println("Please input your guess");
                    guess = Integer.parseInt(reader.nextLine());

                    if (guess == answer) {
                        System.out.println("Congratulations! You guessed the number correctly. It took you "+attempts+ " attempt(s)\n");
                        attempts = 4;
                        mediumWins++;
                    } else if(guess > answer){
                        System.out.println("The number is lower");
                    }
                    else if(guess < answer){
                        System.out.println("The number is higher");
                    }
                    attempts++;
                }
                if (guess != answer) {
                    System.out.println("Unfortunately you were not able to guess the number in 3 attempts. The correct number was:"+ answer +" Try again!\n");
                }
            }

            //Option number 3 is the hard difficulty, this will select a random number between 1-25
            //and gives the user 3 attempts.
            else if(menuOption == 3){
                int answer = randomNumber.nextInt(50)+1;
                int guess = 0;
                int attempts = 1;
                System.out.println("Welcome to the Hard difficulty");
                System.out.println("You have to guess a number from 1-50, and you have 3 attempts. Good Luck!");

                 //This loop works as long as the user is within 3 attempts and then ends.
                while (attempts < 4) {
                    System.out.println("Please input your guess");
                    guess = Integer.parseInt(reader.nextLine());

                    if (guess == answer) {
                        System.out.println("Congratulations! You guessed the number correctly. It took you "+attempts+ " attempt(s)\n");
                        attempts = 4;
                        hardWins++;
                    } else if(guess > answer){
                        System.out.println("The number is lower");
                    }
                    else if(guess < answer){
                        System.out.println("The number is higher");
                    }
                    attempts++;
                }
                if (guess != answer) {
                    System.out.println("Unfortunately you were not able to guess the number in 3 attempts. The correct number was:"+ answer +" Try again!\n");
                }
            }

            //Option number 4 is free play. This option allows the user to select the min and max numbers for the range
            //of the random numbers and then asks the user the number of attempts they want to make to guess the number.
            else if(menuOption == 4){
                System.out.println("Welcome to the Free Play mode");
                System.out.println("In this mode, you can select the range of numbers, and also select the number of attempts");
                System.out.println("This mode won't affect your highscores, but the number of times you play it will be saved");
                System.out.println();

                System.out.println("Please input the minimun number for your range (This cannot be lower than 0)");
                int min = Integer.parseInt(reader.nextLine());

                System.out.println("Please input the maximun number for your range");
                int max = Integer.parseInt(reader.nextLine());

                System.out.println("Please select the number of attempts");
                int attempts = Integer.parseInt(reader.nextLine());
                int numberOfAttempts = 1;

                int answer = randomNumber.nextInt(max-min+1) + min;
                int guess = 0;
                
                //This loop ends until the number of attempts is equal to the attempts specified by the user. It has a +1 as the number of
                //attempts start at 1 instead of 0
                while (numberOfAttempts < attempts + 1) {
                    System.out.println("Please input your guess");
                    guess = Integer.parseInt(reader.nextLine());

                    if (guess == answer) {
                        System.out.println("Congratulations! You guessed the number correctly. It took you "+numberOfAttempts+ " attempt(s)\n");
                        numberOfAttempts = attempts;
                    } else if(guess > answer){
                        System.out.println("The number is lower");
                    }
                    else if(guess < answer){
                        System.out.println("The number is higher");
                    }
                    numberOfAttempts++;
                }
                if (guess != answer) {
                    System.out.println("Unfortunately you were not able to guess the number in 3 attempts. The correct number was:"+ answer +" Try again!\n");
                }
                freeplayGames++;
            }

            //Once the exit option is selected, the program executes the saveScores() method and saves the scores into
            //a scores.txt file.
            else if (menuOption == 5){
                reader.close();
                saveScores();
                System.out.println("Goodbye! Your scores have been saved in the scores.txt file");
            }
            else{
                System.out.println("Please select a valid option");
            }
            
        }
    }

    //This method uses a BufferedWriter and a FileWriter methods to create a file names scores.txt, to save the user scores
    //of the session. If the file already exists it appends the new scores at the bottom. This uses a try catch, to handle a
    //IOException in case the writer fails.
    private void saveScores(){
        try {
            //The localdate object is created to get the date of the current session of the game
            LocalDate date = LocalDate.now();
            BufferedWriter writer = new BufferedWriter(new FileWriter("scores.txt",true));
            writer.write("Date of Session: "+ date);
            writer.newLine();
            writer.write("Easy wins: "+ easyWins);
            writer.newLine();
            writer.write("Medium wins: "+ mediumWins);
            writer.newLine();
            writer.write("Hard wins: "+ hardWins);
            writer.newLine();
            writer.write("Number of Free Play Games: "+ freeplayGames);
            writer.newLine();
            writer.write("----------------------------------------------");
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
    }

}
