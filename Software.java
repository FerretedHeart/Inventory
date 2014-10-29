/**
 * Author Jeanine Kimball
 * Software.java
 * IT215 - Java Programming
 */
public class Software extends Inventory
{
	// initialize
	private String platform = "";
	private double restockFee = 0;
	private double restockRate = 0.05;

	public Software(String itemNumber, String itemTitle, String platform, int itemStock, double itemPrice)
	{ // constructor
		super(itemNumber, itemTitle, itemStock, itemPrice);
		this.platform = platform;
	} // end constructor

	public void setPlatform(String platform)
	{ // method to set the platform of item
		this.platform = platform;
	} // end method setPlatform

	public String getPlatform()
	{ // method to retrieve the title of item
		return platform;
	} // end method getPlatform

	public void setRestockFee(double restockFee)
	{ // method to set the restocking fee of the item
		this.restockFee = restockFee;
	} // end method setRestockFee

	public double getRestockFee()
	{ // method to retrieve the restocking fee of the item
		return restockFee = getItemPrice() * restockRate;
	} // end method getRestockFee

	public double getItemValue()
	{ // method to calculate the value of the item's inventory
		return itemValue = getItemStock() * (getItemPrice() + restockFee);
	} // end method getItemValue

} // end subclass Software
