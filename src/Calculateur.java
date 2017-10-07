import java.util.List;

public class Calculateur {
    /**
     * Calcule la variance d'une liste de données
     */
    public double calculerVariance(List<List<String>> listes){
        double variance = 0.0;
        int nombreDeValeurs=0;
        double moyenne = calculerMoyenne(listes);
        for(List<String> liste : listes) {
            for (String valeur : liste) {
                variance += Math.pow((Double.parseDouble(valeur) - moyenne), 2);
                nombreDeValeurs++;
            }
        }
        return variance / (nombreDeValeurs - 1);
    }

    /**
     * Calcule la variance d'une liste de données
     * @param liste
     */
    public double calculerMoyenne(List<List<String>> listes){
        double moyenne = 0.0;
        int nombreDeValeurs=0;
        for(List<String> liste : listes) {
            for (String valeur: liste) {
                moyenne += Double.parseDouble(valeur);
                nombreDeValeurs++;
        }}
        return moyenne / nombreDeValeurs;
    }

    /**
     * Calcule la variance d'une liste de données
     * @param listes
     */
    public double calculerEcartType(List<List<String>> listes){
        return Math.sqrt(calculerVariance(listes));
    }
}
