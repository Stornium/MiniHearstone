package fr.nicoPaul.miniHearstone.jeux.etat;

import fr.nicoPaul.miniHearstone.jeux.Input;
import fr.nicoPaul.miniHearstone.jeux.Plateau;
import fr.nicoPaul.miniHearstone.jeux.hero.AHero;
import fr.nicoPaul.miniHearstone.jeux.hero.Guerrier;
import fr.nicoPaul.miniHearstone.jeux.hero.Mage;
import fr.nicoPaul.miniHearstone.jeux.hero.Paladin;

import java.util.Random;

/**
 * debut de partie
 *
 * @author nicolas paul
 * @since 1
 * @version 1
 */
public class InitGame implements Etat {

    private Plateau plateau;

    public InitGame(Plateau plateau) {
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

        //init joueur 1
        System.out.println("nom du joueur 1");
        String nom = Input.getStringInput("");

        System.out.println("choix du joueur 1");
        AHero hero = choixHero(nom);
        plateau.setJoueur1(hero);
        hero.addObserveur(plateau);


        //init joueur 2
        System.out.println("nom du joueur 2");
        nom = Input.getStringInput("");

        System.out.println("choix du joueur 2");
        hero = choixHero(nom);
        plateau.setJoueur2(hero);
        hero.addObserveur(plateau);

        AHero joueur1 = plateau.getJoueur1();
        AHero joueur2 = plateau.getJoueur2();



        System.out.println("choix du joueur au hasard pour jouer en premier");
        Random rn = new Random();
        int val = rn.nextInt(2) + 1;
        if(val==1){
            joueur1.addMain(joueur1.getADeck().getCartes(2));//3-1 car carte tirer au debut de tour
            joueur2.addMain(joueur2.getADeck().getCartes(3));//4-1 car carte tirer au debut de tour
            plateau.changeEtatTourJ1();
        }else{
            joueur2.addMain(joueur2.getADeck().getCartes(2));
            joueur1.addMain(joueur1.getADeck().getCartes(3));
            plateau.changeEtatTourJ2();
        }
        plateau.tour();
    }

    /**
     * le choix du hero a utiliser par le joueur
     * @param nom nom du joueur
     * @return le hero choisie
     */
    private AHero choixHero(String nom){
        boolean run = true;
        AHero hero = null;
        while (run){
            System.out.println("   1 => Mage\n"+
                            "   2 => Paladin\n"+
                            "   3 => Guerrier");
            int choix = Input.getIntInput("");
            switch (choix){
                case 1:
                    hero = new Mage(nom);
                    run=false;
                    break;
                case 2:
                    hero = new Paladin(nom);
                    run=false;
                    break;
                case 3:
                    hero = new Guerrier(nom);
                    run=false;
                    break;
                default:
                    System.out.println(choix+": numero invalide");
            }
        }
        return hero;
    }

}
