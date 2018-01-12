package fr.nicoPaul.miniHearstone.jeux.carte.deck;

import fr.nicoPaul.miniHearstone.jeux.carte.ACarte;
import fr.nicoPaul.miniHearstone.jeux.carte.paladin.BenedictionDePuissance;
import fr.nicoPaul.miniHearstone.jeux.carte.paladin.ChampionFrisselame;
import fr.nicoPaul.miniHearstone.jeux.carte.paladin.Consecration;

import java.util.Random;

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

    @Override
    public void addDeck() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int val = random.nextInt(8);
            try {
                ACarte aCarte = cartesPosible.get(val).newInstance();
                aCarte = aCarte.init();
                cartes.add(aCarte);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
