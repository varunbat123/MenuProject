/**
 * The Menu class implements an abstract data type for a list of menu items supporting some common operations on such lists.
 * @author Varun Batra
 * varun.batra@stonybrook.edu
 * 110256128
 */
public class Menu implements Cloneable {
	public boolean success= true;// false if exception is thrown

	final int Max_Items = 50; // Max size of items that a menu can hold
	MenuItem [] menuItems= new MenuItem[Max_Items]; // Array used for storing menu items
	/**
	 * constructs an instance of the menu class with no menu item objects inside
	 * Post condition: This Menu has been initialized to an empty list of MenuItems.
	 */
	public Menu(){
		
	}
	/**
	 * Constructs an instance of the menu class
	 * @param menu
	 * 	Construct a new menu from the menu array of this parameter
	 */
	public Menu(Menu menu){
		for(int i=0;i<menu.menuItems.length;i++){
			this.menuItems[i]=menu.menuItems[i];
		}
		
	}
	/**
	 * Construct an instance of the menu class with an already existing array of menu item objects
	 * @param menuItems
	 * 	an array of menuItem objects
	 */

	public Menu(MenuItem[]menuItems){
		for(int i=0;i<menuItems.length;i++){
			this.menuItems[i]=menuItems[i];
		}
		
	}
	/**
	 * Generates a copy of this Menu object
	 * Changes to the Copy will not change the original
	 */
	public Object clone(){
	Menu clone= new Menu();
	try {
		clone = (Menu) super.clone();
	} catch (CloneNotSupportedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	for(int i =0; i<this.size();i++){
		clone.menuItems[i]= (MenuItem) this.menuItems[i].clone();
	}
	return clone;
	
	}
	/**
	 * Compare this object to another menu object for equality
	 * @param obj
	 * 	object to which this menu is compared
	 * @return true if this menu object is equal to the object being compared and all menu items are in the same order
	 */
	public boolean equals(Object obj){
		if (obj== null){
			return false;
		}		
		if(!(obj instanceof Menu)){
			return false;
		}
		else{
		
			for(int i =0; i< this.size();i++){
				if (this.menuItems[i].name== ((Menu) obj).menuItems[i].name&
					(this.menuItems[i].description== ((Menu) obj).menuItems[i].description&
					(this.menuItems[i].price== ((Menu) obj).menuItems[i].price))){
					return true;	
			}
			
		}
		}
		return false;
	}
	/**
	 * returns size of this menu
	 * Precondition: menu object has been instantiated;
	 * @return
	 */
	public int size(){
		int count =0;
		if(this.menuItems[0]==null){
			System.out.println("Null");
			return 0;
		}
			for(int i =0;i<menuItems.length;i++){
				count++;
				if(i+1==this.menuItems.length^this.menuItems[i+1]==null){
					return count;
				}
			}
			return count;
	
	}
	/**
	 * Adds an item to this menu object
	 * @param item
	 * 	Menuitem with a name, description, and price
	 * @param position
	 * 	Position in which this menuItem should be placed
	 * Precondition: 
	 * 	This Menu object has been instantiated and 1 < position < items_currently_in_list + 1. 
	 * The number of MenuItem objects in this Menu is less than MAX_ITEMS. 
	 * Postcondition:
	 * The new MenuItem is now stored at the desired position in the Menu.
	 * All MenuItems that were originally in positions greater than or equal to position are moved back one position.
	 * @exception IllegalArgumentException
	 * 	Indicates that the position is out of range
	 */
	public void addItem(MenuItem item, int position){
	
		try{
			if(position<1){
				
				throw new IllegalArgumentException();
				
				
			}
			if(position>this.size()+1){
				
				throw new IllegalArgumentException();
			}
			if(position>this.size()+1){
				
				throw new NullPointerException();
			}
		if(this.size()==this.Max_Items){
	
			throw new FullListException();
		}
		MenuItem temp = null;
		temp =this.menuItems[position-1];
		this.menuItems[position-1] = item;
		if(this.menuItems[position]==null){
		
		this.menuItems[position]= temp;}
		else{
			this.addItem(this.menuItems[position], position);
		}
		}
		catch(IllegalArgumentException e){
			this.success=false;
		System.out.println("Position is out of range");
		
		}
		catch(FullListException e){
			this.success=false;
			System.out.println("List is full");
			
			}
		catch(NullPointerException e){
			System.out.println("Position is not valid");
		}
	}
	/**
	 * Removes item from menu
	 * @param position
	 * 	position of the item in the menu that will be removed
	 * Precondition:
	 * 	This Menu object has been instantiated and 1 < position < items_currently_in_list. 
	 * PostCondition:
	 * 	The MenuItem at the desired position in the Menu has been removed. 
	 * All MenuItems that were originally in positions greater than or equal to position are moved forward one position.
	 */
	public void removeItem(int position){
		try{
			if(position<1){
		
			throw new IllegalArgumentException();
			
			
		}
			if(position>this.size()+1){
				
				throw new IllegalArgumentException();
				
			}
			
			if(position>this.size()+1){
				
				throw new NullPointerException();
				
			}
if(this.menuItems[position-1]==null){
			
				throw new NullPointerException();
			}
		
			
		this.menuItems[position-1]=null;
		isNull(position);// Checks whether the next position is null, if move the item forward and keep checking until null
		}
		catch(IllegalArgumentException e){
			this.success=false;
			System.out.println("Position is out of range");
		}
		catch(NullPointerException e){
			this.success=false;
			System.out.println("Position is out of range");
		}
		
	}
	
	
	public void isNull(int position){
		if (this.menuItems[position]==null){
			return;
			
		}
		else{
			this.menuItems[position-1]= this.menuItems[position];
			this.menuItems[position]=null;
			
		}
		isNull(position+1);
		
	}
	/**
	 * get the item at the given position
	 * @param position
	 * 	position of the item in the menu
	 * @return
	 * 	 the item at the given position
	 */
	public MenuItem getItem(int position){
		MenuItem answer = new MenuItem("null","null",null);
		try{
			if(position<1 ){
			
				throw new IllegalArgumentException();
			}
			if(position> this.size()+1){
			
				throw new IllegalArgumentException();
			}
			if(position> this.size()+1){
				
				throw new NullPointerException();
			}
			if(this.menuItems[position-1]==null){
			
				throw new NullPointerException();
			}
			answer=this.menuItems[position-1];
		}
		
		catch(IllegalArgumentException e){
			this.success=false;
			System.out.println("Position is not valid");
		}
		catch(NullPointerException e){
			this.success=false;
			System.out.println("Position is not valid");
			
		}
		return answer;
		
	}
	/**
	 * Gets the menuItem from the array with the given name
	 * @param name
	 * 	name of this menuItem
	 * @return
	 *  menuItem with the given name
	 *  Preconditions:
	 *  	Menu object has been instantiated
	 *  @exception Illegal argument exception
	 *  	indicates that the item with the given name doesnt exist
	 */
	public MenuItem getItemByName(String name){
		MenuItem answer = null;
		try{
			
		
		for(int i =0; i<this.size();i++){
			if(this.menuItems[i].name.equals(name)){
				answer = this.menuItems[i];
			}
			else{
			throw new IllegalArgumentException();}
		}

		}
		catch(IllegalArgumentException e){
			this.success=false;
			System.out.println("Item with this given name does not exist");
			
		}
		return answer;
		
		
	}
	public void printAllItems(){
	
	System.out.println(this.toString());
}
	
	
	public String toString(){
		String x = "Menu: \n";
	 x+=	String.format("%-21s%-26s%19s%19s", "#", "Name", "Description", "Price");
	x+= "\n"+"---------------------------------------------------------------------------------------";
	x+="\n";
	for(int i =0; i<this.size();i++){
		String name = this.menuItems[i].name;
		String description = this.menuItems[i].description;
		Double price = this.menuItems[i].price;
		int item = i+1;
		
		x+=String.format("%-21d%-26s%19s%19s", item, name, description,price);
		x+="\n";
		
	}
	
	return x;
	}
	public void printOrder(){
		String x = "Order: \n";
	 x+=	String.format("%-21s%-26s%19s%19s", "#", "Name", "Description", "Price");
	x+= "\n"+"---------------------------------------------------------------------------------------";
	x+="\n";
	for(int i =0; i<this.size();i++){
		String name = this.menuItems[i].name;
		String description = this.menuItems[i].description;
		Double price = this.menuItems[i].price;
		int item = i+1;
		
		x+=String.format("%-21d%-26s%19s%19s", item, name, description,price);
		x+="\n";
		
	}
	
	System.out.println( x);
	}
	
	
	
	public static void main(String[] args){
		MenuItem one = new MenuItem("Dog", "d",4.0);
		MenuItem two = new MenuItem("og", "d",4.0);
		MenuItem three = new MenuItem("Dg", "d",4.0);
		MenuItem [] a = {one};
		Menu m = new Menu(a);
	
		System.out.println(m.equals(m.clone()));
	Menu x = new Menu((Menu )m.clone());

	System.out.println(m.equals(x));
	System.out.println(m.getItem(1).name);
	System.out.println(x.getItem(1).name);
	x.addItem(one,3);
m.getItem(49);
		
		

		
	}
	

}
