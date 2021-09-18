/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mirekgab.sprawdzeniepodatnika;

import java.util.ArrayList;
import java.util.List;
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
public class FunkcjeTest {

    public FunkcjeTest() {
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
     * Test of czyJestMaska method, of class Funkcje.
     */
    @Test
    public void testCzyJestMaska() {
        System.out.println("czyJestMaska");
        String nrb = "20721233708680000022663112";
        String maska = "XX72123370XXXXXXXYYYXXXXXX";
        boolean expResult = true;
        boolean result = Funkcje.czyJestMaska(nrb, maska);
        assertEquals(expResult, result);
    }

}
