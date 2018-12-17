/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Controller;

public class ProductPanel extends JPanel {
	private JPanel product;
	private String Name;
	private String Description;
	int Quantity;
	float Invoiceprice;
	float Sellingprice;
	private JButton buynow;
	private JButton increment;
	private JButton decrement;
	private JButton stockincrement;
	private JButton stockdecrement;
	private control.Controller.IncrementListener IncrementListener;
	private Controller.DecrementListener DecrementListener;
	private Controller.StockIncrementListener StockIncrementListener;
	private Controller.StockDecrementListener StockDecrementListener;
	private Controller.BuyNowListener BuyNowListener;

	/**
	 * Creates a store product
	 * 
	 * @param id
	 * @param type
	 * @param quantity
	 * @param invoiceprice
	 * @param sellingprice
	 * @param name
	 * @param description
	 * @param buyNowListener
	 */
	public ProductPanel(String id, String type, String quantity, String invoiceprice, String sellingprice, String name,
			String description, Controller.BuyNowListener buyNowListener) {
		Name = name;
		Description = description;
		String.valueOf(id);
		Quantity = Integer.parseInt(quantity);
		Invoiceprice = Float.parseFloat(invoiceprice);
		Sellingprice = Float.parseFloat(sellingprice);
		BuyNowListener = buyNowListener;
		createStoreItem();
	}

	/**
	 * Creates a inventory panel
	 * 
	 * @param id
	 * @param name
	 * @param type
	 * @param sellingprice
	 * @param invoiceprice
	 * @param quantity
	 * @param incrementListener
	 * @param decrementListener
	 */
	public ProductPanel(String id, String name, String type, String sellingprice, String invoiceprice, String quantity,
			Controller.IncrementListener incrementListener, Controller.DecrementListener decrementListener) {
		Name = name;
		String.valueOf(id);
		Quantity = Integer.parseInt(quantity);
		Sellingprice = Float.parseFloat(sellingprice);
		IncrementListener = incrementListener;
		DecrementListener = decrementListener;

		createCheckoutComponents();
	}

	/**
	 * Creates a shopping cart product
	 * 
	 * @param id
	 * @param type
	 * @param quantity
	 * @param invoiceprice
	 * @param sellingprice
	 * @param name
	 * @param description
	 * @param incrementListener
	 * @param decrementListener
	 */
	public ProductPanel(String id, String type, String quantity, String invoiceprice, String sellingprice, String name,
			String description, Controller.StockIncrementListener incrementListener,
			Controller.StockDecrementListener decrementListener) {
		Name = name;
		String.valueOf(id);
		Quantity = Integer.parseInt(quantity);
		Sellingprice = Float.parseFloat(sellingprice);
		StockIncrementListener = incrementListener;
		StockDecrementListener = decrementListener;

		createAdminComponents();
	}

	/**
	 * Returns the product panel
	 *
	 * @return
	 */
	public JPanel getPanel() {
		return product;
	}

	/**
	 * Create JLabel for image
	 *
	 * @param imageLocation
	 *            Location of image on drive
	 * @return Returns the image as a JLabel
	 */
	public JLabel prodImage(String imageLocation) {
		JLabel image = new JLabel();
		image.setIcon(new ImageIcon(imageLocation));
		return image;
	}

	/**
	 * Create JLabel for description
	 *
	 * @param description
	 *            New description
	 * @return JLabel description
	 */
	public JLabel prodDescription(String description) {
		JLabel prodDescription = new JLabel(description);
		return prodDescription;
	}

	/**
	 * Creates all components for checkout
	 */
	private void createCheckoutComponents() {
		product = new JPanel(new BorderLayout());
		product.setName(Name);
		product.setBackground(new Color(235, 232, 217));
		product.setBorder(new EmptyBorder(10, 5, 10, 5));

		product.add(prodImage("img/" + Name + ".jpg"), BorderLayout.WEST);
		product.add(new JLabel(Name), BorderLayout.NORTH);

		JPanel checkout = new JPanel(new BorderLayout());
		JPanel checkoutButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel checkoutInfo = new JPanel(new FlowLayout());
		checkoutInfo.add(new JLabel("$" + Sellingprice));
		if (Quantity == 0) {
			checkoutInfo.add(new JLabel("REMOVE?"));
		} else {
			checkoutInfo.add(new JLabel("Amount: " + Quantity));
		}
		checkoutButtons.add(incrementCartButton(IncrementListener));
		checkoutButtons.add(decrementCartButton(DecrementListener));
		checkout.add(checkoutInfo, BorderLayout.NORTH);
		checkout.add(checkoutButtons, BorderLayout.SOUTH);
		product.setBackground(new Color(235, 232, 217));
		product.add(checkout, BorderLayout.EAST);
	}

