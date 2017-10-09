import java.io.FileNotFoundException;
import java.util.List;

/**
 * @Auteur Philippe Nyamba
 * @Date 2017-10-09
 * Demarre l'application
 */
public interface LecteurFichier {
    /**
     * Effectue la lecture des données condignées dans un fichier et les stocke dans un attribut de classe
     * @throws FileNotFoundException
     */
    public void lireFichier() throws FileNotFoundException;

    /**
     * Renvoie les données lues
     * Doit être appelée apres lecture du fichier
     * @return
     */
    public List<List<String>> getDonnees();
}
