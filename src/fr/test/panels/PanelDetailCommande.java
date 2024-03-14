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
		
		// Ajout d'un JLabel pour afficher l'ID de la commande
        idLabel = new JLabel("Identifiant de la commande sélectionnée : #" + commandeSelectionnee.getIdCommande());
        idLabel.setFont(new Font("Arial", Font.BOLD, 16));
        idLabel.setForeground(Color.black);
        idLabel.setBounds(20, 20, 400, 30);
        this.add(idLabel);
        
        DateLabel = new JLabel("Date et heure de la commande : " + commandeSelectionnee.getDate());
        DateLabel.setFont(new Font("Arial", Font.BOLD, 16));
        DateLabel.setForeground(Color.black);
        DateLabel.setBounds(20, 50, 400, 30);
        this.add(DateLabel);
        
        EtatLabel = new JLabel("Etat de la commande : " + commandeSelectionnee.getIdEtat());
        EtatLabel.setFont(new Font("Arial", Font.BOLD, 16));
        EtatLabel.setForeground(Color.black);
        EtatLabel.setBounds(20, 80, 400, 30);
        this.add(EtatLabel);
        
        MontantLabel = new JLabel("Montant Total (TTC) : " + commandeSelectionnee.getTotalCommande());
        MontantLabel.setFont(new Font("Arial", Font.BOLD, 16));
        MontantLabel.setForeground(Color.black);
        MontantLabel.setBounds(20, 110, 400, 30);
        this.add(MontantLabel);
        
        UserLabel = new JLabel("Auteur de la commande : " + commandeSelectionnee.getIdUser());
        UserLabel.setFont(new Font("Arial", Font.BOLD, 16));
        UserLabel.setForeground(Color.black);
        UserLabel.setBounds(20, 140, 400, 30);
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
