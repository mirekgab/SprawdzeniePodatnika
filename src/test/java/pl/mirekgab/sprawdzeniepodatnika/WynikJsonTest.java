
package pl.mirekgab.sprawdzeniepodatnika;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author mirek
 */
public class WynikJsonTest {
    
    public WynikJsonTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of wczytaj method, of class PlikJsonSerwis.
     */
    @Test
    public void testWczytaj() throws Exception {
        System.out.println("wczytaj");
        PlikJsonSerwis instance = new PlikJsonSerwis();
        WynikJson wj = instance.wczytaj("20191121.json");
        System.out.println(wj);
        System.out.println(wj.getSkrotyPodatnikowCzynnych().size());
        System.out.println(wj.getSkrotyPodatnikowZwolnionych().size());
    }
    
}
