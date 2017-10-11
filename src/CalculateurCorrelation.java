import java.util.List;

/**
 * @Auteur Philippe Nyamba
 * @Date 2017-10-09
 * Effectue le calcul de la corréaltion
 */
public class CalculateurCorrelation implements Calculateur{

    @Override
    public double calculer(List<List<String>> listes) {
        double numerateur = 0.0;
        double denominateur = 0.0;
        double sommeX = 0.0;
        double sommeY = 0.0;
        double sommeXX = 0.0;
        double sommeYY = 0.0;
        List<String> couple;
        int taille = listes.size();
        for(int i = 0; i < taille; i++){
            sommeX += Double.parseDouble((listes.get(i)).get(0));
        }
        for(int i = 0; i < taille; i++){
            sommeY += Double.parseDouble((listes.get(i)).get(1));
        }
        for(int i = 0; i < taille; i++){
            couple = listes.get(i);
            numerateur += Double.parseDouble(couple.get(0))*Double.parseDouble(couple.get(1));
        }
        numerateur *= taille;
        numerateur -= sommeX*sommeY;
        for(int i = 0; i < taille; i++){
            sommeXX += Math.pow(Double.parseDouble((listes.get(i)).get(0)), 2);
        }
        for(int i = 0; i < taille; i++){
            sommeYY += Math.pow(Double.parseDouble((listes.get(i)).get(1)), 2);
        }
        denominateur = Math.sqrt((taille*sommeXX - Math.pow(sommeX, 2)) * (taille*sommeYY - Math.pow(sommeY, 2)));
        return numerateur/denominateur;
    }
}
