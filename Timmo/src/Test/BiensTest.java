package Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import agence.Agence;
import agence.Mandat;
import agence.MandatFactory;
import biens.BienFactory;
import biens.BienType;
import biens.Orientation;
import biens.Terrain;
import clients.Client;
import clients.ClientFactory;
import exceptions.BienHasTwoMandatsException;

public class BiensTest {

    @Test
    public void testInstanciation() throws BienHasTwoMandatsException {
        Client c = ClientFactory.createClient("xx", "yy", "aze", "azer");
        Terrain t = BienFactory.createTerrain("test" , Orientation.SUD , 40 , 5);
        
        assertTrue(t.getAdresse()=="test");
        assertTrue(t.getBienType()==BienType.TERRAIN);
        assertTrue(t.getLongueurFacade()==5);
        assertTrue(t.getOrientation()== Orientation.SUD);
        t.setAdresse("nowhere");
        assertTrue(t.getAdresse()=="nowhere");
    }

}
