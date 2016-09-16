/**
 * This class is used as an interface to interact with the Menu class.
 * @author Varun Batra
 * varun.batra@stonybrook.edu
 * 110256128
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MenuOperations {
	
	
	 Menu menu = new Menu();
	

		Menu order = new Menu();
	
	public void Operation() throws NumberFormatException, IOException{
		menu.success=true;
		System.out.println("Select an operation: ");

InputStreamReader inStream = new InputStreamReader(System.in);
BufferedReader scan = new BufferedReader(inStream);
	
		switch(scan.readLine().toUpperCase()){// case insensitive
	
		case "A":System.out.println("Enter the Name: ");
		String name = scan.readLine();// Sets variable name to the next input from the user
		System.out.println("Enter the description");
		String description = scan.readLine();// sets variable to the nexgt description from the user
		System.out.println("Enter the Price:");
		try{
		Double price = Double.parseDouble(scan.readLine());// sets variable to the next input from the user
		MenuItem item = new MenuItem(name,description,price);// creates a new MenuItem with given parameters
		System.out.println("Enter the position");
		int position = Integer.parseInt(scan.readLine()); //sets position to next input
		menu.addItem(item, position);// calls add item method, and passes new item, and position
		if(menu.success){
		System.out.println("Added "+ item.name+ ", "+ item.description+ ", "+ "for"+ " $"+ item.price+ " at postion "+ position);
		// if no exception is thrown then print out success message
		}
		}
		catch(NumberFormatException e){
			System.out.println("Must be a  valid number");
			
		}
		
		
		
	
		
		Operation();
		
		break;
	
		case "G": System.out.println("Enter the position: ");
		try{
		int p = Integer.parseInt(scan.readLine());// set position to p
		menu.getItem(p);// get item at position p
		if(menu.success){
		System.out.println(menu.getItem(p).toString());// if no exception print out success message
		}
		}
		catch(NumberFormatException e){
			System.out.println("Must be a valid number");
		}
		Operation();
		break;
		case "R": System.out.println("Enter the position: ");
		try{
		int r = Integer.parseInt(scan.readLine());// set position input to r
		menu.removeItem(r);
		if(menu.success){
		System.out.println("Removed item at "+r);
		}
		}
		catch(NumberFormatException e){
			System.out.println("Must be a valid Number");
		}
		Operation();
		
		break;
		
		case "P":menu.printAllItems();
		Operation();
		break;
		
		case "S":System.out.println("There are "+menu.size()+" "+"items in the menu");
		Operation();
		break;
		case "D": 
		System.out.println("Enter the new description ");
		try{
		String des = scan.readLine();
		System.out.println("Enter the position: ");
		int d = Integer.parseInt(scan.readLine());
		MenuItem x = menu.getItem(d);
		if(menu.success){
			x.setDescription(des);
		System.out.println("New description set");
		}
		}
		catch(NumberFormatException e){
			System.out.println("Must be a valid number");
		}
		Operation();
		break;
		case "C": 
			System.out.println("Enter the new price ");
			try{
			double pri = Double.parseDouble(scan.readLine());
			
			System.out.println("Enter the position: ");
			int z = Integer.parseInt(scan.readLine());
			MenuItem q= menu.getItem(z);
					
			if(menu.success){
				q.setPrice(pri);
		System.out.println("Changed price of "+ menu.getItem(z).name + " to " + pri);
			}
			}
			catch(NumberFormatException e){
				System.out.println("must be a valid number");
			}
			Operation();
			break;
		case "O":
			System.out.println("Enter position of item to add to order");
			try{
			int o = Integer.parseInt(scan.readLine());
		
		order.addItem(menu.getItem(o),o);
		if(menu.success){
		System.out.println(menu.getItem(o).name+" added to order");
		}
			}
			catch(NumberFormatException e){
				System.out.println("Must be a valid number");
			}
		Operation();
		break;
		case "V":
			order.printOrder();;
			Operation();
			break;
		case "I":
			System.out.println("Enter position");
			try{
			int remove = Integer.parseInt(scan.readLine());
			order.removeItem(remove);
			}
			catch(NumberFormatException e){
				System.out.println("Must be a valid number");
			}
			Operation();
		case "Q":
			System.out.println("Exiting Program....");
			break;
			
		
		
		
		
		
		
		
		}
	}
	public void mainMenu(){
		System.out.println("Main Menu: " );
		System.out.println("A) Add Item" );
		System.out.println("G) Get Item" );
		System.out.println("R) Remove Item" );
		System.out.println("P) Print All Items" );
		System.out.println("S) Size" );
		System.out.println("D) Update description" );
		System.out.println("C) Update price" );
		System.out.println("O) Add to order" );
		System.out.println("I) Remove from order" );
		System.out.println("V) View order" );
		System.out.println("Q) Quit" );

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		MenuOperations m = new MenuOperations();
		m.mainMenu();
	
		

		m.Operation();
	}

}
