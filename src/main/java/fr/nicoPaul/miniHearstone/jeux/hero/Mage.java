package fr.nicoPaul.miniHearstone.jeux.hero;

import fr.nicoPaul.miniHearstone.jeux.Input;
import fr.nicoPaul.miniHearstone.jeux.Plateau;
import fr.nicoPaul.miniHearstone.jeux.carte.AServiteur;

import java.util.List;

/**
 * @author nicolas paul
 * @version 1
 * @since 1
 */
public class Mage extends AHero {

    public Mage(String nom) {
        super(nom, "Boule de feu", EType.MAGE);
    }

    public void specialAction(Plateau plateau) {
        System.out.println("choix de la cible ( -1 ou autre pour  hero)");
        List<AServiteur> cartes = plateau.getCartesCible();
        StringBuilder builder = new StringBuilder("");
        for (int i = 0; i < cartes.size(); i++) {
            AServiteur AServiteur = cartes.get(i);
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
        int val = Input.getIntInput("");
        if (val < cartes.size() && val >= 0) {
            cartes.get(val).takeDamage(1);
        } else {
            plateau.getHeroCible().takeDamege(1);
        }
    }
}
