package model;

public class JoueurIa extends Joueur {

    public JoueurIa(String nom, Types.TypePion typePion) {
        super(nom, typePion);
    }

    @Override
    public Coup choisirCoup(Game game) {
        return null;
    }
}