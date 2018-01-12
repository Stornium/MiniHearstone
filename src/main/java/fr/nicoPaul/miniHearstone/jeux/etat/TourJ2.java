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
 * @author nicolas paul
 * @version 1
 * @since 1
 */
public class TourJ2 implements Etat {

    private Plateau plateau;

    public TourJ2(Plateau plateau) {
        this.plateau = plateau;
    }

    @Override
    public AHero getCurentHero() {
        return plateau.getJoueur2();
    }

    @Override
    public AHero getNotCurentHero() {
        return plateau.getJoueur1();
    }

    public void tour() {
        AHero curentHero = getCurentHero();
        curentHero.addMana();
        curentHero.deckToMain();
        System.out.println("------------------------------------------");
        System.out.println("Au tour de " + curentHero.getNom() + "\n");
        System.out.println("Vie: " + curentHero.getVie() +
                " | Armure: " + curentHero.getArmure() +
                " | Mana: " + curentHero.getMana()
        );


        while (true) {

            affiche(curentHero);

            System.out.println("choix de l'action: A => utiliser une cart | M => Placer une carte de la main (-1 stop)");
            String action = Input.getStringInput("");
            if (!action.equalsIgnoreCase("a") && !action.equalsIgnoreCase("m"))
                break;

            System.out.println("choix de la carte.");
            int choix = Input.getIntInput("");
            if (choix == -1)
                break;

            List<? extends ACarte> listCartes = new ArrayList<>();
            if (action.equalsIgnoreCase("a")) {
                listCartes = plateau.getCartesOfHero(curentHero);
            } else if (action.equalsIgnoreCase("m")) {
                listCartes = curentHero.getMain();
            }

            if (choix < listCartes.size() && choix >= 0) {
                ACarte aCarte = listCartes.get(choix);
                if (action.equalsIgnoreCase("a")) {//seul des serviteurs passeront car les sorts sont utiliser imediatement apret m
                    if (plateau.getServiteursJouer().contains(aCarte)) {
                        System.out.println("! Carte déjà utiliser !");
                    } else {
                        aCarte.use(plateau);
                        plateau.getServiteursJouer().add((AServiteur) aCarte);
                        System.out.println("carte utiliser");
                    }
                } else if (action.equalsIgnoreCase("m")) {

                    if (aCarte.getMana() <= curentHero.getMana()) {
                        aCarte.place(plateau);
                        curentHero.supMana(aCarte.getMana());
                        listCartes.remove(aCarte);
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
        plateau.changeEtatTourJ1();
        plateau.tour();
    }

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

        AHero joueur1 = plateau.getJoueur1();
        cartesOfHero = plateau.getCartesOfHero(joueur1);
        builder = new StringBuilder("Carte de " + joueur1.getNom() + " : ");
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
                            " Dégât: " + ((AServiteur) aCarte).getDegats() :
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
