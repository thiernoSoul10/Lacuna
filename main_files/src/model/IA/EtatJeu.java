package model.IA;

// Copie l'état du plateau pour l'algo minimax


public class EtatJeu {

    // Fleurs encore sur le plateau
    public List<Fleur> fleursRestantes;

    // Pions déjà placés sur le plateau
    public List<Pion> pions;

    // Fleurs collectées par chaque joueur
    public List<Fleur>[] fleursParJoueur;

    // Index du joueur courant ( 0 ou 1 )
    public int joueurCourant;

    /// CONSTRUCTOR ////////////////
    public EtatJeu(List<Fleur> fleursRestantes, List<Pion> pions, List<Fleur>[] fleursParJoueur, int joueurCourant) {

        this.fleursRestantes = fleursRestantes;
        this.pions = pions;
        this.fleursParJoueur = fleursParJoueur;
        this.joueurCourant = joueurCourant;
    }

    ////////// Les méthodes get////////
    public List<Fleur> getFleursRestantes(){
        return fleursRestantes;
    }

    public List<Pion> getPions(){
        return pions;
    }

    public List<Fleur>[] getFleursParJoueur(){
        return fleursParJoueur;
    }
    
    public  int getJoueurCourant(){
        return joueurCourant;
    }

    // LES SETTERS ///////
    public void setFleursRestantes(List<Fleur> fleursRestantes) {
        this.fleursRestantes = fleursRestantes;
    }

    public void setPions(List<Pion> pions) {
        this.pions = pions;
    }

    public void setFleursParJoueur(List<Fleur>[] fleursParJoueur) {
        this.fleursParJoueur = fleursParJoueur;
    }

    public void setJoueurCourant(int joueurCourant) {
        this.joueurCourant = joueurCourant;
    }



}