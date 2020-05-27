/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author colpv
 */
public final class ModelTable extends AbstractTableModel {

    private ArrayList rows = null;
    private String[] col=null;

    public ModelTable(ArrayList row, String[] col) {
        this.setColumn(col);
        this.setRows(row);
    }

    public void setRows(ArrayList data) {
        this.rows = data;
    }

    public ArrayList getRows() {
        return rows;
    }

    public String[] getColumn() {
        return col;
    }

    public void setColumn(String[] name) {
        this.col = name;
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return col.length;
    }
    

    @Override
    public String getColumnName(int col) {
        return this.col[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Object[] obj = (Object[])this.getRows().get(rowIndex);
       return obj[columnIndex];
    }

}
