import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import agence.*;
import biens.*;
import clients.*;
import exceptions.*;

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
        Client c = ClientFactory.createClient("xx", "uuu");
    }
    
    @Test 
    public void testCreerMandat() throws ClientMissingException, BienMissingException, BienHasTwoMandatsException {
    	Agence a = Agence.getInstance();
    	Terrain t = BienFactory.createTerrain("test" , Orientation.SUD , 40 , 5);
        Client c = ClientFactory.createClient("xx", "uuu");
        Date date = new Date();
        Mandat m = MandatFactory.createMandat(t.getIdBien(), c.getIdClient(), 10, date);
    }
    
    @Test (expected = BienMissingException.class)
    public void testThrowBienException() throws ClientMissingException, BienMissingException, BienHasTwoMandatsException {
    	Agence a = Agence.getInstance();
    	Terrain t = BienFactory.createTerrain("test" , Orientation.SUD , 40 , 5);
        Client c = ClientFactory.createClient("xx", "uuu");
        Date date = new Date();
        Mandat m = MandatFactory.createMandat(-1, c.getIdClient(), 10, date);
    }
    
    @Test (expected = ClientMissingException.class)
    public void testThrowClientException() throws ClientMissingException, BienMissingException, BienHasTwoMandatsException {
    	Agence a = Agence.getInstance();
    	Terrain t = BienFactory.createTerrain("test" , Orientation.SUD , 40 , 5);
        Client c = ClientFactory.createClient("xx", "uuu");
        Date date = new Date();
        Mandat m = MandatFactory.createMandat(t.getIdBien(), -1, 10, date);
    }

}
