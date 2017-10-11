import java.util.List;

/**
 * @Auteur Philippe Nyamba
 * @Date 2017-10-09
 * Demarre l'application
 */
public class Modele {

    /**
     * Les données à traiter
     */
    private List<List<String>> donnees;

    public List<List<String>> getDonnees() {
        return donnees;
    }

    public void setDonnees(List<List<String>> donneesLues) {
        this.donnees = donneesLues;
    }
}
