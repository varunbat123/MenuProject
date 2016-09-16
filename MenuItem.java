/**
 * This MenuItem class implements an object that can be placed in a menu
 * @author Varun Batra
 *varun.batra@stonybrook.edu
 *110256128
 */
public class MenuItem implements Cloneable{
	String name;// name of item
	String description; // description of item
	Double price; // price of item
	/**
	 * Creates an instance of a MenuItem
	 */
	public MenuItem(){
		
	}
	/**
	 * Creates an instance of MenuItem with a name, ddescription, and price
	 * @param name
	 * 	name of this item
	 * @param description
	 * 	description of this item
	 * @param price
	 * 	price of this item
	 */
	public MenuItem(String name, String description, Double price){
		this.name= name; 
		this.description = description;
		this.price= price;
	}
	/**
	 * gets the name of this item
	 * @return
	 * 	name 
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * sets the name of this item
	 * @param name
	 * 	name of this item
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * gets the description of this item
	 * @return
	 * 	description
	 */
	public String getDescription(){
		return this.description;
		
	}
	/**
	 * sets the description of this item
	 * @param x
	 * 	description to set
	 */
	public void setDescription(String x){
		this.description = x;
		
	}
	/**
	 * gets the price of this item
	 * @return
	 * 	price
	 */
	public Double getPrice(){
		return this.price;
	}
	/**
	 * sets the price of this item
	 * @param price
	 * 	price to be set
	 */
	public void setPrice(Double price){
		if(price <0){
			throw new IllegalArgumentException();
		}
		try{
		this.price= price;}
		catch(IllegalArgumentException e){
			System.out.println(" Price cannot be negative");
		}
		
	}
	/**
	 * returns the string representation of this object
	 */
	public String toString(){
		return this.name+ " "+ this.description+ " "+ this.price;
		
	}
	/**
	 * Creates a copy of this instance
	 */
	public Object clone(){
		MenuItem clone = new MenuItem();
		try {
			clone = (MenuItem) super.clone();
		} catch (CloneNotSupportedException e) {
			
			e.printStackTrace();
		}
		return clone;
	}
	

}
