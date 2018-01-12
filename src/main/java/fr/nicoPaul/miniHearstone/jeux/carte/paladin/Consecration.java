package fr.nicoPaul.miniHearstone.jeux.carte.paladin;

import fr.nicoPaul.miniHearstone.jeux.Plateau;
import fr.nicoPaul.miniHearstone.jeux.carte.ASort;

/**
 * @author nicolas paul
 * @since 1
 * @version 1
 */
public class Consecration extends ASort {

    public Consecration() {
        super("Consécration", 4, "2 points de dégâts à tous les adversaires.");
    }

    @Override
    public void use(Plateau plateau) {
        plateau.getCartesOfHero(plateau.getHeroCible()).forEach(aServiteur -> aServiteur.takeDamage(2));
    }
}
