package fr.nicoPaul.miniHearstone.jeux.carte.guerrier;

import fr.nicoPaul.miniHearstone.jeux.carte.ACarte;
import fr.nicoPaul.miniHearstone.jeux.carte.AServiteur;
import fr.nicoPaul.miniHearstone.jeux.carte.effect.Provocation;

/**
 * @author nicolas paul
 * @since 1
 * @version 1
 */
public class AvocatCommisDoffice extends AServiteur {

    public AvocatCommisDoffice() {
        super("Avocat commis d’office", 2, 0, 7);
    }

    @Override
    public ACarte init() {
        return new Provocation(this);
    }
}
