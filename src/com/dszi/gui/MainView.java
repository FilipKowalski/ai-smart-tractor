package com.dszi.gui;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
/*
Neuro dev
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
 */



import net.miginfocom.swing.MigLayout;


public class MainView {
	
	/*
	 * UWAGA
	 * tutorial dla layoutu ktory zostal uzyty http://www.miglayout.com/QuickStart.pdf
	 */
	
	GridPanel gridPanel = new GridPanel();

	public MainView() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
				}
				
				JButton generate = new JButton("Ruszaj");
				generate.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						gridPanel.startTractor();
					}
		        });  
				
				JTextField field1 = new JTextField("Pole 1");				
				JTextField field2 = new JTextField("Pole 2");
				
				/*
				JTextField field3 = new JTextField("Neuron MCP");
				field3.setEditable(false);
				
				TableModel dataModel = new AbstractTableModel() {
					  public int getColumnCount() { return 12; }
			          public int getRowCount() { return 12;}
			          public Object getValueAt(int row, int col) { return new Double(col+row); }
			      };
			    JTable table = new JTable(dataModel);
			    JScrollPane scrollpane = new JScrollPane(table);
				*/ //Neuro dev
				JFrame frame = new JFrame("iTractor");
				//JFrame frame2 = new JFrame("Neuro DEV");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLayout(new MigLayout());
				frame.add(field1, "width 100:250:300, cell 0 0");
				frame.add(field2, "width 100:250:300, cell 1 0 2 1");
				frame.add(generate, "cell 3 0");
				frame.add(gridPanel, "cell 0 1 4 1");
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				
				/*
				frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame2.setLayout(new MigLayout());
				frame2.add(field3, "width 100:250:300, cell 0 0");
				frame2.add(table, "cell 0 1");
				frame2.pack();
				frame2.setLocationRelativeTo(null);
				frame2.setVisible(false);
				*/ //Neuro dev
				
				
			}
		});
	}
}