import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Auteur Philippe Nyamba
 * @Date 2017-10-09
 * Demarre l'application
 */

public class LecteurFichierCSV implements LecteurFichier{

    /**
     * Le chemin du fichier CSV
     */
    private final String chemin;
    /**
     * Les données lues
     */
    private List<List<String>> donneesLues;

    public LecteurFichierCSV(String cheminFichier){
        donneesLues = new ArrayList<>();
        chemin = cheminFichier;
    }

    /**
     * Remplit une liste à partir des donnees d'un fichier csv
     * @throws FileNotFoundException
     * @source  https://stackoverflow.com/questions/40074840/reading-a-csv-file-into-a-array
     */
    public void lireFichier() throws FileNotFoundException {
        {

            File fichier = new File(chemin);
            Scanner inputStream = new Scanner(fichier);
            while(inputStream.hasNext()){
                String ligne = inputStream.next();
                String[] valeurs = ligne.split(",");
                donneesLues.add(Arrays.asList(valeurs));
            }
        }
    }

        public List<List<String>> getDonnees() {
        return donneesLues;
    }
}
