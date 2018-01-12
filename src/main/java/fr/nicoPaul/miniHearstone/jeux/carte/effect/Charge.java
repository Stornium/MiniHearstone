package fr.nicoPaul.miniHearstone.jeux.carte.effect;

import fr.nicoPaul.miniHearstone.jeux.Plateau;
import fr.nicoPaul.miniHearstone.jeux.carte.AServiteur;
import fr.nicoPaul.miniHearstone.jeux.carte.AServiteurDecorator;

/**
 * @author nicolas paul
 * @version 1
 * @since 1
 */
public class Charge extends AServiteurDecorator {

    public Charge(AServiteur aServiteur) {
        super("Charge", aServiteur);
    }

    @Override
    public void place(Plateau plateau) {
        plateau.addCartes(this);
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
