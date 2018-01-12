package fr.nicoPaul.miniHearstone.jeux.carte;

/**
 * @author nicolas paul
 * @since 1
 * @version 1
 */
abstract class ServiteurDecorator extends Serviteur{

    protected Serviteur serviteur;

    public ServiteurDecorator(String nom, int degats, int mana, int vie, Serviteur serviteur) {
        super(nom, degats, mana, vie);
        this.serviteur = serviteur;
    }
}
