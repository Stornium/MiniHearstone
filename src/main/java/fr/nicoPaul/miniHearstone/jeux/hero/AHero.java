package fr.nicoPaul.miniHearstone.jeux.hero;

import fr.nicoPaul.miniHearstone.jeux.Plateau;
import fr.nicoPaul.miniHearstone.jeux.carte.ACarte;
import fr.nicoPaul.miniHearstone.jeux.carte.deck.ADeck;
import fr.nicoPaul.miniHearstone.jeux.carte.deck.DeckFactory;
import fr.nicoPaul.miniHearstone.jeux.observer.Observer;
import fr.nicoPaul.miniHearstone.jeux.observer.Sujet;

import java.util.ArrayList;
import java.util.List;

/**
 * hero
 *
 * @author nicolas paul
 * @version 1
 * @since 1
 */
public abstract class AHero implements Sujet {

    private String nom;
    private int vie;
    private int armure;
    private int mana;
    private ADeck ADeck;
    private List<ACarte> main;
    private String specialAction;
    private List<Observer> observers;

    public AHero(String nom, String specialAction, EType type) {
        this.nom = nom;
        this.vie = 30;
        this.armure = 0;
        this.mana = 0;
        this.ADeck = DeckFactory.factory(type);
        this.specialAction = specialAction;
        this.main = new ArrayList<>();
        this.observers = new ArrayList<>();
        notifierObserveur();
    }

    /**
     * prendre une carte du deck et la metre dans la main
     */
    public void deckToMain(){
        main.add(ADeck.getCart());
    }

    /**
     * l'action special
     *
     * @param plateau le plateau
     */
    public abstract void specialAction(Plateau plateau);

    /**
     * subir des dommage
     *
     * @param nb nombre de dommage
     */
    public void takeDamege(int nb){
        if(armure >= nb){
            armure-=nb;
        }else{
            nb-=armure;
            armure=0;
            vie-=nb;
        }

        notifierObserveur();
    }

    public void addArmure(int nb){
        armure+=nb;
    }

    public void supMana(int nb){
        mana-=nb;
    }

    public String getNom() {
        return nom;
    }

    public void addMana(){
        if(this.mana < 10) this.mana++;
    }

    public void addMain(List<ACarte> carte){
        this.main.addAll(carte);
    }

    public void dellMain(ACarte carte){
        this.main.remove(carte);
    }

    public ADeck getADeck() {
        return ADeck;
    }

    public int getVie() {
        return vie;
    }

    public int getArmure() {
        return armure;
    }

    public int getMana() {
        return mana;
    }

    public List<ACarte> getMain() {
        return main;
    }

    public String getSpecialAction() {
        return specialAction;
    }

    public void setVie(int vie) {
        this.vie = vie;

        notifierObserveur();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AHero{");
        sb.append("nom='").append(nom).append('\'');
        sb.append(", vie=").append(vie);
        sb.append(", armure=").append(armure);
        sb.append(", mana=").append(mana);
        sb.append(", ADeck=").append(ADeck);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void addObserveur(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void supObserveur(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifierObserveur() {
        observers.forEach(observer -> observer.actualiser(vie));
    }
}
