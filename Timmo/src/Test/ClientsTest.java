package Test;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import agence.Agence;
import agence.Mandat;
import agence.MandatFactory;
import biens.BienFactory;
import biens.Orientation;
import biens.Terrain;
import clients.Client;
import clients.ClientFactory;
import exceptions.BienHasTwoMandatsException;

public class ClientsTest {

    @Test
    public void testInstanciationClients() throws BienHasTwoMandatsException {
        Client c = ClientFactory.createClient("xx", "yy", "aze", "aze");
        assertTrue(c.getIdClient()== 1);
        assertTrue(c.getPrenom() == "xx");
        assertTrue(c.getNom() == "yy");
        
        
        Terrain t = BienFactory.createTerrain("test" , Orientation.SUD , 40 , 5);
        Date date = new Date();
        Mandat m = MandatFactory.createMandat(c, t, 105, date);
        
        assertTrue(c.getMandats().get(0)==m);
    }

}
