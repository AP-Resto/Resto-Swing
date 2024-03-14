package fr.test.panels;

import fr.test.structures.Commande;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class PanelDetailCommande extends JPanel {
	private TableauLigneComandes tableauLignesCmd;
	private Commande commandeSelectionnee;
	private JLabel idLabel; // Label pour afficher l'ID de la commande
	private JLabel DateLabel;
	private JLabel EtatLabel;
	private JLabel MontantLabel;
	private JLabel UserLabel;

	private Font arial = new Font("Arial", Font.PLAIN, 14);

	public PanelDetailCommande() {
		this.setLayout(null);
		this.ajouterComposants();
	}

	private void ajouterComposants() {
		if (this.commandeSelectionnee == null)
			return;

		this.removeAll();
		this.tableauLignesCmd = new TableauLigneComandes();
		this.tableauLignesCmd.setBounds(55, 215, 831, 350);
		this.tableauLignesCmd.setBackground(Color.black);
		this.add(this.tableauLignesCmd);

		// Ajout d'un JLabel pour afficher l'ID de la commande
		idLabel = new JLabel(
				"<html><b>Identifiant de la commande sélectionnée : </b>#" + commandeSelectionnee.getIdCommande());
		idLabel.setForeground(Color.black);
		idLabel.setFont(arial);
		idLabel.setBounds(20, 20, 400, 30);
		this.add(idLabel);

		DateLabel = new JLabel("<html><b>Date et heure de la commande : </b>" + commandeSelectionnee.getDate());
		DateLabel.setForeground(Color.black);
		DateLabel.setFont(arial);
		DateLabel.setBounds(20, 50, 400, 30);
		this.add(DateLabel);

		EtatLabel = new JLabel("<html><b>Etat de la commande : </b>" + commandeSelectionnee.getIdEtat());
		EtatLabel.setForeground(Color.black);
		EtatLabel.setBounds(20, 80, 400, 30);
		EtatLabel.setFont(arial);
		this.add(EtatLabel);

		MontantLabel = new JLabel(
				"<html><b>Montant Total (TTC) : </b>" + commandeSelectionnee.getTotalCommande() + " €");
		MontantLabel.setForeground(Color.black);
		MontantLabel.setBounds(20, 110, 400, 30);
		MontantLabel.setFont(arial);
		this.add(MontantLabel);

		UserLabel = new JLabel("<html><b>Auteur de la commande : </b>" + commandeSelectionnee.getIdUser());
		UserLabel.setForeground(Color.black);
		UserLabel.setBounds(20, 140, 400, 30);
		UserLabel.setFont(arial);
		this.add(UserLabel);

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
