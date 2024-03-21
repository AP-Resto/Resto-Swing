package fr.test.structures;

import fr.test.utilitaires.NetworkUtils;

import java.util.ArrayList;
import java.util.List;

public class Commande {
    /*
        JSON renvoyé par l'api:
        {
            "id_commande": 6,
            "id_user": 8,
            "id_etat": 1,
            "date": "2023-11-30 16:58:27",
            "total_commande": "35.87",
            "type_conso": 1,
            "lignes": [
                {
                    "id_ligne": 17,
                    "id_produit": 3,
                    "qte": 1,
                    "total_ligne_ht": "12.50"
                },
                {
                    "id_ligne": 18,
                    "id_produit": 2,
                    "qte": 1,
                    "total_ligne_ht": "14.00"
                },
                {
                    "id_ligne": 19,
                    "id_produit": 5,
                    "qte": 1,
                    "total_ligne_ht": "7.50"
                }
            ]
        }
     */

    private int id_commande;
    private int id_user;
    private int id_etat;
    private String date;
    private double total_commande;
    private int type_conso;

    private String loginUser;
    private String emailUser;

    private List<Ligne> lignes = new ArrayList<>();

    public Commande(int id_commande, int id_user, int id_etat, String date, double total_commande, int type_conso, List<Ligne> lignes, String loginUser, String emailUser) {
        this.id_commande = id_commande;
        this.id_user = id_user;
        this.id_etat = id_etat;
        this.date = date;
        this.total_commande = total_commande;
        this.type_conso = type_conso;
        this.lignes = lignes;
        this.loginUser = loginUser;
        this.emailUser = emailUser;
    }

    public int getIdCommande() {
        return id_commande;
    }

    public int getIdUser() {
        return id_user;
    }

    public int getIdEtat() {
        return id_etat;
    }

    public String getDate() {
        return date;
    }

    public double getTotalCommande() {
        return total_commande;
    }

    public int getTypeConso() {
        return type_conso;
    }

    public List<Ligne> getLignes() {
        return lignes;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void action_commandeRefusee(){
        String response = NetworkUtils.request("/commande_refuser?id_commande=" + this.id_commande);
        System.out.println("JSON réponse refusée: " + response);
    }
    public void action_commandePrete(){
        String response = NetworkUtils.request("/commande_terminer?id_commande=" + this.id_commande);
        System.out.println("JSON réponse terminée: " + response);
    }
    public void action_commandeAcceptee(){
        String response = NetworkUtils.request("/commande_accepter?id_commande=" + this.id_commande);
        System.out.println("JSON réponse commande acceptée: " + response);

    }

}
