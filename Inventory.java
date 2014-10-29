/**
 * Author Jeanine Kimball
 * Inventory.java
 * IT215 - Java Programming
 */
public class Inventory
{
	// initialize

	private String itemNumber = "";
        private String itemTitle = "";
	private int itemStock = 0;
	private double itemPrice = 0;
	protected double itemValue = 0;
    private static double totalValue = 0;

	// constructor with four arguments
	public Inventory(String itemNumber, String itemTitle, int itemStock, double itemPrice)
	{
            this.itemNumber = itemNumber;
            this.itemTitle = itemTitle;
	    this.itemStock = itemStock;
	    this.itemPrice = itemPrice;
	}

	public void setItemNumber(String itemNumber)
	{ // method to set the sequence number of item
		this.itemNumber = itemNumber;
	} // end method setItemNumber

	public String getItemNumber()
	{ // method to retrieve the sequence number of item
		return itemNumber;
	} // end method getItemNumber

        public void setItemTitle(String itemTitle)
	{ // method to set the title of item
		this.itemTitle = itemTitle;
	} // end method setItemTitle

	public String getItemTitle()
	{ // method to retrieve the title of item
		return itemTitle;
	} // end method getItemTitle

	public void setItemStock(int itemStock)
	{ // method to set the stock number of item
		this.itemStock = itemStock;
	} // end method setItemStock

	public int getItemStock()
	{ // method to retrieve the stock number of item
		return itemStock;
	} // end method getItemStock

	public void setItemPrice(double itemPrice)
	{ // method to set the price of the item
		this.itemPrice = itemPrice;
	} // end method setItemPrice

	public double getItemPrice()
	{ // method to retrieve the price of the item
		return itemPrice;
	} // end method getItemPrice

	public void setItemValue(double itemValue)
	{ // method to set the value of the item's inventory
		this.itemValue = itemValue;
	} // end method setItemValue

	public double getItemValue()
	{ // method to calculate the value of the item's inventory
		return itemValue = itemStock * itemPrice;
	} // end method getItemValue

    public void setInventoryValue(double totalValue)
    { // method to set the value of all items in inventory
        Inventory.totalValue = totalValue;
    } // end method setInventoryValue

    public static double valueOfInventory(Inventory[] theInventory)
    { // method to calculate the value of all items in inventory
    	for (int index = 0; index < theInventory.length; index++)
    	{
    		totalValue += theInventory[index].getItemValue();
    	}
    	return totalValue;
    } // end method getInventoryValue

    public static Inventory[] sortInventory(Inventory[] theInventory)
    { // method to sort inventory
    	Inventory tmp;
    	for (int index = 0; index < theInventory.length; index++)
    	{
    		for (int anotherIndex = index + 1; anotherIndex < theInventory.length; anotherIndex++)
    		{
    			String s1 = theInventory[index].getItemTitle();
    			String s2 = theInventory[anotherIndex].getItemTitle();
    			if(s1.compareTo(s2) > 0)
    			{
    				tmp = theInventory[index];
    				theInventory[index] = theInventory[anotherIndex];
    				theInventory[anotherIndex] = tmp;
    			}
    		}
    	}
    	return theInventory;
    } // end sort method

} // end Inventory class
