/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 *
 */
public class View extends JFrame {
	/**
	 * Constructs view
	 */
	public View() {
		viewRefresh();
	}

	/**
	 * Adds a panel to the view
	 * @param panel JPanel to add to view
	 */
	public void addPanel(JPanel panel) {
		getContentPane().add(panel);
	}

	/**
	 * Removes a panel to the view
	 * @param panel JPanel to remove from view
	 */
	public void removePanel(JPanel panel) {
		getContentPane().remove(panel);
	}

	/**
	 * Refreshes the view by repainting and revalidating
	 */
	public void viewRefresh() {
		getContentPane().repaint();
		getContentPane().revalidate();
	}
}