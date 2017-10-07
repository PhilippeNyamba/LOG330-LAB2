import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Source: https://stackoverflow.com/questions/40074840/reading-a-csv-file-into-a-array
 */
public class LecteurFichier {

    private List<List<String>> donneesLues;
    File fichier;
    Scanner inputStream;

    public LecteurFichier(String chemin){
        donneesLues = new ArrayList<>();
        fichier = new File(chemin);
    }

    /**
     * Remplit une liste à partir des donnees d'un fichier csv
     * @throws FileNotFoundException
     */
    public void lireFichier() throws FileNotFoundException {
        {
            inputStream = new Scanner(fichier);
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
