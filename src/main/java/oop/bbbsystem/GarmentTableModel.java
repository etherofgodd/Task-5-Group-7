/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.bbbsystem;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.table.AbstractTableModel;

/**
 * Garment table model class created extending the AbstractTableModel from swing
 *
 * @author samuelandrew
 */
public class GarmentTableModel extends AbstractTableModel {

    // attributes
    private Object[][] garmentData;
    private String[] columnsIdentifiers;

    /**
     * Constructor of the table model, accepts the column names as identifiers
     * and the list of garments gotten from the loadData method
     *
     * @param columnsIdentifiers
     * @param garments
     */
    public GarmentTableModel(final String[] columnsIdentifiers, ArrayList<Garment> garments) {
        int columnNamesLength = columnsIdentifiers.length;
        this.columnsIdentifiers = Arrays.copyOf(columnsIdentifiers, columnNamesLength);
        int rowLength = garments.size();
        garmentData = new Object[rowLength][columnNamesLength];

        // using this loop to set the elements/items in the garment data object.
        for (int index = 0; index < garments.size(); index++) {
            // extract fields needed
            String make = garments.get(index).getMake();
            String garment = garments.get(index).getGarment();
            String gender = garments.get(index).getGender();
            String size = garments.get(index).getSize();
            String colour = garments.get(index).getColour();
            String material = garments.get(index).getMaterial();
            String price = garments.get(index).getFormattedPrice();
            int stock = garments.get(index).getStock();
            Object[] dataRow = new Object[]{make, garment, gender, size, colour, material, price, stock};
            garmentData[index] = Arrays.copyOf(dataRow, columnNamesLength);
        }
    }

    @Override
    public int getRowCount() {
        return garmentData.length;
    }

    @Override
    public int getColumnCount() {
        return columnsIdentifiers.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return garmentData[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        garmentData[rowIndex][columnIndex] = value;
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnsIdentifiers[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

}
