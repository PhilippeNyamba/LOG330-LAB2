import javax.swing.*;
import java.awt.*;

/**
 * @Auteur Philippe Nyamba
 * @Date 2017-10-09
 * Crée et initialise la l'interface utilisateur
 */
public class Vue extends JFrame{
    
    private Modele modele;
    private Controlleur controlleur;
    JPanel panneauPrincipal;
    JLabel resultCorrelation;
    JLabel tableauDonnees;
    JButton correlation;
    JButton importer;
    JPanel panneauDonneesResultats;

    public Vue(Modele modele) {
        this.modele = modele;
        controlleur = new Controlleur(this);
        initialiseComponnents();
        this.setSize(800, 400);
        this.setContentPane(panneauPrincipal);
        this.setTitle("JFrame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    /**
     * Initialise les composant de la fenêtre
     */
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

        //Bouton calculer la correlation
        correlation = new JButton("Correlation");
        correlation.setPreferredSize(new Dimension(120,30));
        correlation.addActionListener(controlleur);
        correlation.setActionCommand("correlation");
        correlation.setAlignmentX(Component.CENTER_ALIGNMENT);
        correlation.setEnabled(false);
        panneauCommandes.add(correlation);

        resultCorrelation = new JLabel();
        resultCorrelation.setVisible(false);
        resultCorrelation.setHorizontalTextPosition(JLabel.CENTER);
        panneauResultats.add(resultCorrelation);

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

    public JLabel getResultCorrelation() {
        return resultCorrelation;
    }

    public JLabel getTableauDonnees() {
        return tableauDonnees;
    }

    public JButton getCorrelation() {
        return correlation;
    }
}
