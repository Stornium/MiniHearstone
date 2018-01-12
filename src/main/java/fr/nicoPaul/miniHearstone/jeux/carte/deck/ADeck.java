package fr.nicoPaul.miniHearstone.jeux.carte.deck;

import fr.nicoPaul.miniHearstone.jeux.carte.ACarte;
import fr.nicoPaul.miniHearstone.jeux.carte.all.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author nicolas paul
 * @version 1
 * @since 1
 */
public abstract class ADeck {

    protected List<Class<? extends ACarte>> cartesPosible;
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

    public abstract void addDeck();

    public List<ACarte> getCartes(int nb){
        ArrayList<ACarte> res = new ArrayList<>();
        Random random = new Random();
        for (int i=0; i<nb; i++){
            int val = random.nextInt(cartes.size());
            res.add(cartes.remove(val));
            chekDeck();
        }
        return res;
    }

    public ACarte getCart(){
        ACarte res = null;

        Random random = new Random();
        int val = random.nextInt(cartes.size());
        res = cartes.remove(val);
        chekDeck();
        return res;
    }

    public void chekDeck(){
        if(cartes.size()<5){
            addDeck();
        }
    }
}
