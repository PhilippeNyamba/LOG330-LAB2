import java.util.List;

/**
 * @Auteur Philippe Nyamba
 * @Date 2017-10-09
 */
public interface Calculateur {
    /**
     * Calcule la corrélation à partir d'une liste de couples de valeurs
     * @param listes liste de couples de valeurs
     * @return le paramètre permettant de définir la corrélation
     */
    public double calculer(List<List<String>> listes);
}
