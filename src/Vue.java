import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class Vue extends JFrame{
    
    private Modele modele;
    private Controlleur controlleur;
    JPanel panneauPrincipal;
    JLabel resultMoyenne;
    JLabel resultVariance;
    JLabel resultEcartType;
    JLabel tableauDonnees;
    JButton moyenne;
    JButton variance;
    JButton ecartType;
    JButton importer;
    JPanel panneauDonneesResultats;

    public Vue(Modele modele) {
        this.modele = modele;
        controlleur = new Controlleur(this);
        initialiseComponnents();
        this.setSize(600, 400);
        this.setContentPane(panneauPrincipal);
        this.setTitle("JFrame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void initialiseComponnents() {
        panneauPrincipal = new JPanel();
        panneauPrincipal.setLayout(new GridLayout(2,1));

        JPanel panneauCommandes = new JPanel();

        JPanel panneauResultats = new JPanel();
        panneauResultats.setLayout(new GridLayout(1,3,30,50));

        JPanel panneauDonnees = new JPanel();

        panneauDonneesResultats = new JPanel();

        //Bouton importer fichier
        importer = new JButton("Importer CSV");
        importer.setPreferredSize(new Dimension(120,30));
        importer.addActionListener(controlleur);
        importer.setActionCommand("importer");
        importer.setAlignmentX(Component.CENTER_ALIGNMENT);
        panneauCommandes.add(importer);

        //Bouton calculer la moyenne
        moyenne = new JButton("Moyenne");
        moyenne.setPreferredSize(new Dimension(120,30));
        moyenne.addActionListener(controlleur);
        moyenne.setActionCommand("moyenne");
        moyenne.setAlignmentX(Component.CENTER_ALIGNMENT);
        moyenne.setEnabled(false);
        panneauCommandes.add(moyenne);

        //Bouton calculer la variance
        variance = new JButton("Variance");
        variance.setPreferredSize(new Dimension(120,30));
        variance.addActionListener(controlleur);
        variance.setActionCommand("variance");
        variance.setAlignmentX(Component.CENTER_ALIGNMENT);
        variance.setEnabled(false);
        panneauCommandes.add(variance);

        //Bouton calculer l'écart-type
        ecartType = new JButton("Ecart Type");
        ecartType.setPreferredSize(new Dimension(120,30));
        ecartType.addActionListener(controlleur);
        ecartType.setActionCommand("ecartType");
        ecartType.setAlignmentX(Component.CENTER_ALIGNMENT);
        ecartType.setEnabled(false);
        panneauCommandes.add(ecartType);

        resultMoyenne = new JLabel();
        resultMoyenne.setVisible(false);
        resultMoyenne.setHorizontalTextPosition(JLabel.CENTER);
        panneauResultats.add(resultMoyenne);

        resultVariance = new JLabel();
        resultVariance.setVisible(false);
        resultVariance.setHorizontalTextPosition(JLabel.CENTER);
        panneauResultats.add(resultVariance);

        resultEcartType = new JLabel();
        resultEcartType.setVisible(false);
        resultEcartType.setHorizontalTextPosition(JLabel.CENTER);
        panneauResultats.add(resultEcartType);

        tableauDonnees = new JLabel();
        panneauDonnees.add(tableauDonnees);

        panneauDonneesResultats.add(panneauDonnees);
        panneauDonneesResultats.add(panneauResultats);

        panneauPrincipal.add(panneauCommandes);
        panneauPrincipal.add(panneauDonneesResultats);
    }

    public Modele getModele() {
        return modele;
    }

    public JLabel getResultMoyenne() {
        return resultMoyenne;
    }

    public JLabel getResultVariance() {
        return resultVariance;
    }

    public JLabel getResultEcartType() {
        return resultEcartType;
    }

    public JLabel getTableauDonnees() {
        return tableauDonnees;
    }

    public JButton getMoyenne() {
        return moyenne;
    }

    public JButton getVariance() {
        return variance;
    }

    public JButton getEcartType() {
        return ecartType;
    }

    public JPanel getPanneauDonneesResultats() {
        return panneauDonneesResultats;
    }
}
