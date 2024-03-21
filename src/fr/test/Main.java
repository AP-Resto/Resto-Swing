package fr.test;

import fr.test.structures.Commande;
import fr.test.structures.Ligne;
import fr.test.utilitaires.ConvertisseurJsonCommande;
import fr.test.utilitaires.NetworkUtils;
import org.json.JSONObject;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

	public static final String API_BASE_URL = "https://localhost/site-resto/api";

	public static List<Commande> commandes = new ArrayList<>();
	public static Commande commandeSelectionnee = null;

	public static void main(String[] args) {

		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception e){}

		System.out.println("> Récupération des commandes");
		String reponseCommandes = NetworkUtils.request("/commandes_en_attente.php");
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

		//commandes = hydrateCommandes();
		new Fenetre();
	}

	private static List<Commande> hydrateCommandes() {
		final List<Commande> commandesDeTest = new ArrayList<>();

		final Random random = new Random();

		for(int i = 0; i < 10; i++){
			final List<Ligne> lignes = new ArrayList<>();
			for(int j = 0; j < 20; j++){
				lignes.add(new Ligne(
						random.nextInt(),
						random.nextInt(),
						"Produit de test",
						random.nextInt(),
						random.nextDouble()
				));
			}
			Commande commande = new Commande(
					random.nextInt(),
					random.nextInt(),
					1,
					"14/03/2024",
					random.nextDouble(),
					1,
					lignes,
					"Login de Test",
					"login@test.fr"
			);

			commandesDeTest.add(commande);
		}

		return commandesDeTest;
	}

}
