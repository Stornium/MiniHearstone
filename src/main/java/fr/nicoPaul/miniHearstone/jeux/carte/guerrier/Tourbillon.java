package fr.nicoPaul.miniHearstone.jeux.carte.guerrier;

import fr.nicoPaul.miniHearstone.jeux.Plateau;
import fr.nicoPaul.miniHearstone.jeux.carte.ASort;

/**
 * @author nicolas paul
 * @since 1
 * @version 1
 */
public class Tourbillon extends ASort {

    public Tourbillon() {
        super("Tourbillon", 1, "1 points de d́egâts à TOUS les serviteurs");
    }

    @Override
    public void use(Plateau plateau) {
        plateau.getCartesOfHero(plateau.getJoueur1()).forEach(aServiteur -> aServiteur.takeDamage(1));
        plateau.getCartesOfHero(plateau.getJoueur2()).forEach(aServiteur -> aServiteur.takeDamage(1));
    }
}
