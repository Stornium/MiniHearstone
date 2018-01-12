package fr.nicoPaul.miniHearstone.jeux.carte.guerrier;

import fr.nicoPaul.miniHearstone.jeux.Plateau;
import fr.nicoPaul.miniHearstone.jeux.carte.ASort;

/**
 * Tourbillon
 *
 * @author nicolas paul
 * @version 1
 * @since 1
 */
public class Tourbillon extends ASort {

    public Tourbillon() {
        super("Tourbillon", 1, "1 points de degats à TOUS les serviteurs");
    }

    @Override
    public void use(Plateau plateau) {
        plateau.getCartesOfHero(plateau.getJoueur1()).forEach(aServiteur -> {
            boolean dead = aServiteur.takeDamage(1);
            if (dead) {
                plateau.getCartesCible().remove(aServiteur);
            }
        });
        plateau.getCartesOfHero(plateau.getJoueur2()).forEach(aServiteur -> {
            boolean dead = aServiteur.takeDamage(1);
            if (dead) {
                plateau.getCartesCible().remove(aServiteur);
            }
        });
    }
}
