/**
 * Author Jeanine Kimball
 * InventoryTest.java
 */
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InventoryTest extends JFrame implements Serializable
{
	private int i = 0;

	private JPanel gridLayout = new JPanel();

	ImageIcon logo = new ImageIcon("software.jpg");

    Software[] allItems = new Software[5];
    private int index = allItems.length;

    DecimalFormat Currency = new DecimalFormat("$#,##0.00");
    DecimalFormat Number = new DecimalFormat("0");

    // set fields
    JTextField indexField;
    JTextField numberField;
    JTextField nameField;
    JTextField platformField;
    JTextField stockField;
    JTextField priceField;
    JTextField restockField;
    JTextField itemField;
    JTextField valueField;

    // set buttons
    JButton loadButton;
    JButton addButton;
    JButton modifyButton;
    JButton deleteButton;
    JButton searchButton;
    JButton saveButton;
    JButton firstButton;
    JButton nextButton;
    JButton previousButton;
    JButton lastButton;

    public InventoryTest()
	{
    	super("Inventory of Software");

        // pass values from Inventory
        allItems[0] = new Software("1001", "Windows 7", "PC", 25, 219.99);
        allItems[1] = new Software("1002", "Microsoft Word", "Mac", 12, 115.99);
        allItems[2] = new Software("1003", "Adobe Photoshop", "PC", 9, 99.99);
        allItems[3] = new Software("1004", "Guild Wars", "PC", 35, 39.95);
        allItems[4] = new Software("1005", "World of Warcraft", "Mac", 5, 49.95);

        // set layout
        gridLayout.setLayout(new BorderLayout());
        gridLayout.add(this.modifyPanel(), BorderLayout.NORTH);
        gridLayout.add(this.labelPanel(), BorderLayout.WEST);
        gridLayout.add(this.fieldsPanel(), BorderLayout.CENTER);
        gridLayout.add(this.buttonPanel(), BorderLayout.SOUTH);
        add(gridLayout);

	} // end method InventoryTest

    private JPanel labelPanel()
    {
    	// create labels
    	JLabel indexLabel = new JLabel("Index");
    	JLabel numberLabel = new JLabel("Item Number");
    	JLabel nameLabel = new JLabel("Software Title");
        JLabel platformLabel = new JLabel("Platform");
        JLabel stockLabel = new JLabel("Number in Stock");
        JLabel priceLabel = new JLabel("Price");
        JLabel restockLabel = new JLabel("Restocking Fee (5%)");
        JLabel itemLabel = new JLabel("Item Value with Fee");
        JLabel valueLabel = new JLabel("Inventory Value with Fee (All Items)");

        // add labels
        JPanel labels = new JPanel();
        labels.add(indexLabel);
        labels.add(numberLabel);
        labels.setLayout(new GridLayout(9,2));
        labels.add(nameLabel);
        labels.add(platformLabel);
        labels.add(stockLabel);
        labels.add(priceLabel);
        labels.add(restockLabel);
        labels.add(itemLabel);
        labels.add(valueLabel);

        return labels;
    } // end label panel

    private JPanel fieldsPanel()
    {
    	// create fields
    	indexField = new JTextField();
    	indexField.setEditable(false);

    	numberField = new JTextField();
    	numberField.setEditable(false);

    	nameField = new JTextField();
    	nameField.setEditable(false);

    	platformField = new JTextField();
    	platformField.setEditable(false);

    	stockField = new JTextField();
    	stockField.setEditable(false);

    	priceField = new JTextField();
    	priceField.setEditable(false);

    	restockField = new JTextField();
    	restockField.setEditable(false);

    	itemField = new JTextField();
    	itemField.setEditable(false);

    	valueField = new JTextField(Currency.format(Software.valueOfInventory(allItems)));
    	valueField.setEditable(false);

    	// add fields
    	JPanel fields = new JPanel();
    	fields.setLayout(new GridLayout(9,2));
    	fields.add(indexField);
    	fields.add(numberField);
    	fields.add(nameField);
    	fields.add(platformField);
    	fields.add(stockField);
    	fields.add(priceField);
    	fields.add(restockField);
    	fields.add(itemField);
    	fields.add(valueField);

    	return fields;
    } // end field panel

    private JPanel modifyPanel()
    {
    	// create buttons
    	ButtonHandler handler = new ButtonHandler();

    	loadButton = new JButton("Load file");
    	loadButton.addActionListener(handler);

    	addButton = new JButton("Add");
    	addButton.addActionListener(handler);

    	modifyButton = new JButton("Modify");
    	modifyButton.addActionListener(handler);

    	deleteButton = new JButton("Delete");
    	deleteButton.addActionListener(handler);

    	searchButton = new JButton("Search");
    	searchButton.addActionListener(handler);

    	saveButton = new JButton("Save");
    	saveButton.addActionListener(handler);

    	// add buttons
    	JPanel mButtons = new JPanel();
    	mButtons.add(loadButton);
    	mButtons.add(addButton);
    	mButtons.add(modifyButton);
    	mButtons.add(deleteButton);
    	mButtons.add(searchButton);
    	mButtons.add(saveButton);

    	return mButtons;
    } // end modify button panel

    private JPanel buttonPanel()
    {
    	JLabel softwareLabel = new JLabel(logo);

    	// create buttons
    	ButtonHandler handler = new ButtonHandler();

    	firstButton = new JButton("First");
    	firstButton.addActionListener(handler);

    	nextButton = new JButton("Next");
    	nextButton.addActionListener(handler);

    	previousButton = new JButton("Previous");
    	previousButton.addActionListener(handler);

    	lastButton = new JButton("Last");
    	lastButton.addActionListener(handler);

    	// add buttons
		JPanel buttons = new JPanel();
		buttons.add(softwareLabel);
		buttons.add(firstButton);
		buttons.add(nextButton);
		buttons.add(previousButton);
		buttons.add(lastButton);

		return buttons;
    } // end button panel

    public class ButtonHandler implements ActionListener
	{
    	public void actionPerformed(ActionEvent event)
    	{
    		if (event.getActionCommand().equals("Add"))
    		{
                    addButton.setText("Click to Add!");

                    numberField.setText("");
                    numberField.setEditable(true);

                    nameField.setText("");
                    nameField.setEditable(true);

                    platformField.setText("");
                    platformField.setEditable(true);

                    stockField.setText("0");
                    stockField.setEditable(true);

                    priceField.setText("0.00");
                    priceField.setEditable(true);

                    restockField.setText("0.00");
                    itemField.setText("0.00");

    	    	}

    		if (event.getActionCommand().equals("Click to Add!"))
    		{
                    addButton.setText("Add");

                    numberField.setEditable(false);
                    nameField.setEditable(false);
                    platformField.setEditable(false);
                    stockField.setEditable(false);
                    priceField.setEditable(false);

                    Software newItem = new Software(numberField.getText(), nameField.getText(), platformField.getText(), Integer.parseInt(stockField.getText()), Double.parseDouble(priceField.getText()));
                    Software[] add = new Software[allItems.length + 1];
                    for(int a = 0; a < add.length - 1; a++)
                    {
                        add[a] = allItems[a];
                    }
                    add[allItems.length] = newItem;
                    allItems = add;
                    i = allItems.length - 1;
                    showInventory();
    		}

    		if (event.getActionCommand().equals("Modify"))
    		{
                    modifyButton.setText("Click to Modify!");

                    numberField.setEditable(true);
                    nameField.setEditable(true);
                    platformField.setEditable(true);
                    stockField.setEditable(true);
                    priceField.setEditable(true);
    		}

    		if (event.getActionCommand().equals("Click to Modify!"))
    		{
                    modifyButton.setText("Modify");

                    numberField.setEditable(false);
                    nameField.setEditable(false);
                    platformField.setEditable(false);
                    stockField.setEditable(false);
                    priceField.setEditable(false);

                    Software changeItem = new Software(numberField.getText(), nameField.getText(), platformField.getText(), Integer.parseInt(stockField.getText()), Double.parseDouble(priceField.getText()));
                    allItems[i] = changeItem;
    		}

    		if (event.getSource() == deleteButton)
    		{
                    Software item = (Software)allItems[i];
                    int confirm = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete item " + item.getItemTitle() + "?");
                    if(confirm == JOptionPane.YES_OPTION)
                    {
                        Software[] temp = new Software[allItems.length - 1];
                        int counter = 0;
                        for(int d = 0; d < allItems.length;d++)
                        {
                            if(d == i)
                            {
                            }
                            else
                            {
                                temp[counter++] = allItems[d];
                            }
                        }
                        allItems = temp;
                    }
    		}

    		if (event.getSource() == searchButton)
    		{
    			searchButton.setText("GO!");

    			nameField.setEditable(true);
    		}

    		if (event.getActionCommand().equals("GO!"))
    		{
    			searchButton.setText("Search");

    			nameField.setEditable(false);

                        for(int search = 0; search < allItems.length; search++)
                        {
                            if(nameField.getText().equals(allItems[search].getItemTitle()))
                            {
                                numberField.setText(allItems[search].getItemNumber());
                                nameField.setText(allItems[search].getItemTitle());
                        	platformField.setText(allItems[search].getPlatform());
                        	stockField.setText(Number.format(allItems[search].getItemStock()));
                         	priceField.setText(Currency.format(allItems[search].getItemPrice()));
                          	restockField.setText(Currency.format(allItems[search].getRestockFee()));
                          	itemField.setText(Currency.format(allItems[search].getItemValue()));
                            }
                        }
    		}

    		if (event.getSource() == saveButton)
    		{
    			
    		}

    		if (event.getSource() == firstButton)
    		{
    			i = 0;
    			showInventory();
            }

            if (event.getSource() == nextButton)
            {
            	if (i == allItems.length - 1)
            	{
            		i = 0;
            		showInventory();
                }
                else
                {
                	i++;
                	showInventory();
                }
            }

            if (event.getSource() == previousButton)
            {
            	if (i == 0)
            	{
            		i = (allItems.length - 1);
            		showInventory();
            	}
            	else
            	{
            		i--;
            		showInventory();
            	}
            }

            if (event.getSource() == lastButton)
            {
            	i = (allItems.length - 1);
            	showInventory();
            }
    	}
	} //close inner ButtonHandler class

    public void showInventory()
    {
    	numberField.setText(allItems[i].getItemNumber());
    	nameField.setText(allItems[i].getItemTitle());
    	platformField.setText(allItems[i].getPlatform());
    	stockField.setText(Number.format(allItems[i].getItemStock()));
    	priceField.setText(Currency.format(allItems[i].getItemPrice()));
    	restockField.setText(Currency.format(allItems[i].getRestockFee()));
    	itemField.setText(Currency.format(allItems[i].getItemValue()));
    } // end method showInventory

    public static void main(String[] args)
	{
            InventoryTest inventoryFrame = new InventoryTest();
	    inventoryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    inventoryFrame.setSize(650,400);
	    inventoryFrame.setVisible(true);

	} // end main method

} // end InventoryTest class
