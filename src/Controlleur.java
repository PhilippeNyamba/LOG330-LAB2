import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * @Auteur Philippe Nyamba
 * @Date 2017-10-09
 * Le controleur de l'application
 */
public class Controlleur implements ActionListener {

    /**
     * La vue avec laquelle interagir
     */
    private Vue vue;
    /**
     * Le modele à mettre à jour
     */
    private Modele modele;
    /**
     * Le calculateur à utiliser pour effectuer les opérations
     */
    private Calculateur calculateurCorrelation;
    /**
     * Le lecteur à utiliser pour acquerir les données consignées dans un fichier
     */
    private LecteurFichier lecteur;


    public Controlleur(Vue vue) {
        this.vue = vue;
        modele = vue.getModele();
        calculateurCorrelation = new CalculateurCorrelation();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "correlation":
                double correlation = calculateurCorrelation.calculer(modele.getDonnees());
                String interpretation = interpreterCorrelation(correlation);
                vue.getResultCorrelation().setText("<html>La correlation est : <br>" + correlation + "<html><br><br>Valeur nominale du lien : <br>" + interpretation);
                vue.getResultCorrelation().setVisible(true);
                break;
            case "importer":
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "CSV", "csv");
                fileChooser.setFileFilter(filter);
                int ouvert = fileChooser.showOpenDialog(vue);
                if(ouvert == JFileChooser.APPROVE_OPTION) {
                    File selection = fileChooser.getSelectedFile();

                    String cheminFichier =  selection.getAbsolutePath();
                    lecteur = new LecteurFichierCSV(cheminFichier);
                    try {
                        lecteur.lireFichier();
                        modele.setDonnees(lecteur.getDonnees());
                        vue.getTableauDonnees().setText("<html>Liste des donnees: <br>" + modele.getDonnees().toString());
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }
                    vue.getCorrelation().setEnabled(true);
                }
                break;
        }
    }

    /**
     * Renvoie la chaine de caractère donnant la nature de la corrélation
     * @param correlation le paramétre de corrélation à interpreter
     * @return La nature de la corrélation
     */
    private String interpreterCorrelation(double correlation) {
        double valeur = Math.abs(correlation);
        if(valeur >= 0.0 && valeur < 0.2){
            return "Nulle à faible";
        }else if(valeur >= 0.2 && valeur < 0.4){
            return "Faible à moyenne";
        }else if(valeur >= 0.4 && valeur < 0.7){
            return "Moyenne à forte";
        }else if(valeur >= 0.7 && valeur < 0.9){
            return "Forte à très forte";
        }else if(valeur >= 0.9 && valeur <= 1.0){
            return "Très forte à parfaite";
        }else{
            return null;
        }
    }
}
