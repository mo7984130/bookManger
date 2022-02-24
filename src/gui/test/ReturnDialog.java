/*
 * Created by JFormDesigner on Sun Feb 20 23:13:18 CST 2022
 */

package gui.test;

import javax.swing.*;
import java.awt.*;

/**
 * @author unknown
 */
public class ReturnDialog extends JDialog {
    public ReturnDialog(Window owner) {
        super(owner);
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        panel2 = new JPanel();
        lRemake = new JLabel();
        bCancel = new JButton();
        panel1 = new JPanel();
        tfRemake = new JTextField();
        bReturn = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(1, 2));

        //======== panel2 ========
        {
            panel2.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new
            javax.swing.border.EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax
            .swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java
            .awt.Font("D\u0069alog",java.awt.Font.BOLD,12),java.awt
            .Color.red),panel2. getBorder()));panel2. addPropertyChangeListener(new java.beans.
            PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062order".
            equals(e.getPropertyName()))throw new RuntimeException();}});
            panel2.setLayout(new GridLayout(2, 1));

            //---- lRemake ----
            lRemake.setText("\u5907\u6ce8");
            panel2.add(lRemake);

            //---- bCancel ----
            bCancel.setText("\u53d6\u6d88");
            panel2.add(bCancel);
        }
        contentPane.add(panel2);

        //======== panel1 ========
        {
            panel1.setLayout(new GridLayout(2, 1));
            panel1.add(tfRemake);

            //---- bReturn ----
            bReturn.setText("\u5f52\u8fd8");
            panel1.add(bReturn);
        }
        contentPane.add(panel1);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel panel2;
    private JLabel lRemake;
    private JButton bCancel;
    private JPanel panel1;
    private JTextField tfRemake;
    private JButton bReturn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
