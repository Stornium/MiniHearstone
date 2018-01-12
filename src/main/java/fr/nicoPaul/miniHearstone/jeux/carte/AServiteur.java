package fr.nicoPaul.miniHearstone.jeux.carte;

import fr.nicoPaul.miniHearstone.jeux.Input;
import fr.nicoPaul.miniHearstone.jeux.Plateau;
import fr.nicoPaul.miniHearstone.jeux.carte.effect.Provocation;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author nicolas paul
 * @version 1
 * @since 1
 */
public abstract class AServiteur extends ACarte {

    protected int degatsDeBase;
    protected int vie;
    protected int boostDegat;

    public AServiteur(String nom, int mana, int degatsDeBase, int vie) {
        super(nom, mana);
        this.degatsDeBase = degatsDeBase;
        this.vie = vie;
        this.boostDegat = 0;
    }

    public int getVie() {
        return vie;
    }

    public int getDegats() {
        return degatsDeBase+boostDegat;
    }

    public void setDegatsDeBase(int degats) {
        this.degatsDeBase = degats;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    /**
     * @return true si le aServiteur est mort
     */
    public boolean takeDamage(int damage) {
        vie-=damage;
        boolean ret = false;
        if(vie <= 0){
            ret = true;
            dead();
        }
        return ret;
    }

    public void dead(){

    }

    public void addBoostDegat(int nb){
        this.boostDegat+=nb;
    }

    public void supBoostDegat(int nb){
        this.boostDegat-=nb;
    }

    @Override
    public void place(Plateau plateau) {
        plateau.addCartesAtente(this);
    }

    @Override
    public void use(Plateau plateau) {
        System.out.println("Utilisation de la carte "+nom+". dégât: "+degatsDeBase+boostDegat);
        List<AServiteur> cartesCible = plateau.getCartesCible();
        List<AServiteur> collect = cartesCible.stream()
                .filter(aServiteur -> aServiteur.isEffet(Provocation.class))
                .collect(Collectors.toList());
        boolean empty = collect.isEmpty();
        if(!empty){
            cartesCible=collect;
        }
        System.out.println(listCartesToString(cartesCible));
        int choix = -1;
        while (choix==-1){
            choix = Input.getIntInput("choix (nombre superieur pour attaquer le héro)");

            if (choix < cartesCible.size() && choix >= 0) {
                boolean dead = cartesCible.get(choix).takeDamage(degatsDeBase+boostDegat);
                if (dead){
                    plateau.getCartesCible().remove(choix);
                }
            }else if(empty){
                plateau.getHeroCible().takeDamege(degatsDeBase+boostDegat);
            }else {
                choix= -1;
                System.out.println("! il est pas possible d'attaquer un hero si une carte Provocation est présente !");
            }
        }
    }

    public boolean isEffet(Class<? extends AServiteurDecorator> aClass) {
        return false;
    }

    private String listCartesToString(List<AServiteur> list){
        StringBuilder builder = new StringBuilder("Carte cible : ");
        for (int i = 0; i < list.size(); i++) {
            AServiteur AServiteur = list.get(i);
            builder.append(i)
                    .append(":")
                    .append(AServiteur.getNom())
                    .append(" ")
                    .append(AServiteur.getDegats())
                    .append(" ")
                    .append(AServiteur.getVie())
                    .append(" | ");
        }
        return builder.toString();
    }
}
