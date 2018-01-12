package fr.nicoPaul.miniHearstone.jeux.carte.guerrier;

import fr.nicoPaul.miniHearstone.jeux.Plateau;
import fr.nicoPaul.miniHearstone.jeux.carte.ASort;

/**
 * @author nicolas paul
 * @since 1
 * @version 1
 */
public class MaitriseDuBlocage extends ASort {

    public MaitriseDuBlocage() {
        super("Maitrise du blocage", 3, "+5 d’armure ET pioche une carte");
    }

    @Override
    public void use(Plateau plateau) {

    }
}
