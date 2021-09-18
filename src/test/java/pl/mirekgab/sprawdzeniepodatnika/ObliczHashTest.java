/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mirekgab.sprawdzeniepodatnika;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


/**
 *
 * @author mirek
 */
public class ObliczHashTest {
    
    public ObliczHashTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of hash method, of class ObliczHash.
     */
    @Test
    public void testHash() throws Exception {
        System.out.println("obliczHash");
        String dane = "20191018143572123034102012221314181237774212";
        String expResult = "f8b915776eab735fdd10266b2e66068447904852b82c30eeb6de30703a087eb17ea4c4a37630494607194ddb9354c1211bd984fb5f4d9cff95f5a24ed52065e7";        
        String result = dane;
        for (int a=0;a<5000;a++) {
            result = ObliczHash.hash(result);
        }
        System.out.println(expResult);
        System.out.println(result);
        assertEquals(expResult, result);
    }
    
}
