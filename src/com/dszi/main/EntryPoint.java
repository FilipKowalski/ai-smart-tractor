package com.dszi.main;

import java.awt.EventQueue;

import com.dszi.gui.MainView;

public class EntryPoint {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainView();
			}
		});
	}

}
