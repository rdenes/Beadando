/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModellTest;

import Modell.Megallo;
import Modell.Menetrend;
import Modell.MenetrendXMLDAO;
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
 * @author Rácz Dénes
 */
public class MenetrendXMLDAOTest {
    
    public MenetrendXMLDAOTest() {
    }
    
    @Test
    public void testGetBuszMegallo() throws Exception {
        System.out.println("getMuszMegallo");
        int buszszam = 1096;
        String megallo = "Megallo1024";
        MenetrendXMLDAO instance = new MenetrendXMLDAO();
        List<Menetrend> expResult = new ArrayList<>();
        expResult.add(new Menetrend(0,"","","",""));
        expResult.add(new Menetrend(1,"1 3 7","1 3 7","1 3 7","1 3 7"));
        expResult.add(new Menetrend(2,"7","7","7","7"));
        List<Menetrend> result = instance.getBuszMegallo(buszszam, megallo);
        
        assertEquals(expResult.get(0).getMunkanap(), result.get(0).getMunkanap());
        assertEquals(expResult.get(1).getMunkanap(), result.get(1).getMunkanap());
        assertEquals(expResult.get(2).getMunkanap(), result.get(2).getMunkanap());
        
        
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getBuszok method, of class MenetrendXMLDAO.
     */
    @Test
    public void testGetBuszok() throws Exception {
        System.out.println("getBuszok");
        String megallo = "Megallo1024";
        MenetrendXMLDAO instance = new MenetrendXMLDAO();
        List<Integer> expResult = new ArrayList<>();
        List<Integer> result = instance.getBuszok(megallo);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        expResult.add(1096);
        assertEquals(expResult.get(0), result.get(0));
    }

    /**
     * Test of MegallokStart method, of class MenetrendXMLDAO.
     */
    @Test
    public void testMegallokStart() throws Exception {
        System.out.println("MegallokStart");
        MenetrendXMLDAO instance = new MenetrendXMLDAO();
        List<String> expResult = new ArrayList<>();
        List<String> result = instance.MegallokStart();
        expResult.add("Megallo1033");
        assertEquals(expResult.get(expResult.size()-1), result.get(result.size()-1));
        
        //assertTrue(true);
    }

    /**
     * Test of getStart method, of class MenetrendXMLDAO.
     */
    @Test
    public void testGetStart() throws Exception {
        System.out.println("getStart");
        MenetrendXMLDAO instance = new MenetrendXMLDAO();
        List<Integer> expResult = new ArrayList<>();
        List<Integer> result = instance.getStart();
        expResult.add(1096);
        assertEquals(expResult.get(expResult.size()-1), result.get(result.size()-1));
        // TODO review the generated test code and remove the default call to fail.
        //assertTrue(true);
    }

    /**
     * Test of getMegallo method, of class MenetrendXMLDAO.
     */
    @Test
    public void testGetMegallo() throws Exception {
        System.out.println("getMegallo");
        int buszszam = 1096;
        MenetrendXMLDAO instance = new MenetrendXMLDAO();
        List<Megallo> expResult = new ArrayList<>();
        List<Megallo> result = instance.getMegallo(buszszam);
        expResult.add(new Megallo(3, "Megallo1111"));
        expResult.add(new Megallo(6, "Megallo1024"));
        expResult.add(new Megallo(9, "Megallo1033"));
        assertEquals(expResult.get(0).getMegallo(), result.get(0).getMegallo());
        assertEquals(expResult.get(0).getKeses(), result.get(0).getKeses());
        assertEquals(expResult.get(1).getMegallo(), result.get(1).getMegallo());
        assertEquals(expResult.get(1).getKeses(), result.get(1).getKeses());
        assertEquals(expResult.get(2).getMegallo(), result.get(2).getMegallo());
        assertEquals(expResult.get(2).getKeses(), result.get(2).getKeses());
        // TODO review the generated test code and remove the default call to fail.
        //assertTrue(true);
    }

    /**
     * Test of getBusz method, of class MenetrendXMLDAO.
     */
    @Test
    public void testGetBusz() throws Exception {
        System.out.println("getBusz");
        int buszszam = 1096;
        MenetrendXMLDAO instance = new MenetrendXMLDAO();
        List<Menetrend> expResult = new ArrayList<>();
        List<Menetrend> result = instance.getBusz(buszszam);
        expResult.add(new Menetrend(0,"55 57","55 57","55 57","55 57"));
        expResult.add(new Menetrend(1,"1","1","1","1"));
        expResult.add(new Menetrend(2,"1","1","1","1"));
        
        assertEquals(expResult.get(0).getMunkanap(), result.get(0).getMunkanap());
        assertEquals(expResult.get(1).getMunkanap(), result.get(1).getMunkanap());
        assertEquals(expResult.get(2).getMunkanap(), result.get(2).getMunkanap());
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(true);
    }
    
}
