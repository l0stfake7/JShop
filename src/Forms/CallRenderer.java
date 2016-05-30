package Forms;

import javax.swing.*;
import java.awt.*;

/**
 * Created by bartek on 30.05.16.
 */
class CallRenderer extends JLabel implements ListCellRenderer {
    public Component getListCellRendererComponent(JList list, Object value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        Component c = null;
        if (value == null) {
            c = new JLabel("(null)");
        } else if (value instanceof Component) {
            c = (Component) value;
        } else {
            c = new JLabel(value.toString());
        }

        if (isSelected) {
            c.setBackground(list.getSelectionBackground());
            c.setForeground(list.getSelectionForeground());
        } else {
            c.setBackground(list.getBackground());
            c.setForeground(list.getForeground());
        }

        if (c instanceof JComponent) {
            ((JComponent) c).setOpaque(true);
        }

        return c;
    }
}
