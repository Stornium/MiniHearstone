package fr.nicoPaul.miniHearstone.jeux;

import fr.nicoPaul.miniHearstone.jeux.carte.AServiteur;
import fr.nicoPaul.miniHearstone.jeux.etat.*;
import fr.nicoPaul.miniHearstone.jeux.hero.AHero;
import fr.nicoPaul.miniHearstone.jeux.observer.Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author nicolas paul
 * @since 1
 * @version 1
 */
public class Plateau implements Observer {

    private Etat etat;
    private Etat initGame;
    private Etat tourJ1;
    private Etat tourJ2;
    private Etat fin;

    private AHero joueur1;
    private AHero joueur2;

    private HashMap<AHero, List<AServiteur>> cartes;
    private List<AServiteur> cartesAtente;

    private List<AServiteur> serviteursJouer;

    public Plateau() {
        this.initGame = new InitGame(this);
        this.tourJ1 = new TourJ1(this);
        this.tourJ2 = new TourJ2(this);
        this.fin = new Fin(this);
        this.etat = this.initGame;

        this.cartesAtente = new ArrayList<AServiteur>();
        this.cartes = new HashMap<AHero, List<AServiteur>>();

        this.serviteursJouer = new ArrayList<>();

        tour();
    }

    public void tour(){
        etat.tour();
    }

    public void addCartesAtente(AServiteur AServiteur){
        cartesAtente.add(AServiteur);
    }

    public void supCartesAtente(AServiteur AServiteur){
        cartesAtente.remove(AServiteur);
    }

    public void addCartes(AServiteur AServiteur){
        cartes.get(etat.getCurentHero()).add(AServiteur);
    }

    public void addAllCartesAtenteInCartes(){
        cartes.get(etat.getCurentHero()).addAll(cartesAtente);
        cartesAtente.clear();
    }

    public List<AServiteur> getCartesOfHero(AHero hero) {
        return this.cartes.get(hero);
    }

    public List<AServiteur> getCartesOfCurentHero() {
        return this.cartes.get(etat.getCurentHero());
    }

    public List<AServiteur> getCartesCible(){
        return cartes.get(etat.getNotCurentHero());
    }

    public AHero getHeroCurent(){
        return etat.getCurentHero();
    }

    public AHero getHeroCible(){
        return etat.getNotCurentHero();
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

    public List<AServiteur> getServiteursJouer() {
        return serviteursJouer;
    }

    //</editor-fold>

    //<editor-fold desc="change etat">
    public void changeEtatTourJ1(){
        etat = tourJ1;
    }

    public void changeEtatTourJ2(){
        etat = tourJ2;
    }
    public void changeEtatFin(){
        etat = fin;
    }
    //</editor-fold>

    @Override
    public void actualiser(int vie) {
        if (vie <=0){
            changeEtatFin();
            tour();
        }
    }
}
