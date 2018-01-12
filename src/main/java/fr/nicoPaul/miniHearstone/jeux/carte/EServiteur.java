package fr.nicoPaul.miniHearstone.jeux.carte;

import fr.nicoPaul.miniHearstone.jeux.hero.AHero;
import fr.nicoPaul.miniHearstone.jeux.hero.Guerrier;
import fr.nicoPaul.miniHearstone.jeux.hero.Paladin;

/**
 * @author nicolas paul
 * @since 1
 * @version 1
 */
public enum EServiteur {
    Sanglier_brocheroc("Sanglier_brocheroc", 1, 1, 1, AHero.class, null),
    Soldat_du_comte_de_lor("Soldat du comt́e-de-l’or", 1, 1, 2, AHero.class, null),
    Chevaucheur_de_loup("Chevaucheur de loup", 3, 3, 1, AHero.class, null),
    Chef_de_raid("Chef de raid", 3, 2, 2, AHero.class, null),
    Yeti_noroit("Yéti noroit", 4, 4, 5, AHero.class, null),
    Champion_frisselame("Champion frisselame", 4, 3, 2, Paladin.class, null),
    Avocat_commis_doffice("Avocat commis d’office", 2, 0, 7, Guerrier.class, null),
    recrue_de_la_Main_dargen("recrue de la Main d’argen", 0, 1, 1, null, null);

    EServiteur(String nom, int mana, int degat, int vie, Class<? extends AHero> hero, Class<? extends ServiteurDecorator> effect) {

    }
}
