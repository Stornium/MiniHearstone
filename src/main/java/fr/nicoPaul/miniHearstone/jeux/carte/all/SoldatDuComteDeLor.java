package fr.nicoPaul.miniHearstone.jeux.carte.all;

import fr.nicoPaul.miniHearstone.jeux.carte.ACarte;
import fr.nicoPaul.miniHearstone.jeux.carte.AServiteur;
import fr.nicoPaul.miniHearstone.jeux.carte.effect.Provocation;

/**
 * @author nicolas paul
 * @since 1
 * @version 1
 */
public class SoldatDuComteDeLor extends AServiteur {
    public SoldatDuComteDeLor() {
        super("Soldat du comt́e de l’or", 1, 1, 2);
    }

    @Override
    public ACarte init() {
        return new Provocation(this);
    }
}
