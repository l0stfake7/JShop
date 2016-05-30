package Forms;

import javax.swing.*;
import javax.swing.event.ListDataListener;

/**
 * Created by bartek on 30.05.16.
 */
class StaticListModel implements ListModel {
    private final Object[] data = { "Hello", new Object(), new java.util.Date(),
            new JLabel("Hello world!"), this, };

    public Object getElementAt(int index) {
        return data[index];
    }

    public int getSize() {
        return data.length;
    }

    public void addListDataListener(ListDataListener ldl) {
    }

    public void removeListDataListener(ListDataListener ldl) {
    }
}