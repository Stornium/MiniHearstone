package fr.nicoPaul.miniHearstone.jeux.carte.effect;

import fr.nicoPaul.miniHearstone.jeux.carte.AServiteur;
import fr.nicoPaul.miniHearstone.jeux.carte.AServiteurDecorator;

/**
 * @author nicolas paul
 * @since 1
 * @version 1
 */
public class Provocation extends AServiteurDecorator {

    public Provocation(AServiteur aServiteur) {
        super("Provocation", aServiteur);
    }

    @Override
    public boolean isEffet(Class<? extends AServiteurDecorator> aClass) {
        if(this.getClass().equals(aClass)){
            return true;
        }else{
            return aServiteur.isEffet(aClass);
        }
    }
}
