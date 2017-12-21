
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import agence.Agence;
import biens.BienFactory;
import biens.BienManager;
import biens.Orientation;
import biens.Terrain;
import clients.Client;
import clients.ClientFactory;
import clients.ClientManager;
import exceptions.BienHasTwoMandatsException;
import exceptions.BienMissingException;
import exceptions.ClientMissingException;

public class MandatsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void testCreerClient() {
        Agence a = Agence.getInstance();
        Terrain t = BienFactory.createTerrain("test" , Orientation.SUD , 40 , 5);
       // Client c = ClientFactory.createClient("xx", "uuu");
    }

}
