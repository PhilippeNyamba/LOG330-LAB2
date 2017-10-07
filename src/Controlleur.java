import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class Controlleur implements ActionListener {

    private Vue vue;
    private Modele modele;
    private Calculateur calculateur;
    private List<List<String>> donnees;
    private LecteurFichier lecteur;


    public Controlleur(Vue vue) {
        this.vue = vue;
        modele = vue.getModele();
        calculateur = new Calculateur();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "moyenne":
                double moyenne = calculateur.calculerMoyenne(donnees);
                vue.getResultMoyenne().setText("<html>La moyenne est : <br>" + moyenne);
                vue.getResultMoyenne().setVisible(true);
                break;
            case "variance":
                double variance = calculateur.calculerVariance(donnees);
                vue.getResultVariance().setText("<html>La variance est : <br>" + variance);
                vue.getResultVariance().setVisible(true);
                break;
            case "ecartType":
                double ecartType = calculateur.calculerEcartType(donnees);
                vue.getResultEcartType().setText("<html>L'écart-type est : <br>" + ecartType);
                vue.getResultEcartType().setVisible(true);
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
                    lecteur = new LecteurFichier(cheminFichier);
                    try {
                        lecteur.lireFichier();
                        donnees = lecteur.getDonnees();
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }
                    vue.getMoyenne().setEnabled(true);
                    vue.getVariance().setEnabled(true);
                    vue.getEcartType().setEnabled(true);
                    vue.getTableauDonnees().setText("<html>Liste des donnees: <br>" + donnees.toString());
                }
                break;
        }
    }

    public void setDonnees(List<List<String>> donnees) {
        this.donnees = donnees;
    }

    public Vue getVue() {
        return vue;
    }
}
