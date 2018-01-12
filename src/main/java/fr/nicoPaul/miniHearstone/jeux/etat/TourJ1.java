package fr.nicoPaul.miniHearstone.jeux.etat;

import fr.nicoPaul.miniHearstone.jeux.Input;
import fr.nicoPaul.miniHearstone.jeux.Plateau;
import fr.nicoPaul.miniHearstone.jeux.carte.ACarte;
import fr.nicoPaul.miniHearstone.jeux.carte.Serviteur;
import fr.nicoPaul.miniHearstone.jeux.hero.AHero;

import java.util.List;

/**
 * @author nicolas paul
 * @since 1
 * @version 1
 */
public class TourJ1 implements Etat{

    private Plateau plateau;

    public TourJ1(Plateau plateau) {
        this.plateau = plateau;
    }


    public AHero getCurentHero() {
        return plateau.getJoueur1();
    }

    public void tour() {
        AHero curentHero = getCurentHero();
        curentHero.addMana();
        System.out.println("------------------------------------------");
        System.out.println("Au tour de "+ curentHero.getNom() +"\n");

        affiche(curentHero);

        while (true){

            ACarte aCarte= null;
            System.out.println("choix de la carte");
            int choix = Input.getIntInput("");
            if (choix == -1)
                break;
            List<ACarte> deck = curentHero.getDeck();
            if (choix > deck.size() && choix>=0)
                deck.get(choix).use();
        }

        finTour();
    }

    private void finTour(){
        plateau.addAllCartesAtenteInCartes();
        plateau.changeEtatTourJ2();
    }

    private void affiche(AHero curentHero){

        System.out.println("                    cartes d/v");
        List<Serviteur> cartesOfHero = plateau.getCartesOfHero(curentHero);
        StringBuilder builder = new StringBuilder("Carte de "+ curentHero.getNom() +" : ");
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

        AHero joueur2 = plateau.getJoueur2();
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

        builder = new StringBuilder("deck: ");
        for (int i = 0; i < curentHero.getDeck().size(); i++) {
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
    }
}
