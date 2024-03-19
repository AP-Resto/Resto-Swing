package fr.test.panels.listeners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ChangerFondEnFonctionDuSurvol implements MouseListener {
    private boolean estSurvolee = false;

    @Override
    public void mouseClicked(MouseEvent e) {

        System.out.println("ChangerFondEnFonctionDuSurvol.mouseClicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("ChangerFondEnFonctionDuSurvol.mousePressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("ChangerFondEnFonctionDuSurvol.mouseReleased");

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        ((JComponent)e.getSource()).setBackground(new Color(0xFF9A9A9A));
        ((JComponent)e.getSource()).revalidate();

    }

    @Override
    public void mouseExited(MouseEvent e) {
        ((JComponent)e.getSource()).setBackground(new Color(0xFFFFFFFF));
        ((JComponent)e.getSource()).revalidate();
    }
}
