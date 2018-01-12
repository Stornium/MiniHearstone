package fr.nicoPaul.miniHearstone.jeux.carte.mage;

import fr.nicoPaul.miniHearstone.jeux.Plateau;
import fr.nicoPaul.miniHearstone.jeux.carte.ASort;

/**
 * @author nicolas paul
 * @since 1
 * @version 1
 */
public class ExplosionDesArcanes extends ASort {

    public ExplosionDesArcanes() {
        super("Explosion des arcanes", 2, "inflige 1 point de d ́egˆats `a tous les serviteurs adverses");
    }

    @Override
    public void use(Plateau plateau) {

    }
}
