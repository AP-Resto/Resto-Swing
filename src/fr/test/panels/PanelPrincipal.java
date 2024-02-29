package fr.test.panels;

import java.awt.Color;

import javax.swing.JPanel;

public class PanelPrincipal extends JPanel {
	
	private PanelListingCommandes panelListingCmds;
	private PanelDetailCommande panelDetailCmd;

	public PanelPrincipal() {
		this.setLayout(null);
		
		this.panelListingCmds = new PanelListingCommandes();
		this.panelListingCmds.setBounds(0, 0, 330, 720);
		
		this.panelDetailCmd = new PanelDetailCommande();
		this.panelDetailCmd.setBounds(330, 0, 950, 720);
		
		
		this.setBackground(Color.green);
		this.add(this.panelListingCmds);
		this.add(this.panelDetailCmd);
	}
}
