/*
 * Created by JFormDesigner on Fri Feb 18 23:08:22 CST 2022
 */

package gui.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author unknown
 */
public class BorrowDialog extends JDialog {
    public BorrowDialog(Window owner) {
        super(owner);
        initComponents();
    }

    private void borrow(ActionEvent e) {



    }

    private void cancel(ActionEvent e) {
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        panel2 = new JPanel();
        lName = new JLabel();
        lremark = new JLabel();
        bCancel = new JButton();
        panel1 = new JPanel();
        tfName = new JTextField();
        tfremark = new JTextField();
        bBorrow = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(1, 2));

        //======== panel2 ========
        {
            panel2.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(
            new javax.swing.border.EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion"
            ,javax.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM
            ,new java.awt.Font("D\u0069alog",java.awt.Font.BOLD,12)
            ,java.awt.Color.red),panel2. getBorder()));panel2. addPropertyChangeListener(
            new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e
            ){if("\u0062order".equals(e.getPropertyName()))throw new RuntimeException()
            ;}});
            panel2.setLayout(new GridLayout(3, 1));

            //---- lName ----
            lName.setText("\u59d3\u540d");
            panel2.add(lName);

            //---- lremark ----
            lremark.setText("\u5907\u6ce8");
            panel2.add(lremark);

            //---- bCancel ----
            bCancel.setText("\u53d6\u6d88");
            bCancel.addActionListener(e -> cancel(e));
            panel2.add(bCancel);
        }
        contentPane.add(panel2);

        //======== panel1 ========
        {
            panel1.setLayout(new GridLayout(3, 1));
            panel1.add(tfName);
            panel1.add(tfremark);

            //---- bBorrow ----
            bBorrow.setText("\u501f\u9605");
            bBorrow.addActionListener(e -> borrow(e));
            panel1.add(bBorrow);
        }
        contentPane.add(panel1);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel panel2;
    private JLabel lName;
    private JLabel lremark;
    private JButton bCancel;
    private JPanel panel1;
    private JTextField tfName;
    private JTextField tfremark;
    private JButton bBorrow;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
