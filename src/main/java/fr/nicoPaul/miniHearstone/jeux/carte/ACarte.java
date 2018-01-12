package fr.nicoPaul.miniHearstone.jeux.carte;

/**
 * @author nicolas paul
 * @since 1
 * @version 1
 */
public abstract class ACarte {

    protected String nom;
    protected int degats;
    protected int mana;

    public ACarte(String nom, int degats, int mana) {
        this.nom = nom;
        this.degats = degats;
        this.mana = mana;
    }

    public String getNom() {
        return nom;
    }

    public abstract void use();

    public int getDegats() {
        return degats;
    }

    public int getMana() {
        return mana;
    }
}
