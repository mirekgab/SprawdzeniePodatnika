/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mirekgab.sprawdzeniepodatnika;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mirek
 */
public class WynikJsonSerwisTest {
    
    public WynikJsonSerwisTest() {
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
     * Test of konto method, of class PlikJsonSerwis.
     */
    @Test
    public void testKonto() {
        System.out.println("konto");
        String maska = "XX72123370XXXXXXXYYYXXXXXX";
        String konto = "20721233708680000022663112";
        String expResult = "XX72123370XXXXXXX022XXXXXX";
        String result = Funkcje.konto(maska, konto);
        assertEquals(expResult, result);
    }
    
}
