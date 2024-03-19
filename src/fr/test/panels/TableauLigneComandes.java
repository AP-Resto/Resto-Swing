package fr.test.panels;

import fr.test.Main;
import fr.test.panels.listeners.ChangerFondEnFonctionDuSurvol;
import fr.test.structures.*;
import fr.test.utilitaires.ConvertisseurJsonCommande;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.List;

public class TableauLigneComandes extends JPanel {

	private Commande commandeSelectionne;
	private Integer id_produit;

	private Font arial = new Font("Arial", Font.PLAIN, 14);
	private JLabel idLabel;
	private JScrollPane scrollPane;
	private JPanel contentPanel;


	public TableauLigneComandes() {

		this.setLayout(null);
		this.setBackground(Color.white);
		this.ajouterComposants();
	}

	private void ajouterComposants(){
		if (this.commandeSelectionne == null)
			return;

		this.scrollPane = new JScrollPane();
		this.contentPanel = new JPanel();
		this.contentPanel.setLayout(new BoxLayout(this.contentPanel, BoxLayout.Y_AXIS));

		final JScrollBar verticalScrollBar = this.scrollPane.getVerticalScrollBar();
		verticalScrollBar.setUnitIncrement(20);


		/*JLabel idcmd = new JLabel(
				"<html><b>Identifiant </b>");
		idcmd.setForeground(Color.black);
		idcmd.setFont(arial.deriveFont(18F));
		idcmd.setBounds(20, 10, 91, 39);
		this.add(idcmd);

		JLabel denree = new JLabel(
		"<html><b>Denrée </b>");
		denree.setForeground(Color.black);
		denree.setFont(arial.deriveFont(18F));
		denree.setBounds(230, 10, 91, 39);
		this.add(denree);

		JLabel quantite = new JLabel(
				"<html><b>Quantité </b>");
		quantite.setForeground(Color.black);
		quantite.setFont(arial.deriveFont(18F));
		quantite.setBounds(460, 10, 91, 39);
		this.add(quantite);


		JLabel prixUT = new JLabel(
				"<html><b>Prix Unité </b>");
		prixUT.setForeground(Color.black);
		prixUT.setFont(arial.deriveFont(18F));
		prixUT.setBounds(690, 10, 91, 39);
		this.add(prixUT);*/


		List<Ligne> lignes = this.commandeSelectionne.getLignes();

		for (int i = 0; i < lignes.size(); i++) {
            Ligne cmd = lignes.get(i);

            JPanel panelLigne = new JPanel();
            panelLigne.addMouseListener(new ChangerFondEnFonctionDuSurvol());
            panelLigne.setPreferredSize(new Dimension(800, 40));
            panelLigne.setLayout(null);

			JLabel IdLigne = new JLabel(
					"<html><center><b> #" + cmd.getIdLigne(),
					SwingConstants.CENTER
			);
			IdLigne.setFont(IdLigne.getFont().deriveFont(15F));
			IdLigne.setBounds(10, 13, 75, 15);
			IdLigne.setBackground(Color.gray);
			IdLigne.setForeground(Color.black);
            panelLigne.add(IdLigne);


			JLabel libProduit = new JLabel(
					"<html><center><b>" + cmd.getLibelle_produit()
			);
			libProduit.setFont(libProduit.getFont().deriveFont(15F));
			libProduit.setBounds(230, 13, 330, 15);
			libProduit.setBackground(Color.gray);
			libProduit.setForeground(Color.black);
            panelLigne.add(libProduit);

			JLabel qteCommande = new JLabel(
					"<html><center><b>" + cmd.getQte(),
					SwingConstants.CENTER
			);
			qteCommande.setFont(qteCommande.getFont().deriveFont(15F));
			qteCommande.setBounds(460, 13, 50, 15);
			qteCommande.setBackground(Color.gray);
			qteCommande.setForeground(Color.black);
            panelLigne.add(qteCommande);

			JLabel TotalLigne = new JLabel(
					"<html><center><b>" + String.format("%.2f", cmd.getTotalLigneHt()) + " €"
			);
			TotalLigne.setFont(TotalLigne.getFont().deriveFont(15F));
			TotalLigne.setBounds(690, 13, 330, 15);
			TotalLigne.setBackground(Color.gray);
			TotalLigne.setForeground(Color.black);
            panelLigne.add(TotalLigne);

            panelLigne.revalidate();
            contentPanel.add(panelLigne);

        }

        contentPanel.setBackground(Color.WHITE);

		// Ajout du panel de contenu à la scroll pane
		this.scrollPane.setViewportView(contentPanel);
        this.scrollPane.setLayout(new ScrollPaneLayout());

		// Définir la politique de défilement
		this.scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		// Définir la taille de la scroll pane
		this.scrollPane.setBounds(0, 0, 831, 350);

		this.add(this.scrollPane);
        scrollPane.revalidate();
	}

	public void setCommandeSelectionne(Commande commandeSelectionne) {
		this.commandeSelectionne = commandeSelectionne;
		this.ajouterComposants();
		this.repaint();
	}
}
