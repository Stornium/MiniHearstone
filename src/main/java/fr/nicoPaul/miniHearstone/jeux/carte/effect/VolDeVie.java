package fr.nicoPaul.miniHearstone.jeux.carte.effect;

import fr.nicoPaul.miniHearstone.jeux.Plateau;
import fr.nicoPaul.miniHearstone.jeux.carte.AServiteur;
import fr.nicoPaul.miniHearstone.jeux.carte.AServiteurDecorator;
import fr.nicoPaul.miniHearstone.jeux.hero.AHero;

/**
 * @author nicolas paul
 * @version 1
 * @since 1
 */
public class VolDeVie extends AServiteurDecorator {

    public VolDeVie(AServiteur aServiteur) {
        super("VolDeVie", aServiteur);
    }

    @Override
    public void use(Plateau plateau) {
        aServiteur.use(plateau);
        AHero heroCurent = plateau.getHeroCurent();
        int vie = heroCurent.getVie();
        vie+=getDegats();
        if (vie>30) vie = 30;
        heroCurent.setVie(vie);
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
