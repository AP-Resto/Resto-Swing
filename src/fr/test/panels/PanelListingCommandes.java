package fr.test.panels;

import fr.test.Main;
import fr.test.structures.Commande;
import fr.test.utilitaires.ConvertisseurJsonCommande;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

public class PanelListingCommandes extends JPanel {

    JScrollPane scrollPane = new JScrollPane(); // Ajout du JScrollPane contenant ce panneau

    public PanelListingCommandes() {
        this.setLayout(null);
        this.ajouterComposant();
        this.add(scrollPane);
    }


    private void ajouterComposant() {
        List<Commande> commandes = Main.commandes;

        for (int i = 0; i < commandes.size(); i++) {
            Commande cmd = commandes.get(i);

            JButton bouton = new JButton(
                    "<html><center><b>#" + cmd.getIdCommande() + "</b><br>" + ConvertisseurJsonCommande.getLibelleEtat(cmd.getIdEtat()) + "<br>" + cmd.getDate()
            );
            bouton.setFont(bouton.getFont().deriveFont(15F));
            bouton.setBounds(0, i * 80, 330, 80);
            bouton.setBackground(Color.gray);
            bouton.setForeground(Color.white);
            bouton.setFocusPainted(false);
            bouton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ((PanelPrincipal)PanelListingCommandes.this.getParent()).getPanelDetailCmd().setCommande(cmd);
                    ((PanelPrincipal)PanelListingCommandes.this.getParent()).getPanelDetailCmd().getTableauLignesCmd().setCommandeSelectionne(cmd);
                }
            });
            this.add(bouton);
        }
    }

}
