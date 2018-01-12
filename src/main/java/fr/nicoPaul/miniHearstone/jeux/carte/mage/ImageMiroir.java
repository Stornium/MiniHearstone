package fr.nicoPaul.miniHearstone.jeux.carte.mage;

import fr.nicoPaul.miniHearstone.jeux.Plateau;
import fr.nicoPaul.miniHearstone.jeux.carte.ASort;
import fr.nicoPaul.miniHearstone.jeux.carte.effect.Provocation;

/**
 * @author nicolas paul
 * @since 1
 * @version 1
 */
public class ImageMiroir extends ASort {

    public ImageMiroir() {
        super("Image miroir", 1, "invoque deux serviteurs 0/2 avec provocation");
    }

    @Override
    public void use(Plateau plateau) {
        plateau.addCartesAtente(new Provocation(new Serviteurs()));
        plateau.addCartesAtente(new Provocation(new Serviteurs()));
    }
}
