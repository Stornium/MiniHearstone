package fr.nicoPaul.miniHearstone.jeux.carte.deck;

import fr.nicoPaul.miniHearstone.jeux.carte.mage.ExplosionDesArcanes;
import fr.nicoPaul.miniHearstone.jeux.carte.mage.ImageMiroir;
import fr.nicoPaul.miniHearstone.jeux.carte.mage.Metamorphose;

/**
 * Deck Mage
 *
 * @author nicolas paul
 * @version 1
 * @since 1
 */
class MageDeck extends ADeck {
    public MageDeck() {
        cartesPosible.add(ImageMiroir.class);
        cartesPosible.add(ExplosionDesArcanes.class);
        cartesPosible.add(Metamorphose.class);

        addDeck();
    }
}
