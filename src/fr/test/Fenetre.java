package fr.test;

import javax.swing.JFrame;

import fr.test.panels.PanelPrincipal;

public class Fenetre extends JFrame {
	
	public Fenetre() {
		this.setTitle("Mafée - Gestion des commandes");
		this.setSize(1280, 720);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setContentPane(new PanelPrincipal());
		this.setLayout(null);
		
		this.setVisible(true);
	}

}
