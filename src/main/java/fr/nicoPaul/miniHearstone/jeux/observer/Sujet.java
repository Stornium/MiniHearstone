package fr.nicoPaul.miniHearstone.jeux.observer;

/**
 * @author nicolas paul
 * @version 1
 * @since 1
 */
public interface Sujet {

    void addObserveur(Observer observer);

    void supObserveur(Observer observer);

    void notifierObserveur();
}
