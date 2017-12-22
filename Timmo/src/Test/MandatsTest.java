package Test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import agence.*;
import biens.*;
import clients.*;
import exceptions.BienHasTwoMandatsException;
import exceptions.BienMissingException;
import exceptions.ClientMissingException;

public class MandatsTest {

    @Test
    public void testCreerMandat() throws BienHasTwoMandatsException {
        Agence a = Agence.getInstance();
        Terrain t = BienFactory.createTerrain("test" , Orientation.SUD , 40 , 5);
        Client c = ClientFactory.createClient("xx", "yy", "aze", "aze");
        Date date = new Date();
        assertNotNull(c);
        assertNotNull(t);
        
        Mandat m = MandatFactory.createMandat(c, t, 105, date);
        assertNotNull(m);
    }
    
    @Test
    public void testInstanciation() throws BienHasTwoMandatsException {
        Agence a = Agence.getInstance();
        Terrain t = BienFactory.createTerrain("test" , Orientation.SUD , 40 , 5);
        Client c = ClientFactory.createClient("xx", "yy", "aze", "aze");
        Date date = new Date();
        Mandat m = MandatFactory.createMandat(c, t, 105, date);
        assertTrue(m.getClient()==c);
        assertTrue(m.getBien()==t);
        assertTrue(m.getDateLimite()==date);
    }
    
    @Test (expected = BienHasTwoMandatsException.class)
    public void TwoMandats() throws BienHasTwoMandatsException {
        Agence a = Agence.getInstance();
        Terrain t = BienFactory.createTerrain("test" , Orientation.SUD , 40 , 5);
        Client c = ClientFactory.createClient("xx", "yy", "aze", "aze");
        Client d = ClientFactory.createClient("xxxxx", "yyyyyy", "azze", "azze");
        Date date = new Date();
        Mandat m = MandatFactory.createMandat(c, t, 105, date);
        Mandat n = MandatFactory.createMandat(c,t,110,date);
    }

}
