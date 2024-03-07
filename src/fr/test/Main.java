package fr.test;

import fr.test.structures.Commande;
import fr.test.utilitaires.ConvertisseurJsonCommande;
import fr.test.utilitaires.NetworkUtils;
import org.json.JSONObject;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static List<Commande> commandes = new ArrayList<>();
	public static Commande commandeSelectionnee = null;

	public static void main(String[] args) {
		System.out.println("> Récupération des commandes");
		String reponseCommandes = NetworkUtils.request("http://localhost/site-resto/api/commandes_en_attente.php");
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
		final JSONObject commandesObjet = new JSONObject(reponseCommandes);
		if(!commandesObjet.getBoolean("success")){
			JOptionPane.showMessageDialog(
					null,
					"L'API a renvoyé un success = false !\n" + reponseCommandes,
					"Erreur lors de la récupération des commandes",
					JOptionPane.ERROR_MESSAGE
			);
			return;
		}

		Main.commandes = ConvertisseurJsonCommande.conversionJsonVersCommandes(commandesObjet.getJSONArray("commandes"));
		new Fenetre();
	}

}
