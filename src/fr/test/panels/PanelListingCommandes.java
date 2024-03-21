package fr.test.panels;

import fr.test.Main;
import fr.test.panels.PanelPrincipal;
import fr.test.structures.Commande;
import fr.test.utilitaires.ConvertisseurJsonCommande;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PanelListingCommandes extends JPanel {

    private JScrollPane scrollPane;
    private JPanel contentPanel;

    public PanelListingCommandes() {
        this.setLayout(null);
        this.ajouterComposant();
    }

    private void ajouterComposant() {
        this.scrollPane = new JScrollPane();
        this.contentPanel = new JPanel();
        this.contentPanel.setLayout(new BoxLayout(this.contentPanel, BoxLayout.Y_AXIS));

        final JScrollBar verticalScrollBar = this.scrollPane.getVerticalScrollBar();
        verticalScrollBar.setUnitIncrement(20);

        final List<Commande> commandes = Main.commandes;
        for (int i = 0; i < commandes.size(); i++) {
            Commande cmd = commandes.get(i);

            JButton bouton = new JButton(
                    "<html><center><br><b>Commande #" + cmd.getIdCommande() + "</b><br>" + ConvertisseurJsonCommande.getLibelleEtat(cmd.getIdEtat()) + "<br>" + cmd.getDate() + "<br /> "
            );

            bouton.setFont(bouton.getFont().deriveFont(15F));
            bouton.setBounds(0, i * 80, 330, 80);
            bouton.setBackground(new Color(0xFF9A9A9A));
            bouton.setForeground(Color.black);
            bouton.setFocusPainted(false);
            bouton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ((PanelPrincipal) PanelListingCommandes.this.getParent()).getPanelDetailCmd().setCommande(cmd);
                    ((PanelPrincipal) PanelListingCommandes.this.getParent()).getPanelDetailCmd().getTableauLignesCmd().setCommandeSelectionne(cmd);
                }
            });

            this.contentPanel.add(bouton);
        }

        // Ajout du panel de contenu à la scroll pane
        this.scrollPane.setViewportView(contentPanel);

        // Définir la politique de défilement
        this.scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Définir la taille de la scroll pane
        this.scrollPane.setBounds(0, 0, 330, 720);

        this.add(this.scrollPane);
    }
}
