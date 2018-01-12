package fr.nicoPaul.miniHearstone.jeux.carte;

import fr.nicoPaul.miniHearstone.jeux.Plateau;

/**
 * @author nicolas paul
 * @version 1
 * @since 1
 */
public abstract class ASort extends ACarte {

    protected String desc;

    public ASort(String nom, int mana, String desc) {
        super(nom, mana);
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public void place(Plateau plateau) {
        use(plateau);
    }
}
