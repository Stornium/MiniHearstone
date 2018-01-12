package fr.nicoPaul.miniHearstone.jeux.carte.paladin;

import fr.nicoPaul.miniHearstone.jeux.Input;
import fr.nicoPaul.miniHearstone.jeux.Plateau;
import fr.nicoPaul.miniHearstone.jeux.carte.AServiteur;
import fr.nicoPaul.miniHearstone.jeux.carte.ASort;

import java.util.List;

/**
 * Benediction de puissance
 *
 * @author nicolas paul
 * @version 1
 * @since 1
 */
public class BenedictionDePuissance extends ASort {

    public BenedictionDePuissance() {
        super("Benediction de puissance", 1, "confère +3 d’attaque à un serviteur");
    }

    @Override
    public void use(Plateau plateau) {
        System.out.println("choix du serviteur à Metamorphoser (! si nombre invalide la carte est perdu !)");
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
            cartes.get(val).addBoostDegat(3);
        }
    }
}
