package fr.nicoPaul.miniHearstone.jeux.carte;

import fr.nicoPaul.miniHearstone.jeux.Plateau;

/**
 * @author nicolas paul
 * @since 1
 * @version 1
 */
public abstract class ACarte {

    protected String nom;
    protected int mana;

    public ACarte(String nom, int mana) {
        this.nom = nom;
        this.mana = mana;
    }

    public ACarte init(){
        return this;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getMana() {
        return mana;
    }

    public abstract void place(Plateau plateau);

    public abstract void use(Plateau plateau);


}
