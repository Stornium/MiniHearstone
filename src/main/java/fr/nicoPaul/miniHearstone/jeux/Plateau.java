package fr.nicoPaul.miniHearstone.jeux;

import fr.nicoPaul.miniHearstone.jeux.carte.Serviteur;
import fr.nicoPaul.miniHearstone.jeux.etat.Etat;
import fr.nicoPaul.miniHearstone.jeux.etat.InitGame;
import fr.nicoPaul.miniHearstone.jeux.etat.TourJ1;
import fr.nicoPaul.miniHearstone.jeux.etat.TourJ2;
import fr.nicoPaul.miniHearstone.jeux.hero.AHero;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author nicolas paul
 * @since 1
 * @version 1
 */
public class Plateau {

    private Etat etat;
    private Etat initGame;
    private Etat tourJ1;
    private Etat tourJ2;

    private AHero joueur1;
    private AHero joueur2;

    private HashMap<AHero, List<Serviteur>> cartes;
    private List<Serviteur> cartesAtente;

    public Plateau() {
        this.initGame = new InitGame(this);
        this.tourJ1 = new TourJ1(this);
        this.tourJ2 = new TourJ2(this);
        this.etat = this.initGame;

        this.cartesAtente = new ArrayList<Serviteur>();
        this.cartes = new HashMap<AHero, List<Serviteur>>();

        tour();
    }

    public void tour(){
        etat.tour();
    }

    public void addCartesAtente(Serviteur serviteur){
        cartesAtente.add(serviteur);
    }

    public void addCartes(Serviteur serviteur){
        cartes.get(etat.getCurentHero()).add(serviteur);
    }

    public void addAllCartesAtenteInCartes(){
        cartes.get(etat.getCurentHero()).addAll(cartesAtente);
        cartesAtente.clear();
    }

    public List<Serviteur> getCartesOfHero(AHero hero) {
        return this.cartes.get(hero);
    }

    //<editor-fold desc="get & set">
    public void setJoueur1(AHero joueur1) {
        this.joueur1 = joueur1;
        cartes.put(joueur1, new ArrayList<>());
    }

    public void setJoueur2(AHero joueur2) {
        this.joueur2 = joueur2;
        cartes.put(joueur2, new ArrayList<>());
    }

    public AHero getJoueur1() {
        return joueur1;
    }

    public AHero getJoueur2() {
        return joueur2;
    }
    //</editor-fold>

    //<editor-fold desc="change etat">
    public void changeEtatTourJ1(){
        etat = tourJ1;
    }

    public void changeEtatTourJ2(){
        etat = tourJ2;
    }
    //</editor-fold>
}
