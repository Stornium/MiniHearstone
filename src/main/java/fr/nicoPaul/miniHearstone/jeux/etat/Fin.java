package fr.nicoPaul.miniHearstone.jeux.etat;

import fr.nicoPaul.miniHearstone.jeux.Plateau;
import fr.nicoPaul.miniHearstone.jeux.hero.AHero;

/**
 * @author nicolas paul
 * @since 1
 * @version 1
 */
public class Fin implements Etat {

    private Plateau plateau;

    public Fin(Plateau plateau) {
        this.plateau = plateau;
    }

    @Override
    public AHero getCurentHero() {
        return null;
    }

    @Override
    public AHero getNotCurentHero() {
        return null;
    }

    @Override
    public void tour() {
        System.out.println("----------- FIN -----------");
        System.out.println("victoire de: "+plateau.getWin().getMana());
        System.exit(0);
    }
}
