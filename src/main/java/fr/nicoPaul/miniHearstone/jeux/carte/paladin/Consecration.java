package fr.nicoPaul.miniHearstone.jeux.carte.paladin;

import fr.nicoPaul.miniHearstone.jeux.Plateau;
import fr.nicoPaul.miniHearstone.jeux.carte.ASort;

/**
 * Consécration
 *
 * @author nicolas paul
 * @version 1
 * @since 1
 */
public class Consecration extends ASort {

    public Consecration() {
        super("Consécration", 4, "2 points de degats à tous les adversaires.");
    }

    @Override
    public void use(Plateau plateau) {
        plateau.getCartesOfHero(plateau.getHeroCible()).forEach(aServiteur -> aServiteur.takeDamage(2));
    }
}
