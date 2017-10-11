/**
 * @Auteur Philippe Nyamba
 * @Date 2017-10-09
 * Demarre l'application
 */
public class Application {

    public static void main(String[] args) {
        new Application();
    }

    /**
     * Lie le modele à la vue
     */
    public Application(){
        Modele modele = new Modele();
        new Vue(modele);
    }
}
