/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import data.Model;
import static gui.FinancePanel.financialinfo;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import sun.applet.Main;


public class HistoryPanel extends JFrame
{
    private static JPanel historyPanel;
    static JPanel historyinfo;
    private Model model;
    String username;
    
    public HistoryPanel(List<String[]> history) {
		historyPanel = new JPanel(new WrapLayout());
		historyPanel.setLayout(new WrapLayout());
		historyPanel.setPreferredSize(new Dimension(1250,600));
		JLabel financelabel = new JLabel("History...");
		historyPanel.add(financelabel);
                //getUserName();
                System.out.println(username);
                String[] nextUser;
                
                //System.out.println(model.getAccountUsername());
                
                            //if (sale[0].equals(username)){

		for (String[] sale : history) {
			if (sale[2].equals("Username")) {
				JPanel FinanceSalelabels = new JPanel(new GridLayout(0, 10));
				FinanceSalelabels.setBackground(new Color(200, 200, 200));
				FinanceSalelabels.add(new JLabel("total"));
				FinanceSalelabels.add(new JLabel("cost"));
				FinanceSalelabels.add(new JLabel("username"));
				FinanceSalelabels.add(new JLabel("first"));
				FinanceSalelabels.add(new JLabel("last"));
				FinanceSalelabels.add(new JLabel("cc"));
				FinanceSalelabels.add(new JLabel("email"));
				FinanceSalelabels.add(new JLabel("address"));
                                FinanceSalelabels.add(new JLabel("Date Time"));
                                FinanceSalelabels.add(new JLabel("Status"));
				FinanceSalelabels.setPreferredSize(new Dimension(1200, 25));
				historyPanel.add(FinanceSalelabels);
				continue;
			} else {
                            //if (sale[0].equals(username)){
				JPanel FinanceSale = new JPanel(new GridLayout(0, 10));
				FinanceSale.setBackground(new Color(200, 200, 200));
				FinanceSale.add(new JLabel(sale[0]));
				FinanceSale.add(new JLabel(sale[1]));
				FinanceSale.add(new JLabel(sale[2]));
				FinanceSale.add(new JLabel(sale[3]));
				FinanceSale.add(new JLabel(sale[4]));
				FinanceSale.add(new JLabel(sale[5]));
				FinanceSale.add(new JLabel(sale[6]));
				FinanceSale.add(new JLabel(sale[7]));
                                FinanceSale.add(new JLabel(sale[8]));
                                FinanceSale.add(new JLabel(sale[9]));
				FinanceSale.setPreferredSize(new Dimension(1200, 25));
				historyPanel.add(FinanceSale);
                                }
			//}
		}
		historyinfo = new JPanel(new WrapLayout());
		historyPanel.add(historyinfo);
		historyinfo.setPreferredSize(new Dimension(400, 125));
	}

    public HistoryPanel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
	 * Returns the history panel for use
	 * 
	 * @return Finance JPanel
	 */
	public Component getPanel() {
		return historyPanel;
	}
        
        public void getUserName(){
            //username = model.Username;
        }

     
    public static void main(String[] args) {
    }
}