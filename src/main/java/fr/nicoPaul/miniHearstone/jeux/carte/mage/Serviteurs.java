package fr.nicoPaul.miniHearstone.jeux.carte.mage;

import fr.nicoPaul.miniHearstone.jeux.carte.ACarte;
import fr.nicoPaul.miniHearstone.jeux.carte.AServiteur;
import fr.nicoPaul.miniHearstone.jeux.carte.effect.Provocation;

/**
 * Serviteurs
 *
 * @author nicolas paul
 * @version 1
 * @since 1
 */
public class Serviteurs extends AServiteur {

    public Serviteurs() {
        super("Serviteurs", 0, 0, 2);
    }

    @Override
    public ACarte init() {
        return new Provocation(this);
    }
}
