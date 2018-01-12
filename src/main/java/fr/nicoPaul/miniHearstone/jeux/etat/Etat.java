package fr.nicoPaul.miniHearstone.jeux.etat;

import fr.nicoPaul.miniHearstone.jeux.hero.AHero;

/**
 * @author nicolas paul
 * @version 1
 * @since 1
 */
public interface Etat {

    AHero getCurentHero();

    AHero getNotCurentHero();

    void tour();
}
