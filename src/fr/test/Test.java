package fr.test;

import fr.test.utilitaires.NetworkUtils;

import javax.swing.*;

public class Test {
	public static void main(String[] args) {
		System.out.println("> Récupération des commandes");
		String reponseCommandes = NetworkUtils.request("http://localhost:8080/ap/api/commandes_en_attente.php");
		if(reponseCommandes.startsWith("Erreur")){
			JOptionPane.showMessageDialog(
					null,
					"Une erreur est survenue durant la récupération des commandes.\n" + reponseCommandes,
					"Erreur lors de la récupération des commandes",
					JOptionPane.ERROR_MESSAGE
			);
			return;
		}

		System.out.println("> Commandes récupérées");
		new Fenetre();
	}

}
