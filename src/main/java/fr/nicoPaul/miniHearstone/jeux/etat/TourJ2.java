package fr.nicoPaul.miniHearstone.jeux.etat;

import fr.nicoPaul.miniHearstone.jeux.Plateau;
import fr.nicoPaul.miniHearstone.jeux.carte.Serviteur;
import fr.nicoPaul.miniHearstone.jeux.hero.AHero;

import java.util.List;

/**
 * @author nicolas paul
 * @since 1
 * @version 1
 */
public class TourJ2 implements Etat{

    private Plateau plateau;

    public TourJ2(Plateau plateau) {
        this.plateau = plateau;
    }

    public AHero getCurentHero() {
        return plateau.getJoueur2();
    }

    public void tour() {
        AHero curentHero = getCurentHero();
        curentHero.addMana();
        String nom = curentHero.getNom();
        System.out.println("Au tour de "+ nom +"\n");

        System.out.println("    cartes d/v");
        List<Serviteur> cartesOfHero = plateau.getCartesOfHero(curentHero);
        StringBuilder builder = new StringBuilder("Carte de "+ nom +" : ");
        for (int i = 0; i < cartesOfHero.size(); i++) {
            Serviteur serviteur = cartesOfHero.get(i);
            builder.append(i)
                    .append(":")
                    .append(serviteur.getNom())
                    .append(" ")
                    .append(serviteur.getDegats())
                    .append(" ")
                    .append(serviteur.getVie());
        }
        System.out.println(builder);

        AHero joueur2 = plateau.getJoueur1();
        cartesOfHero = plateau.getCartesOfHero(joueur2);
        builder = new StringBuilder("Carte de "+ joueur2.getNom() +" : ");
        for (int i = 0; i < cartesOfHero.size(); i++) {
            Serviteur serviteur = cartesOfHero.get(i);
            builder.append(i)
                    .append(":")
                    .append(serviteur.getNom())
                    .append(" ")
                    .append(serviteur.getDegats())
                    .append(" ")
                    .append(serviteur.getVie());
        }
        System.out.println(builder);

        plateau.changeEtatTourJ1();
    }
}
