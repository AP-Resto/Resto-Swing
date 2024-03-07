package fr.test.panels;

import fr.test.structures.Commande;

import java.awt.Color;

import javax.swing.*;

public class PanelDetailCommande extends JPanel {
	private TableauLigneComandes tableauLignesCmd;
	private Commande commandeSelectionnee;

	public PanelDetailCommande() {
		this.setLayout(null);
		this.ajouterComposants();
	}

	private void ajouterComposants(){
		if(this.commandeSelectionnee == null)
			return;

		this.removeAll();
		this.tableauLignesCmd = new TableauLigneComandes();
		this.tableauLignesCmd.setBounds(55, 215, 831, 350);
		this.tableauLignesCmd.setBackground(Color.black);
		this.add(this.tableauLignesCmd);
	}

	public void setCommande(Commande cmd) {
		this.commandeSelectionnee = cmd;
		this.ajouterComposants();
		this.repaint();
	}

	public TableauLigneComandes getTableauLignesCmd() {
		return tableauLignesCmd;
	}
}
