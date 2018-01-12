package fr.nicoPaul.miniHearstone.jeux.hero;

import fr.nicoPaul.miniHearstone.jeux.carte.ACarte;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nicolas paul
 * @version 1
 * @since 1
 */
public abstract class AHero {

    private String nom;
    private int vie;
    private int armure;
    private int mana;
    private List<ACarte> deck;
    private String specialAction;

    public AHero(String nom, String specialAction) {
        this.nom = nom;
        this.vie = 30;
        this.armure = 0;
        this.mana = 0;
        this.deck = new ArrayList<ACarte>();//TODO Builder
        this.specialAction = specialAction;
    }

    public abstract void specialAction();

    public String getNom() {
        return nom;
    }

    public void addMana(){
        this.mana++;
    }

    public List<ACarte> getDeck() {
        return deck;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AHero{");
        sb.append("nom='").append(nom).append('\'');
        sb.append(", vie=").append(vie);
        sb.append(", armure=").append(armure);
        sb.append(", mana=").append(mana);
        sb.append(", deck=").append(deck);
        sb.append('}');
        return sb.toString();
    }
}
