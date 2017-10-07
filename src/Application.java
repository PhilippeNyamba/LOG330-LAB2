public class Application {
    /**
     * Demarre l'application
     */
    public static void main(String[] args) {
        new Application();
    }

    public Application(){
        Modele modele = new Modele();
        Vue vue = new Vue(modele);
    }
}
