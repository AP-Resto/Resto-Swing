package fr.test.panels;

import fr.test.structures.Commande;

import javax.swing.JPanel;

public class TableauLigneComandes extends JPanel {

	private Commande commandeSelectionne = null;

	public TableauLigneComandes() {
		this.setLayout(null);

		this.ajouterComposants();
	}

	private void ajouterComposants(){
		this.removeAll();
		
	}

	public void setCommandeSelectionne(Commande commandeSelectionne) {
		this.commandeSelectionne = commandeSelectionne;
	}
}