	/**
	 * Creates all components for admins
	 */
	private void createAdminComponents() {
		product = new JPanel(new BorderLayout());
		product.setName(Name);
		product.setBackground(new Color(235, 232, 217));
		product.setBorder(new EmptyBorder(10, 5, 10, 5));

		product.add(prodImage("img//" + Name + ".png"), BorderLayout.WEST);
		product.add(new JLabel(Name), BorderLayout.NORTH);

		JPanel checkout = new JPanel(new BorderLayout());
		JPanel checkoutButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel checkoutInfo = new JPanel(new FlowLayout());
		checkoutInfo.add(new JLabel("$" + Sellingprice));
		if (Quantity == 0) {
			checkoutInfo.add(new JLabel("REMOVE?"));
		} else {
			checkoutInfo.add(new JLabel("Amount: " + Quantity));
		}
		checkoutButtons.add(incrementCartButton(StockIncrementListener));
		checkoutButtons.add(decrementCartButton(StockDecrementListener));
		checkout.add(checkoutInfo, BorderLayout.NORTH);
		checkout.add(checkoutButtons, BorderLayout.SOUTH);
		product.setBackground(new Color(235, 232, 217));
		product.add(checkout, BorderLayout.EAST);
	}

	/**
	 * Creates all items for store
	 */
	private void createStoreItem() {
		product = new JPanel(new BorderLayout());
		product.setName(Name);
		product.setBackground(new Color(235, 232, 217));
		product.setBorder(new EmptyBorder(10, 5, 10, 5));

		product.add(prodImage("img//" + Name + ".png"), BorderLayout.WEST);
		product.add(new JLabel(Name), BorderLayout.NORTH);

		JPanel store = new JPanel(new BorderLayout());
		JPanel checkoutInfo = new JPanel(new FlowLayout());
		JPanel prodDesc = new JPanel(new FlowLayout());
		store.add(buyNowButton(BuyNowListener), BorderLayout.SOUTH);
		if (Quantity == 0) {
			checkoutInfo.add(new JLabel("OUT OF STOCK"));
		} else {
			checkoutInfo.add(new JLabel("Stock: " + Quantity));
			checkoutInfo.add(new JLabel("$" + Sellingprice));
		}
		prodDesc.add(prodDescription(Description));
		store.add(checkoutInfo, BorderLayout.NORTH);
		store.add(prodDesc, BorderLayout.CENTER);
		store.setBackground(new Color(235, 232, 217));
		product.add(store, BorderLayout.EAST);
	}

	/**
	 * Creates a buy noew button for a product
	 *
	 * @param buynowbutton
	 *            Action listener for buy now
	 * @return Buy Now JButton
	 */
	public JButton buyNowButton(ActionListener buynowbutton) {
		buynow = new JButton("Buy Now");
		buynow.addActionListener(buynowbutton);
		return buynow;
	}

	/**
	 * Creates increment cart button
	 *
	 * @param incrementButton
	 *            Action listener for increment
	 * @return JButton that increments cart
	 */
	public JButton incrementCartButton(ActionListener incrementButton) {
		increment = new JButton("^");
		increment.addActionListener(incrementButton);
		return increment;
	}

	/**
	 * Creates decrement cart button
	 *
	 * @param decrementButton
	 *            Action listener for decrement
	 * @return JButton that decrements cart
	 */
	public JButton decrementCartButton(ActionListener decrementButton) {
		decrement = new JButton("v");
		decrement.addActionListener(decrementButton);
		return decrement;
	}

	/**
	 * Creates JButton to increment stock
	 *
	 * @param incrementButton
	 *            Action listener for increment
	 * @return JButton that increments stock
	 */
	public JButton incrementStockButton(ActionListener incrementButton) {
		stockincrement = new JButton("^");
		stockincrement.addActionListener(incrementButton);
		return stockincrement;
	}

	/**
	 * Creates JButton to decrement stock
	 *
	 * @param decrementButton
	 *            Action listener for decrement
	 * @return
	 */
	public JButton decrementStockButton(ActionListener decrementButton) {
		stockdecrement = new JButton("v");
		stockdecrement.addActionListener(decrementButton);
		return stockdecrement;
	}

	// Action Listeners
	public void addBuyNowListener(ActionListener listenerforBuyNow) {
		buynow.addActionListener(listenerforBuyNow);
	}

	public void addIncrementListener(ActionListener listenerForIncrement) {
		increment.addActionListener(listenerForIncrement);
	}

}