package fr.nicoPaul.miniHearstone.jeux.etat;

import fr.nicoPaul.miniHearstone.jeux.hero.AHero;

/**
 * @author nicolas paul
 * @since 1
 * @version 1
 */
public interface Etat {

    AHero getCurentHero();
    void tour();
}
