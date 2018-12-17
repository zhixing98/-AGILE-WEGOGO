/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import data.Model;
import gui.View;

public class MVCShoppingCart {

	public static void main(String[] args) {
		Model model = new Model();
		View view = new View();
		@SuppressWarnings("unused")
		Controller controller = new Controller(model, view);
		view.setBounds(100, 100, 500, 500);
		view.setVisible(true);
	}

}