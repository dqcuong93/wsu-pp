import java.util.*;
import java.io.*;

public class ProductStockSystem {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String productName, option, outputName = "ProductData.txt", inputName = "ProductData.txt";
		int productQuantity, flag = 0;	
		double productPrice;

		//Array initialize
		ArrayList<Product> items = new ArrayList<Product>();

		//Product object
		Product product;

		System.out.println("\n\n\nWELCOME TO PRODUCT STOCKING SYSTEM PROGRAM\n\n\n");
		System.out.println("Press any key to continue. To quit program, press 'quit'");
		
		option = scan.nextLine();

		//Read data before main menu starts
		try {
			Scanner fileScan = new Scanner(new File(inputName));
			System.out.println("Latest product list:");
			if (fileScan.hasNext()) {
				int count = 1;
				while (fileScan.hasNext()) {
					//Read data and stored into array
					productName = fileScan.next();
					productQuantity = fileScan.nextInt();
					productPrice = fileScan.nextDouble();

					//Create new Product object
					product = new Product(productName, productQuantity, productPrice);
					
					//Add object to array
					items.add(product);

					System.out.print(count + ".\t" + product);
					count++;
				}
				System.out.println("\nData loaded\n");
			}
			else {
				System.out.println("There is no data yet");
			}
		} catch (FileNotFoundException e) {
			System.out.println ("The file " + inputName + " was not found.");
		} catch (InputMismatchException e) {
			System.out.println("Format error in input file: " + e);
		}

		//Main menu
		while(!option.equalsIgnoreCase("quit")) {

			String continueFunction = "Y";

			//List of functions
			System.out.println("\nChoose one of those functions or type 'quit' to quit: ");
			System.out.println("0. Show current product(s)");
			System.out.println("1. Add product");
			System.out.println("2. Modify product");
			System.out.println("3. Delete product");
			System.out.println("4. Search product");
			System.out.println("5. Sort product");
			System.out.print("\nYour choice: ");
			option = scan.nextLine();
			System.out.println();

			try{
				if (System.getProperty("os.name").contains("Windows"))
					new ProcessBuilder("cmd", "/c","cls").inheritIO().start().waitFor();
			else 
				Runtime.getRuntime().exec("clear");
				}
			catch (IOException|InterruptedException ex){}

			switch(option) {
				case "0":
					int count = 1;
					for(int i = 0; i < items.size(); i++) {
						System.out.print(count + ".\t" + items.get(i));
						count++;
					}
					break;
				case "1": 
					while(!continueFunction.equalsIgnoreCase("N")){
						System.out.print("Enter item name: ");
						productName = scan.nextLine();

						System.out.print("Enter item quantity: ");
						productQuantity = scan.nextInt();

						System.out.print("Enter item price: ");
						productPrice = scan.nextDouble();
						scan.nextLine();

						//Create new product
						product = new Product(productName, productQuantity, productPrice);

						//Add product into array
						items.add(product);
						System.out.println("\nProduct added!\n");

						System.out.print("Add another product? (Y/N) ");
						continueFunction = scan.nextLine();
					}
					break;
				case "2":
					while(!continueFunction.equalsIgnoreCase("N")) {
						System.out.println("\nChoose product number you want to modify: ");
						int number = scan.nextInt() - 1;
						scan.nextLine();

						System.out.println("Type a name: ");
						String name = scan.nextLine();
						items.get(number).setName(name);

						System.out.println("Type a quantity: ");
						int quantity = scan.nextInt();
						items.get(number).setQuantity(quantity);

						System.out.println("Type a price: ");
						double price = scan.nextDouble();
						scan.nextLine();
						items.get(number).setPrice(price);

						System.out.println("Your product has been modified successfully!\n");

						System.out.println("Do you want to modify another product? (Y/N) ");
						continueFunction = scan.nextLine();
					}
					break;
				case "3":
					while(!continueFunction.equalsIgnoreCase("N")) {
						try {
							System.out.println("\nEnter a number of product you want to remove: ");
							int removeNo = scan.nextInt() - 1;
							scan.nextLine();
							items.remove(removeNo);

							System.out.println("Product has been successfully removed!\n");
						} catch (IndexOutOfBoundsException e) {
							System.out.println("Product list does not have that product number\n");
						}

						System.out.print("Do you want to remove another product? (Y/N) ");
						continueFunction = scan.nextLine();
					}
					break;
				case "4":
					while(!continueFunction.equalsIgnoreCase("N")) {
						System.out.println("\nEnter 1 to search by order number, or enter 2 to search by product name. ");
						System.out.print("Your choice: ");
						int searchOption = scan.nextInt();
						int searchFlag = 0;

						scan.nextLine();

						//Sub-menu for searching function
						switch(searchOption) {
							case 1:
								System.out.print("\nType in the number of product you are looking for: ");
								int searchNo = scan.nextInt() - 1;
								scan.nextLine();
								if (searchNo >= 0 && searchNo < items.size() && items.contains(items.get(searchNo))) {
									System.out.println("Found you product!");
									System.out.println(items.get(searchNo) + "\n");
								} else {
									System.out.println("Product not found!");
								}
								break;
							case 2:
								System.out.print("\nType in the name of product: ");
								String searchStr = scan.nextLine();
								for (Product p : items) {
									if (p.getName().contains(searchStr)) {
										System.out.println("Found you product!");
										System.out.println(p + "\n");
										searchFlag =1;
									}
								}
								if (searchFlag == 0) {
									System.out.println("product not found!");
								}
								break;
							default:
								System.out.println("\nPlease choose a correct number!\n");
								break;
						}

						System.out.print("Do you want to search another product? (Y/N) ");
						continueFunction = scan.nextLine();
					}
					break;
				case "5":
					Collections.sort(items, new Comparator<Product>(){
						public int compare(Product p1, Product p2) {
							return p1.getName().compareToIgnoreCase(p2.getName());
						}
					});
					System.out.println("\nList of product(s) after sorted");
					for(int i = 0; i < items.size(); i++) {
						System.out.print(items.get(i));
					}
					break;
				default:
					if (!option.equalsIgnoreCase("quit"))
						System.out.println("\nPlease choose a number!\n");
					break;
			}
		}

		//Save data to external file
		try {
			PrintWriter outFile = new PrintWriter(new FileWriter(outputName));
			for (int i = 0; i < items.size(); i++) {
				outFile.println(items.get(i).getName() + "\t\t\t" + items.get(i).getQuantity() + "\t\t" + items.get(i).getPrice());
			}
			outFile.close();
			System.out.println("\n------Successfully saved data to external file-----");
		} catch (IOException e){
			System.out.println(e);
		}

	}
}