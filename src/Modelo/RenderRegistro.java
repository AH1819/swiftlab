package Modelo;

import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.util.Date;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class RenderRegistro extends AbstractCellEditor implements TableCellEditor {

    private JDateChooser dateChooser;

    public RenderRegistro() {
        dateChooser = new JDateChooser();
    }

    @Override
    public Object getCellEditorValue() {
        return dateChooser.getDate();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        
        if (value instanceof Date) {
            dateChooser.setDate((Date) value);
        } else {
            dateChooser.setDate(null);
        }
        return dateChooser;
    }
}
