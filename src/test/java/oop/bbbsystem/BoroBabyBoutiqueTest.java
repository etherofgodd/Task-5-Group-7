/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package oop.bbbsystem;

import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author samuelandrew
 */
public class BoroBabyBoutiqueTest {

    private final String BBB_FILE_PATH = "data/test/bbb.dat";

    public BoroBabyBoutiqueTest() {
    }

    @BeforeAll
    public static void setUpClass() throws Exception {
        System.out.println("Starting BoroBabyBoutique Tests...");
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
        System.out.println("BoroBabyBoutique Tests Completed.");
    }


    @AfterEach
    public void tearDown() throws Exception {
        Files.deleteIfExists(Paths.get(BBB_FILE_PATH));
    }

    /**
     * Test of loadData method, of class BoroBabyBoutique.
     * This check validates the first element in the file and sees if they match.
     * @throws java.lang.Exception
     */
    @Test
    public void testLoadData() throws Exception {
        System.out.println("loadData - Test if load data is getting values from .bat file");

        BoroBabyBoutique instance = new BoroBabyBoutique();

        // Act: Load the data from the file
        instance.loadData();

        // Assert: Validate the first item matches the expected data
        assertTrue(!instance.getGarments().isEmpty(), "The garments list should contain items");

        Garment firstGarment = instance.getGarments().get(0);
        assertEquals("B_R_12-18_7111", firstGarment.getId(), "The first garment ID should match");
    }
    
     /**
     * Test of loadData method, of class BoroBabyBoutique.
     * @throws java.lang.Exception
     */
    @Test
    public void testEmptyLoadData() throws Exception {
        System.out.println("loadData - Test if load data is getting values from .bat file");

        BoroBabyBoutique instance = new BoroBabyBoutique();

        // Act: Load the data from the file
        instance.loadData();

        // Assert: Validate the first item matches the expected data
        assertTrue(!instance.getGarments().isEmpty(), "The garments list should contain items");

        Garment firstGarment = instance.getGarments().get(0);
        assertEquals("B_R_12-18_7111", firstGarment.getId(), "The first garment ID should match");
    }

}
