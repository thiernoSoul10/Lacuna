package view;

import global.Configuration;
import model.Coordonnees;
import model.Jeu;
import model.Cercle;
public class InterfaceTextuelle {
    public void lancer() {
        Configuration.debugeur("Interface textuelle lancée !\n");

        Jeu jeu = new Jeu(50, 30, new Cercle(new Coordonnees(25, 15), 15), 12);
        jeu.afficher();

        jeu.placePion(jeu.getPions().get(0), new Coordonnees(5, 5));
        jeu.placePion(jeu.getPions().get(1), new Coordonnees(10, 20));
        jeu.afficher();
    }
}
