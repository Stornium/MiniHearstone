package fr.nicoPaul.miniHearstone.jeux.carte.mage;

import fr.nicoPaul.miniHearstone.jeux.Plateau;
import fr.nicoPaul.miniHearstone.jeux.carte.ASort;

/**
 * Explosion des arcanes
 *
 * @author nicolas paul
 * @version 1
 * @since 1
 */
public class ExplosionDesArcanes extends ASort {

    public ExplosionDesArcanes() {
        super("Explosion des arcanes", 2, "inflige 1 point de degat à tous les serviteurs adverses");
    }

    @Override
    public void use(Plateau plateau) {
        plateau.getCartesOfHero(plateau.getHeroCible()).forEach(aServiteur -> aServiteur.takeDamage(1));
    }
}
