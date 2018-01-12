package fr.nicoPaul.miniHearstone.jeux.carte.all;

import fr.nicoPaul.miniHearstone.jeux.carte.ACarte;
import fr.nicoPaul.miniHearstone.jeux.carte.AServiteur;
import fr.nicoPaul.miniHearstone.jeux.carte.effect.Charge;

/**
 * Chevaucheur de loup
 * @author nicolas paul
 * @version 1
 * @since 1
 */
public class ChevaucheurDeLoup extends AServiteur {

    public ChevaucheurDeLoup() {
        super("Chevaucheur de loup", 3, 3, 1);
    }

    @Override
    public ACarte init() {
        return new Charge(this);
    }
}
