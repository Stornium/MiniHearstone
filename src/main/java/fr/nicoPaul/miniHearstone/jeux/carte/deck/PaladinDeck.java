package fr.nicoPaul.miniHearstone.jeux.carte.deck;

import fr.nicoPaul.miniHearstone.jeux.carte.paladin.BenedictionDePuissance;
import fr.nicoPaul.miniHearstone.jeux.carte.paladin.ChampionFrisselame;
import fr.nicoPaul.miniHearstone.jeux.carte.paladin.Consecration;

/**
 * @author nicolas paul
 * @version 1
 * @since 1
 */
class PaladinDeck extends ADeck {

    PaladinDeck() {
        cartesPosible.add(ChampionFrisselame.class);
        cartesPosible.add(BenedictionDePuissance.class);
        cartesPosible.add(Consecration.class);

        addDeck();
    }
}
