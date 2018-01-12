package fr.nicoPaul.miniHearstone.jeux.carte;

/**
 * @author nicolas paul
 * @since 1
 * @version 1
 */
public class Serviteur extends ACarte {

    protected int vie;

    public Serviteur(String nom, int degats, int mana, int vie) {
        super(nom, degats, mana);
        this.vie = vie;
    }

    public int getVie() {
        return vie;
    }

    /**
     *
     * @return true si le serviteur est mort
     */
    public boolean takeDamage(int damage){
        return (vie-=damage)<=0;
    }
}
