import java.util.*;

public class Menu {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Scanner justScan = new Scanner(System.in);
		
		while(true) {
			System.out.println("Main Menu");
			System.out.println("1. Task 1");
			System.out.println("2. Task 2");
			System.out.println("3. Task 3");
			System.out.println("0. Exit");
			System.out.print("Your choice -> ");
			int option = scan.nextInt();

			switch(option) {
				case 1:
					System.out.println("Processing option 1 ... Please wait");
					justScan.nextLine();
					System.out.println("option 1 was chose\n");
					break;
				case 2:
					System.out.println("Processing option 2 ... Please wait");
					justScan.nextLine();
					System.out.println("option 2 was chose\n");
					break;
				case 3:
					System.out.println("Processing option 3 ... Please wait");
					justScan.nextLine();
					System.out.println("option 3 was chose\n");
					break;
				case 0:
					break;
			}
			if (option == 0) {
				break;
			}
		}

	}
}