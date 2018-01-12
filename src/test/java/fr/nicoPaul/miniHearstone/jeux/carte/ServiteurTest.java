package fr.nicoPaul.miniHearstone.jeux.carte;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author nicolas paul
 * @since 1
 * @version 1
 */
public class ServiteurTest {

    Serviteur serviteur;

    @Before
    public void setUp() throws Exception {
        serviteur = new Serviteur("nom", 0, 0, 2);
    }

    @Test
    public void serviteurGetDamageAndDead() throws Exception {
        Assert.assertTrue(serviteur.takeDamage(2));
    }

    @Test
    public void serviteurGetManyDamageAndDead() throws Exception {
        Assert.assertTrue(serviteur.takeDamage(100));
    }

    @Test
    public void serviteurGetDamageAndNotDead() throws Exception {
        Assert.assertFalse(serviteur.takeDamage(1));
    }
}