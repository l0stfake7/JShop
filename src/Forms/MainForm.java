package Forms;

import javax.swing.*;
import java.awt.*;

/**
 * Created by bartek on 30.05.16.
 */
public class MainForm extends JFrame {
    private JList listCustomer;
    private JButton buttonAddCustomer;
    private JButton buttonEditCustomer;
    private JButton buttonRemoveCustomer;

    public MainForm() {
        //settings
        setSize(400, 300);
        setTitle("Main Form");
        setLayout(null);

        ListModel listModel = new StaticListModel();
        listCustomer = new JList();
        listCustomer.setSize(new Dimension(200, 300));
        listCustomer.setModel(listModel);
        listCustomer.setCellRenderer(new CallRenderer());
        listCustomer.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(listCustomer);

        buttonAddCustomer = new JButton();
        buttonAddCustomer.setBounds(215, 15, 175, 25);
        buttonAddCustomer.setText("Add Customer");
        add(buttonAddCustomer);

        buttonEditCustomer = new JButton();
        buttonEditCustomer.setBounds(215, 55, 175, 25);
        buttonEditCustomer.setText("Edit Customer");
        add(buttonEditCustomer);

        buttonRemoveCustomer = new JButton();
        buttonRemoveCustomer.setBounds(215, 95, 175, 25);
        buttonRemoveCustomer.setText("Remove Customer");
        add(buttonRemoveCustomer);

        //set visible, add close operator
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


