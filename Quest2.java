import java.util.Scanner;
public class Quest2 {
    public static void main(String[] args)
    {
        int quarters, dimes, nickels, pennies, totalCoins, dollars, cents;
        Scanner scan = new Scanner (System.in);
        
        System.out.print("Input the number of quarters: ");
        quarters = scan.nextInt();
        
        System.out.print("Input the number of dimes: ");
        dimes = scan.nextInt();
        
        System.out.print("Input the number of nickels: ");
        nickels= scan.nextInt();
        
        System.out.print("Input the number of pennies: ");
        pennies = scan.nextInt();
        
        totalCoins = quarters * 25 + dimes * 10 + nickels * 5 + pennies;
        dollars = totalCoins/100;
        cents = totalCoins %100;
        
        System.out.println("Total: " + dollars + " dollars and " + cents + " cents ");
    }
}
