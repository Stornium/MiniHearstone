package fr.nicoPaul.miniHearstone.jeux.carte.deck;

import fr.nicoPaul.miniHearstone.jeux.carte.ACarte;
import fr.nicoPaul.miniHearstone.jeux.carte.all.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Representation des decks
 *
 * @author nicolas paul
 * @version 1
 * @since 1
 */
public abstract class ADeck {
    /**
     * list des cart posible
     */
    protected List<Class<? extends ACarte>> cartesPosible;
    /**
     * list des cart actuelle du deck
     */
    protected List<ACarte> cartes;

    public ADeck() {
        cartesPosible = new ArrayList<>();
        cartes = new ArrayList<>();

        cartesPosible.add(SanglierBrocheroc.class);
        cartesPosible.add(SoldatDuComteDeLor.class);
        cartesPosible.add(ChevaucheurDeLoup.class);
        cartesPosible.add(ChefDeRaid.class);
        cartesPosible.add(YetiNoroit.class);
    }

    public List<ACarte> getCartes() {
        return cartes;
    }

    /**
     * ajout de 10 carte dans le deck
     */
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

    /**
     * predre un nombre de cartse du deck
     *
     * @param nb nombre de cartes voulue
     *
     * @return une liste de ACarte
     */
    public List<ACarte> getCartes(int nb) {
        ArrayList<ACarte> res = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < nb; i++) {
            int val = random.nextInt(cartes.size());
            res.add(cartes.remove(val));
            chekDeck();
        }
        return res;
    }

    /**
     * predre une carte du deck
     *
     * @return une ACarte
     */
    public ACarte getCart() {
        ACarte res = null;

        Random random = new Random();
        int val = random.nextInt(cartes.size());
        res = cartes.remove(val);
        chekDeck();
        return res;
    }

    /**
     * si le deck a moin de 5 cartes on en recréer 10 autre
     */
    public void chekDeck() {
        if (cartes.size() < 5) {
            addDeck();
        }
    }
}
