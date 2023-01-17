package Other;

import javax.swing.table.DefaultTableModel;

public class MyDefaultTableModel extends DefaultTableModel {

    public MyDefaultTableModel(String[] strings, int size) {
        super(strings, size);
    }

    public MyDefaultTableModel(Object[][] strings, String[] size) {
        super(strings, size);
    }

    public MyDefaultTableModel(Object[] strings, int size) {
        super(strings, size);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
