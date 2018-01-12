package fr.nicoPaul.miniHearstone.jeux.carte;

import fr.nicoPaul.miniHearstone.jeux.Plateau;

/**
 * @author nicolas paul
 * @version 1
 * @since 1
 */
public abstract class AServiteurDecorator extends AServiteur {

    protected AServiteur aServiteur;

    public AServiteurDecorator(String nom, AServiteur aServiteur) {
        super(nom, aServiteur.getMana(), aServiteur.getDegats(), aServiteur.getVie());
        this.aServiteur = aServiteur;
    }

    @Override
    public void place(Plateau plateau) {
        aServiteur.place(plateau);
    }

    @Override
    public void use(Plateau plateau) {
        aServiteur.use(plateau);

    }

    @Override
    public String getNom() {
        return aServiteur.getNom() + ":" + nom;
    }
}
