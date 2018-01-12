package fr.nicoPaul.miniHearstone.jeux.etat;

import fr.nicoPaul.miniHearstone.jeux.Input;
import fr.nicoPaul.miniHearstone.jeux.Plateau;
import fr.nicoPaul.miniHearstone.jeux.carte.ACarte;
import fr.nicoPaul.miniHearstone.jeux.carte.AServiteur;
import fr.nicoPaul.miniHearstone.jeux.carte.ASort;
import fr.nicoPaul.miniHearstone.jeux.hero.AHero;

import java.util.ArrayList;
import java.util.List;

/**
 * le toure du joueur 1
 *
 * @author nicolas paul
 * @version 1
 * @since 1
 */
public class TourJ1 implements Etat {

    private Plateau plateau;

    public TourJ1(Plateau plateau) {
        this.plateau = plateau;
    }

    @Override
    public AHero getCurentHero() {
        return plateau.getJoueur1();
    }

    @Override
    public AHero getNotCurentHero() {
        return plateau.getJoueur2();
    }

    @Override
    public void tour() {
        boolean spe = false;
        AHero curentHero = getCurentHero();
        curentHero.addMana();//+1 de mana
        curentHero.deckToMain();//prend une carte dans sa main
        System.out.println("------------------------------------------");
        System.out.println("Au tour de " + curentHero.getNom() + "\n");
        System.out.println("Vie: " + curentHero.getVie() +
                " | Armure: " + curentHero.getArmure() +
                " | Mana: " + curentHero.getMana()
        );


        while (true) {

            affiche(curentHero);

            System.out.println("choix de l'action: A => utiliser une carte | M => Placer une carte de la main | S => action special  (-1 stop)");
            String action = Input.getStringInput("");
            if (!action.equalsIgnoreCase("a") && !action.equalsIgnoreCase("m") && !action.equalsIgnoreCase("s"))
                break;

            int choix = -1;
            while (!action.equalsIgnoreCase("s")) {//Choix de cart que si pas specialle
                System.out.println("choix de la carte.");
                choix = Input.getIntInput("");
                if (choix != -1)
                    break;
            }

            List<? extends ACarte> listCartes = new ArrayList<>();
            if (action.equalsIgnoreCase("a")) {
                //si on ataque le choix se fait selement sur les carte du hero sur le plateau
                listCartes = plateau.getCartesOfHero(curentHero);
            } else if (action.equalsIgnoreCase("m")) {
                //si on pose une carte le choix se fait selement dans la main
                listCartes = curentHero.getMain();
            }

            if (action.equalsIgnoreCase("s") && spe) {
                // si special dejat utilisé
                System.out.println("! deja utiliser !");
            } else if (action.equalsIgnoreCase("s") && !spe) {
                if (2 <= curentHero.getMana()) {
                    //si asser de mana
                    spe = true;
                    getCurentHero().specialAction(plateau);
                    curentHero.supMana(2);
                    System.out.println("action special jouer");
                } else {
                    System.out.println("pas assez de mana!");
                }
            } else if (choix < listCartes.size() && choix >= 0) {
                ACarte aCarte = listCartes.get(choix);
                if (action.equalsIgnoreCase("a")) {
                    if (plateau.getServiteursJouer().contains(aCarte)) {
                        System.out.println("! Carte deja utiliser !");
                    } else {
                        aCarte.use(plateau);
                        plateau.getServiteursJouer().add((AServiteur) aCarte);
                        //seul des serviteurs passeront car les sorts sont utiliser imediatement apret m. donc on peu caster sans problème
                        System.out.println("carte utiliser");
                    }
                } else if (action.equalsIgnoreCase("m")) {

                    if (aCarte.getMana() <= curentHero.getMana()) {
                        aCarte.place(plateau);
                        curentHero.supMana(aCarte.getMana());//sup du mana
                        listCartes.remove(aCarte);//sup de la main
                        System.out.println("carte jouer");
                    } else {
                        System.out.println("pas assez de mana!");
                    }
                }
            } else {
                System.out.println("error");
            }
        }

        finTour();
    }

    private void finTour() {
        plateau.getServiteursJouer().clear();
        plateau.addAllCartesAtenteInCartes();
        plateau.changeEtatTourJ2();
        plateau.tour();
    }

    /**
     * affichage du plateau et de la main du joueur 1
     *
     * @param curentHero hero actuelle
     */
    private void affiche(AHero curentHero) {

        System.out.println("---------------------------- cartes d/v");
        List<AServiteur> cartesOfHero = plateau.getCartesOfHero(curentHero);
        StringBuilder builder = new StringBuilder("Carte de " + curentHero.getNom() + " : ");
        for (int i = 0; i < cartesOfHero.size(); i++) {
            AServiteur AServiteur = cartesOfHero.get(i);
            builder.append(i)
                    .append(":")
                    .append(AServiteur.getNom())
                    .append(" ")
                    .append(AServiteur.getDegats())
                    .append(" ")
                    .append(AServiteur.getVie())
                    .append(" | ");
        }
        System.out.println(builder);

        AHero joueur2 = plateau.getJoueur2();
        cartesOfHero = plateau.getCartesOfHero(joueur2);
        builder = new StringBuilder("Carte de " + joueur2.getNom() + " : ");
        for (int i = 0; i < cartesOfHero.size(); i++) {
            AServiteur AServiteur = cartesOfHero.get(i);
            builder.append(i)
                    .append(":")
                    .append(AServiteur.getNom())
                    .append(" ")
                    .append(AServiteur.getDegats())
                    .append(" ")
                    .append(AServiteur.getVie())
                    .append(" | ");
        }
        System.out.println(builder);

        builder = new StringBuilder("Main: ");
        List<ACarte> main = curentHero.getMain();
        for (int i = 0; i < main.size(); i++) {
            ACarte aCarte = main.get(i);
            builder.append(i)
                    .append(":")
                    .append(aCarte instanceof AServiteur ? " (Serv)" : " (Sort)")
                    .append(aCarte.getNom())
                    .append(" Mana: ")
                    .append(aCarte.getMana())
                    .append(aCarte instanceof AServiteur ?
                            " Degat: " + ((AServiteur) aCarte).getDegats() :
                            " Desc: " + ((ASort) aCarte).getDesc())
                    .append(aCarte instanceof AServiteur ?
                            " Vie: " + ((AServiteur) aCarte).getVie() :
                            "")
                    .append(" | ");
        }
        System.out.println(builder);
        System.out.println("Mana: " + curentHero.getMana());
    }
}
