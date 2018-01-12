package fr.nicoPaul.miniHearstone.jeux.carte;

import fr.nicoPaul.miniHearstone.jeux.Plateau;

/**
 * carte
 *
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

    /**
     * quand la carte est placer
     * @param plateau le plateau
     */
    public abstract void place(Plateau plateau);
    
    /**
     * quand la carte est utiliser
     * @param plateau le plateau
     */
    public abstract void use(Plateau plateau);


}
