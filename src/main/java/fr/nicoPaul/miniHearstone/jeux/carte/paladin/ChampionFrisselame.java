package fr.nicoPaul.miniHearstone.jeux.carte.paladin;

import fr.nicoPaul.miniHearstone.jeux.carte.ACarte;
import fr.nicoPaul.miniHearstone.jeux.carte.AServiteur;
import fr.nicoPaul.miniHearstone.jeux.carte.effect.Charge;
import fr.nicoPaul.miniHearstone.jeux.carte.effect.VolDeVie;

/**
 * Champion frisselame
 *
 * @author nicolas paul
 * @version 1
 * @since 1
 */
public class ChampionFrisselame extends AServiteur {
    public ChampionFrisselame() {
        super("Champion frisselame", 4, 3, 2);
    }

    @Override
    public ACarte init() {
        return new VolDeVie(new Charge(this));
    }
}
