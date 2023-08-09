package Modelo;

import java.awt.Component;
import java.util.Date;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import com.toedter.calendar.JDateChooser;

/**
 *
 * @author Hitler
 */
public class DateRender extends AbstractCellEditor implements TableCellEditor {

    private JDateChooser dateChooser;

    public DateRender() {
        dateChooser = new JDateChooser();
        dateChooser.getDateEditor().addPropertyChangeListener(evt -> {
            if ("date".equals(evt.getPropertyName())) {
                stopCellEditing();
            }
        });
    }

    @Override
    public Object getCellEditorValue() {

        Date date = dateChooser.getDate();

        if (date != null) {
            long d = date.getTime();
            java.sql.Date fechap = new java.sql.Date(d);
            return fechap;
        } else {
            return null;
        }
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        dateChooser.setDate((Date) value);
        return dateChooser;
    }
}
