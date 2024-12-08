/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.bbbsystem;

/**
 * Adaptor class made following the Adaptor design pattern.
 *
 * @author samuelandrew
 */
public class Adaptor extends Garment {

    /**
     * Constructor takes PoshTees as a parameter
     *
     * @param poshTees
     */
    public Adaptor(PoshTees poshTees) {
        super(
                generateIdFromPosh(poshTees.getNotes(), poshTees.getStockCode(), poshTees.getSize()),
                // convert double value to pence, this is what Garment expects.
                (int) (poshTees.getPrice() * 100),
                poshTees.getProduct(),
                poshTees.getLabel(),
                poshTees.getNotes().split(";")[0].trim(),
                poshTees.getNotes().split(";")[2].trim(),
                poshTees.getNotes().split(";")[3].trim(),
                poshTees.getStock()
        );
    }

    /**
     * This method is use the generate the accurate id that Garment class can
     * use to generate fields that it needs.
     *
     * @param notes
     * @param stockCode
     * @param size
     * @return
     */
    private static String generateIdFromPosh(String notes, String stockCode, String size) {
        String gender = notes.split(";")[1].trim();
        String genderToken = gender.equalsIgnoreCase("Boys") ? "B"
                : gender.equalsIgnoreCase("Girls") ? "G" : "U";
        String numberSection = stockCode.replaceAll("[^0-9]", "");
        String otherSection = stockCode.split("[0-9]+")[0];
        String genId = String.format("%s_%s_%s_%s", genderToken, otherSection, size, numberSection);
        return genId;
    }

}
