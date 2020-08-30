import java.util.*;
public class Quest4 {
	public static void main (String[] args){ 
        final int MAX = 88, MIN = 11;
        int count=0;
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("This is Hi-Lo guessing game.");
        
        String replay = "Y";
        while (replay.equalsIgnoreCase("Y")) {
            int result = random.nextInt(MAX - MIN) + MIN;
            
            System.out.print("What number from " + MIN + " to " + (MAX-1) + " do you guess (enter 0 to quit)? ");
            while (true) {
                int guess = scan.nextInt();
                if (guess == 0) {
                    break;
                }
                
                count++;
                if (guess == result) {
                    System.out.println("Correct! You made " + count + " guesses.");
                    break;
                }
                
                if (guess < result) {
                    System.out.println("Your guess is lower than result, try again or press 0 to quit.");
                } else {
                    System.out.println("Your guess is higher than result, try again or press 0 to quit.");
                }
            }
            
            System.out.println("\nPlay again (Y/N)?");
            replay = scan.next();
        }
	} 
}
