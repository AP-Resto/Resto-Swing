package fr.test.utilitaires;

import fr.test.structures.Commande;
import fr.test.structures.Ligne;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class ConvertisseurJsonCommande {
    public static List<Commande> conversionJsonVersCommandes(JSONArray arrayCommandes) {
        List<Commande> listeCommandes = new ArrayList<>();

        for (int i = 0; i < arrayCommandes.length(); i++) {
        	final JSONObject commandeObj = arrayCommandes.getJSONObject(i);

            final int idCommande = commandeObj.getInt("id_commande");
            final int idUser = commandeObj.getInt("id_user");
            final int idEtat = commandeObj.getInt("id_etat");
            final String date = commandeObj.getString("date");
            final double totalCommande = Double.parseDouble(commandeObj.getString("total_commande"));
            final int typeConso = commandeObj.getInt("type_conso");

            final JSONObject userobject = commandeObj.getJSONObject("user");

            final String loginUtilisateur = userobject.getString("login");
            final String mailUtilisateur = userobject.getString("email");

            final JSONArray lignes = commandeObj.getJSONArray("lignes");

            final List<Ligne> listeLignes = new ArrayList<>();

            for (int j = 0; j < lignes.length(); j++) {
                final JSONObject ligneObj = lignes.getJSONObject(j);

                final int idLigne = ligneObj.getInt("id_ligne");
                final int idProduit = ligneObj.getInt("id_produit");
                final int qty = ligneObj.getInt("qte");
                final String libProduit = ligneObj.getString("libelle_produit");
                final double totalLigneHt = Double.parseDouble(ligneObj.getString("total_ligne_ht"));

                Ligne ligne = new Ligne(idLigne, idProduit, libProduit, qty, totalLigneHt);
                listeLignes.add(ligne);
            }

            final Commande commande = new Commande(idCommande, idUser, idEtat, date, totalCommande, typeConso, listeLignes, loginUtilisateur, mailUtilisateur);
            listeCommandes.add(commande);
        }

        return listeCommandes;
    }

    public static String getLibelleEtat(int idEtat){
        if(idEtat == 0){
            return "En attente";
        }else if(idEtat == 1){
            return "En préparation";
        }else if(idEtat == 2){
            return "Terminée";
        }else if(idEtat == 3){
            return "Refusée";
        }

        return "";
    }
}
