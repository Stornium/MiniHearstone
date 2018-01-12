package fr.nicoPaul.miniHearstone.jeux.carte.effect;

import fr.nicoPaul.miniHearstone.jeux.carte.AServiteur;
import fr.nicoPaul.miniHearstone.jeux.carte.AServiteurDecorator;

/**
 * effet de cart
 *
 * @author nicolas paul
 * @version 1
 * @since 1
 */
public class Provocation extends AServiteurDecorator {

    public Provocation(AServiteur aServiteur) {
        super("Provocation", aServiteur);
    }

    @Override
    public boolean isEffet(Class<? extends AServiteurDecorator> aClass) {
        if (this.getClass().equals(aClass)) {
            return true;
        } else {
            return aServiteur.isEffet(aClass);
        }
    }
}
