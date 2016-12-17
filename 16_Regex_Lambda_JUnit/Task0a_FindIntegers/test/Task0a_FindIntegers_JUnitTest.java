/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author AlexT
 */
public class Task0a_FindIntegers_JUnitTest {
    private static int _count = 0;
    
    public Task0a_FindIntegers_JUnitTest() {
    }
    
   @BeforeClass
    public static void setUpClass() {
        System.out.println("Setting up test class.");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Tearing down test class.");
    }

    @Before
    public void setUp() {
        System.out.println("Setting up for test No. " + (++_count));
    }

    @After
    public void tearDown() {
        System.out.println("Tearing down after test No. " + _count);
    }


    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
