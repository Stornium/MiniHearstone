package fr.nicoPaul.miniHearstone.jeux.carte.deck;

import fr.nicoPaul.miniHearstone.jeux.hero.EType;

/**
 * Factory deck
 * @author nicolas paul
 * @version 1
 * @since 1
 */
public abstract class DeckFactory {

    public static ADeck factory(EType type) {
        ADeck deck = null;
        if(type.equals(EType.MAGE)){
            deck = new MageDeck();
        }else if(type.equals(EType.GUERRIER)){
            deck = new GuerrierDeck();
        }else if(type.equals(EType.PALADIN)){
            deck = new PaladinDeck();
        }
        return deck;
    }
}
