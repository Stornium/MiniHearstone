package fr.nicoPaul.miniHearstone.jeux.carte.all;

import fr.nicoPaul.miniHearstone.jeux.Plateau;
import fr.nicoPaul.miniHearstone.jeux.carte.AServiteur;

/**
 * Chef de raid
 * @author nicolas paul
 * @since 1
 * @version 1
 */
public class ChefDeRaid extends AServiteur {

    private Plateau plateau;

    public ChefDeRaid() {
        super("Chef de raid", 3, 2, 2);
    }

    @Override
    public void place(Plateau plateau) {
        super.place(plateau);
        this.plateau=plateau;
        plateau.getCartesOfCurentHero().forEach(aServiteur -> aServiteur.addBoostDegat(1));
    }

    @Override
    public void dead() {
        plateau.getCartesOfCurentHero().forEach(aServiteur -> aServiteur.supBoostDegat(1));
    }
}
