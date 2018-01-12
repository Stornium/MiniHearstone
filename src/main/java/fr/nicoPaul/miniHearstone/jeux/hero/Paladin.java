package fr.nicoPaul.miniHearstone.jeux.hero;

import fr.nicoPaul.miniHearstone.jeux.Plateau;
import fr.nicoPaul.miniHearstone.jeux.carte.paladin.RecrueDeLaMainDargent;

/**
 * @author nicolas paul
 * @version 1
 * @since 1
 */
public class Paladin extends AHero {

    public Paladin(String nom) {
        super(nom, "Renfort", EType.PALADIN);
    }

    @Override
    public void specialAction(Plateau plateau) {
        plateau.addCartesAtente(new RecrueDeLaMainDargent());
    }
}
