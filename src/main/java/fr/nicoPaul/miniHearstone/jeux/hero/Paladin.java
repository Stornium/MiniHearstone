package fr.nicoPaul.miniHearstone.jeux.hero;

import fr.nicoPaul.miniHearstone.jeux.Plateau;

/**
 * @author nicolas paul
 * @version 1
 * @since 1
 */
public class Paladin extends AHero {

    public Paladin(String nom) {
        super(nom, "Renfort", EType.PALADIN);
    }

    public void specialAction() {
        //todo
    }

    @Override
    public void specialAction(Plateau plateau) {

    }
}
