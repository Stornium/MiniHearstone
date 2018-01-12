package fr.nicoPaul.miniHearstone.jeux.etat;

import fr.nicoPaul.miniHearstone.jeux.Input;
import fr.nicoPaul.miniHearstone.jeux.Plateau;
import fr.nicoPaul.miniHearstone.jeux.hero.AHero;
import fr.nicoPaul.miniHearstone.jeux.hero.Guerrier;
import fr.nicoPaul.miniHearstone.jeux.hero.Mage;
import fr.nicoPaul.miniHearstone.jeux.hero.Paladin;

import java.util.Random;

/**
 * @author nicolas paul
 * @since 1
 * @version 1
 */
public class InitGame implements Etat {

    private Plateau plateau;

    public InitGame(Plateau plateau) {
        this.plateau = plateau;
    }

    public AHero getCurentHero() {
        return null;
    }

    public void tour() {

        System.out.println("nom du joueur 1");
        String nom = Input.getStringInput("");

        System.out.println("choix du joueur 1");
        plateau.setJoueur1(choixHero(nom));


        System.out.println("nom du joueur 2");
        nom = Input.getStringInput("");

        System.out.println("choix du joueur 2");
        plateau.setJoueur2(choixHero(nom));

        System.out.println("choix du joueur au hasard pour jouer en premier");
        Random rn = new Random();
        int val = rn.nextInt(2) + 1;
        if(val==1){
            plateau.changeEtatTourJ1();
        }else{
            plateau.changeEtatTourJ2();
        }
        plateau.tour();
    }

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
