package fr.test.panels;

import fr.test.structures.Commande;
import fr.test.utilitaires.ConvertisseurJsonCommande;
import fr.test.utilitaires.NetworkUtils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

		EtatLabel = new JLabel("<html><b>Etat de la commande : </b>" + ConvertisseurJsonCommande.getLibelleEtat(commandeSelectionnee.getIdEtat()));
		EtatLabel.setForeground(Color.black);
		EtatLabel.setBounds(20, 80, 400, 30);
		EtatLabel.setFont(arial);
		this.add(EtatLabel);

		MontantLabel = new JLabel(
				"<html><b>Montant Total (TTC) : </b>" + String.format("%.2f", commandeSelectionnee.getTotalCommande()) + " €");
		MontantLabel.setForeground(Color.black);
		MontantLabel.setBounds(20, 110, 400, 30);
		MontantLabel.setFont(arial);
		this.add(MontantLabel);

		UserLabel = new JLabel("<html><b>Auteur de la commande : </b>" + commandeSelectionnee.getLoginUser() + " (<u>" + commandeSelectionnee.getEmailUser() + "</u>)");
		UserLabel.setForeground(Color.black);
		UserLabel.setBounds(20, 140, 400, 30);
		UserLabel.setFont(arial);
		this.add(UserLabel);
		
		// Création des boutons avec des images
		ImageIcon croixIcon = new ImageIcon(getClass().getResource("/image/effacer.png"));

		JButton croixButton = new JButton("Refuser la commande", new ImageIcon(croixIcon.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));
		croixButton.setBounds(56, 570, 286, 77);
		croixButton.setHorizontalTextPosition(SwingConstants.RIGHT); // Texte à droite de l'icône
	    croixButton.setVerticalTextPosition(SwingConstants.CENTER); // Texte centré verticalement
		croixButton.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				commandeSelectionnee.action_commandeRefusee();
			}
		});
		this.add(croixButton);

		JButton sablierButton = new JButton("", new ImageIcon(getClass().getResource("/image/en_attente.png")));
		sablierButton.setBounds(435, 570, 77, 77);
		sablierButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				commandeSelectionnee.action_commandeAcceptee();
			}
		});
		this.add(sablierButton);

		ImageIcon validerIcon = new ImageIcon(getClass().getResource("/image/valider.png"));		
		JButton validerButton = new JButton("Commande prête", new ImageIcon(validerIcon.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));
		
		validerButton.setBounds(600, 570, 286, 77);
		validerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				commandeSelectionnee.action_commandePrete();
			}
		});
		this.add(validerButton);


		final int yTableau = 175;
		final int margeGaucheTableau = 45;

		JLabel idcmd = new JLabel(
				"<html><b>Identifiant </b>");
		idcmd.setForeground(Color.black);
		idcmd.setFont(arial.deriveFont(18F));
		idcmd.setBounds(20 + margeGaucheTableau, yTableau, 91, 39);
		this.add(idcmd);

		JLabel denree = new JLabel(
				"<html><b>Denrée </b>");
		denree.setForeground(Color.black);
		denree.setFont(arial.deriveFont(18F));
		denree.setBounds(255 + margeGaucheTableau, yTableau, 91, 39);
		this.add(denree);

		JLabel quantite = new JLabel(
				"<html><b>Quantité </b>");
		quantite.setForeground(Color.black);
		quantite.setFont(arial.deriveFont(18F));
		quantite.setBounds(460 + margeGaucheTableau, yTableau, 91, 39);
		this.add(quantite);


		JLabel prixUT = new JLabel(
				"<html><b>Prix Unité </b>");
		prixUT.setForeground(Color.black);
		prixUT.setFont(arial.deriveFont(18F));
		prixUT.setBounds(690 + margeGaucheTableau, yTableau, 91, 39);
		this.add(prixUT);
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
