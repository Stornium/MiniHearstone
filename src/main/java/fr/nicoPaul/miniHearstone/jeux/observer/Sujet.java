package fr.nicoPaul.miniHearstone.jeux.observer;

/**
 * @author nicolas paul
 * @since 1
 * @version 1
 */
public interface Sujet {

    void addObserveur(Observer observer);
    void supObserveur(Observer observer);
    void notifierObserveur();
}
