package fr.nicoPaul.miniHearstone.jeux.carte;

import fr.nicoPaul.miniHearstone.jeux.carte.all.ChefDeRaid;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author nicolas paul
 * @since 1
 * @version 1
 */
public class AServiteurTest {

    AServiteur AServiteur;

    @Before
    public void setUp() throws Exception {
        AServiteur = new ChefDeRaid();
    }

    @Test
    public void serviteurGetDamageAndDead() throws Exception {
        Assert.assertTrue(AServiteur.takeDamage(2));
    }

    @Test
    public void serviteurGetManyDamageAndDead() throws Exception {
        Assert.assertTrue(AServiteur.takeDamage(100));
    }

    @Test
    public void serviteurGetDamageAndNotDead() throws Exception {
        Assert.assertFalse(AServiteur.takeDamage(1));
    }
}