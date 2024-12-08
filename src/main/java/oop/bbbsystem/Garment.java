/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.bbbsystem;

/**
 * This is BBB data class and it represents the Garment entries with the
 * following attributes ID, price, description, material, and stock. It provides
 * functionality to retrieve and manipulate garment-related data, including ID
 * parsing for gender and size, price formatting, and stock adjustments.
 *
 * <p>
 * Service methods:
 * <ul>
 * <li>getGender: Extracting gender and size information from the garment
 * ID</li>
 * <li>getFormattedPrice: Formatting price in pounds and pence</li>
 * <li>getFileName: Generating a file name based on the garment ID</li>
 * <li>incrementStock,decrementStock: Stock management (increment and
 * decrement)</li>
 * <li>calculateTotalSale: Calculating the total sale for a given quantity</li>
 * </ul>
 *
 * <p>
 *
 * @author Samuel Andrew
 */
public class Garment {

    // fields
    private String id;
    private int price;
    private String garment;
    private String make;
    private String colour;
    private String description;
    private String material;
    private int stock;

    public Garment(
            String id,
            int price,
            String garment,
            String make,
            String colour,
            String description,
            String material,
            int stock) {
        this.id = id;
        this.price = price;
        this.garment = garment;
        this.make = make;
        this.colour = colour;
        this.description = description;
        this.material = material;
        this.stock = stock;
    }

    // Getters
    public String getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getGarment() {
        return garment;
    }

    public String getMake() {
        return make;
    }

    public String getColour() {
        return colour;
    }

    public String getDescription() {
        return description;
    }

    public String getMaterial() {
        return material;
    }

    public int getStock() {
        return stock;
    }

    // Here is the only mutator method; 
    public void setPrice(int price) {
        this.price = price;
    }

    // Service methods appears below.
    // Service method to extract Gender from the ID;
    public String getGender() {
        String[] idTokens = this.id.split("_");
        if (idTokens.length > 0) {
            return switch (idTokens[0]) {
                case "B" ->
                    "Boys";
                case "G" ->
                    "Girls";
                case "U" ->
                    "Unisex";
                default ->
                    "Gender N/A";
            };
        }
        return "N/A";
    }

    // Service method to extract Size from the ID
    public String getSize() {
        String[] idTokens = this.id.split("_");
        if (idTokens.length >= 2) {
            return switch (idTokens[2]) {
                case "0-3" ->
                    "Newborn to 3 months";
                case "3-6" ->
                    "3 to 6 months";
                case "6-9" ->
                    "6 to 9 months";
                case "6-12" ->
                    "6 to 12 months";
                case "9-12" ->
                    "9 to 12 months";
                case "12-18" ->
                    "12 to 18 months";
                case "18-24" ->
                    "18 to 24 months";
                default ->
                    "Size N/A";
            };
        }
        return "N/A";
    }

    // Service method to get the formated price
    public String getFormattedPrice() {
        double priceInPounds = this.price / 100.00;
        return String.format("£%.2f", priceInPounds);
    }

    // Service method to get file name
    public String getFileName() {
        return this.id + ".jpg";
    }

    // Function to increment/increase stock
    public void incrementStock(int value) {
        this.stock += value;
    }

    // Function to decrement/reduce stock
    public void decrementStock(int value) {
        this.stock -= value;
    }

    // Service method to get total sale, and use the getFormattedPrice method as specified in the document.
    public String calculateTotalSale(int quantity) {
        int totalSale = this.price * quantity;
        Garment newGarment = new Garment(id, totalSale, garment, make, colour, description, material, stock);
        return newGarment.getFormattedPrice();
    }

}
