package fr.test.panels;

import java.awt.Color;

import javax.swing.JPanel;

public class PanelDetailCommande extends JPanel {
	
	private TableauLigneComandes tableauLignesCmd;
	
	public PanelDetailCommande() {
		this.setLayout(null);
		this.setBackground(Color.blue);
		
		this.tableauLignesCmd = new TableauLigneComandes();
		this.tableauLignesCmd.setBounds(55, 215, 831, 350);
		this.tableauLignesCmd.setBackground(Color.black);
		
		this.add(this.tableauLignesCmd);
	}
}
