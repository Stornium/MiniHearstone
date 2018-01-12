package fr.nicoPaul.miniHearstone.jeux.carte.mage;

import fr.nicoPaul.miniHearstone.jeux.Input;
import fr.nicoPaul.miniHearstone.jeux.Plateau;
import fr.nicoPaul.miniHearstone.jeux.carte.AServiteur;
import fr.nicoPaul.miniHearstone.jeux.carte.ASort;

import java.util.List;

/**
 * Metamorphose
 *
 * @author nicolas paul
 * @version 1
 * @since 1
 */
public class Metamorphose extends ASort {

    public Metamorphose() {
        super("Metamorphose", 4, "transforme un serviteur en serviteur 1/1 ");
    }

    @Override
    public void use(Plateau plateau) {
        System.out.println("choix du serviteur à Métamorphoser (! si nombre invalide la carte est perdu !)");
        List<AServiteur> cartes = plateau.getCartesOfCurentHero();//get les carte du hero sur le plateau
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
            cartes.get(val).setVie(1);
            cartes.get(val).setDegatsDeBase(1);
        }


    }
}
