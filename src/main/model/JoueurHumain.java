package model;

public class JoueurHumain extends Joueur {

    public JoueurHumain(String nom, Types.TypePion typePion) {
        super(nom, typePion);
    }

    @Override
    public Coup choisirCoup(Game game) {
        return null;
    }
}