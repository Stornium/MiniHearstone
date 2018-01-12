package fr.nicoPaul.miniHearstone.jeux.hero;

import fr.nicoPaul.miniHearstone.jeux.Plateau;

/**
 * @author nicolas paul
 * @version 1
 * @since 1
 */
public class Guerrier extends AHero {

    public Guerrier(String nom) {
        super(nom, "Armure", EType.GUERRIER);
    }

    @Override
    public void specialAction(Plateau plateau) {
        addArmure(2);
    }
}
