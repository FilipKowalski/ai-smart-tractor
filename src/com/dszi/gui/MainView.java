package com.dszi.gui;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

import com.dszi.decision_tree.TreeAlgorithm;
import com.dszi.tractor.Tractor;


public class MainView {

	/*
	 * UWAGA
	 * tutorial dla layoutu ktory zostal uzyty http://www.miglayout.com/QuickStart.pdf
	 */

	GridPanel gridPanel = new GridPanel();
	static Tractor tractor = new Tractor();

	JLabel tractorStateLabel = new JLabel("-- Stan pocz�tkowy traktora -- ");
	JLabel waterLevelLabel = new JLabel("Poziom wody : ");
	public static JLabel waterLevel = new JLabel(Integer.toString(tractor.getWaterLevel()));
	JLabel pesticideLevelLabel = new JLabel("Poziom pestycyd�w : ");
	public static JLabel pesticideLevel = new JLabel(Integer.toString(tractor.getPesticideLevel()));
	JLabel fertilizerLevelLabel = new JLabel("Poziom nawozu : ");
	public static JLabel fertilizerLevel = new JLabel(Integer.toString(tractor.getFertilizerLevel()));

	JButton generate = new JButton("Generuj");
<<<<<<< HEAD
	JButton moveTractor = new JButton("Ruszaj");
	JButton genetic = new JButton("Selekcja");
=======
	JButton uruchomA = new JButton("Uruchom A*");
>>>>>>> fd8e8e26dd012c6d0e6c008855d5fa1d6fe46f02
	JButton runTractor = new JButton("Uruchom traktor");
	JButton treeButton = new JButton("Drzewo");

	public MainView() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException ex) {
				} catch (InstantiationException e2) {
	
				} catch ( IllegalAccessException e3) {
					
				} catch ( UnsupportedLookAndFeelException e4) {
					
				}
				
				initializeListeners();

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
				//JFrame frame2 = new JFrame("Neuro DEV");
				/*
				frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame2.setLayout(new MigLayout());
				frame2.add(field3, "width 100:250:300, cell 0 0");
				frame2.add(table, "cell 0 1");
				frame2.pack();
				frame2.setLocationRelativeTo(null);
				frame2.setVisible(false);
				 */ //Neuro dev
				
				
				JFrame frame = new JFrame("iTractor");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLayout(new MigLayout());

				frame.add(tractorStateLabel, "cell 0 0");
				frame.add(waterLevelLabel, "cell 0 1");
				frame.add(waterLevel, "w 80!, cell 0 1");
				frame.add(pesticideLevelLabel, "cell 0 2");
				frame.add(pesticideLevel, "cell 0 2");
				frame.add(fertilizerLevelLabel, "cell 0 3");
				frame.add(fertilizerLevel, "cell 0 3");

				frame.add(generate, "cell 0 4");
<<<<<<< HEAD
				frame.add(moveTractor, "cell 0 5, wrap");
				frame.add(genetic, "cell 0 6, wrap");
=======
				frame.add(uruchomA, "cell 0 5, wrap");
				frame.add(treeButton, "cell 0 6, wrap");
>>>>>>> fd8e8e26dd012c6d0e6c008855d5fa1d6fe46f02
				frame.add(gridPanel, "east");
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

	private void initializeListeners() {
		generate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				gridPanel.clearGridView();
				gridPanel.initializeGeneratedData();
			}
		});
		uruchomA.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				gridPanel.startTractor();
			}
		});
<<<<<<< HEAD
		genetic.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				gridPanel.Genetic();
=======
		treeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				gridPanel.startTreeTractor();
>>>>>>> fd8e8e26dd012c6d0e6c008855d5fa1d6fe46f02
			}
		});
	}
}