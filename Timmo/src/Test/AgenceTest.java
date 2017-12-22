package Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import agence.*;
import biens.*;
import clients.*;
import exceptions.BienHasTwoMandatsException;

public class AgenceTest {

    @Test
    public void testInstanciation() throws BienHasTwoMandatsException {
        Agence a = Agence.getInstance();
        Terrain t = BienFactory.createTerrain("test" , Orientation.SUD , 40 , 5);
        Client c = ClientFactory.createClient("xx", "yy", "aze", "aze");
        Date date = new Date();
        Mandat m = MandatFactory.createMandat(c, t, 105, date);
        
        assertTrue(a.getMandatForBien(t) == m);
    }

}
