package fr.nicoPaul.miniHearstone.jeux.carte.deck;

import fr.nicoPaul.miniHearstone.jeux.carte.guerrier.AvocatCommisDoffice;
import fr.nicoPaul.miniHearstone.jeux.carte.guerrier.MaitriseDuBlocage;
import fr.nicoPaul.miniHearstone.jeux.carte.guerrier.Tourbillon;

/**
 * Deck Guerrier
 *
 * @author nicolas paul
 * @version 1
 * @since 1
 */
class GuerrierDeck extends ADeck {

    GuerrierDeck() {
        cartesPosible.add(Tourbillon.class);
        cartesPosible.add(AvocatCommisDoffice.class);
        cartesPosible.add(MaitriseDuBlocage.class);

        addDeck();
    }
}
