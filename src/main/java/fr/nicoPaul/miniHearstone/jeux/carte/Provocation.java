package fr.nicoPaul.miniHearstone.jeux.carte;

/**
 * @author nicolas paul
 * @since 1
 * @version 1
 */
public class Provocation extends ServiteurDecorator {
    public Provocation(Serviteur serviteur) {
        super("Provocation", 0, 0, 0, serviteur);
    }
}
