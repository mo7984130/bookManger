/*
 * Created by JFormDesigner on Thu Feb 17 23:56:07 CST 2022
 */

package gui.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author unknown
 */
public class AddDialog extends JDialog {
    public AddDialog(Window owner) {
        super(owner);
        initComponents();
    }

    private void save(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        panel2 = new JPanel();
        lBookName = new JLabel();
        lOwner = new JLabel();
        lType = new JLabel();
        lremark = new JLabel();
        bCancel = new JButton();
        panel1 = new JPanel();
        tfBookName = new JTextField();
        tfOwner = new JTextField();
        tfType = new JTextField();
        tfremark = new JTextField();
        bSave = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(1, 2));

        //======== panel2 ========
        {
            panel2.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder
            (0,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion",javax.swing.border.TitledBorder.CENTER,javax.swing.border
            .TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt
            .Color.red),panel2. getBorder()));panel2. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void
            propertyChange(java.beans.PropertyChangeEvent e){if("bord\u0065r".equals(e.getPropertyName()))throw new RuntimeException()
            ;}});
            panel2.setLayout(new GridLayout(5, 1));

            //---- lBookName ----
            lBookName.setText("\u4e66\u540d");
            panel2.add(lBookName);

            //---- lOwner ----
            lOwner.setText("\u6240\u6709\u8005");
            panel2.add(lOwner);

            //---- lType ----
            lType.setText("\u7c7b\u578b(\"\uff0c\"\u5206\u5272)");
            panel2.add(lType);

            //---- lremark ----
            lremark.setText("\u5907\u6ce8");
            panel2.add(lremark);

            //---- bCancel ----
            bCancel.setText("\u53d6\u6d88");
            panel2.add(bCancel);
        }
        contentPane.add(panel2);

        //======== panel1 ========
        {
            panel1.setLayout(new GridLayout(5, 1));
            panel1.add(tfBookName);
            panel1.add(tfOwner);
            panel1.add(tfType);
            panel1.add(tfremark);

            //---- bSave ----
            bSave.setText("\u4fdd\u5b58");
            bSave.addActionListener(e -> save(e));
            panel1.add(bSave);
        }
        contentPane.add(panel1);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel panel2;
    private JLabel lBookName;
    private JLabel lOwner;
    private JLabel lType;
    private JLabel lremark;
    private JButton bCancel;
    private JPanel panel1;
    private JTextField tfBookName;
    private JTextField tfOwner;
    private JTextField tfType;
    private JTextField tfremark;
    private JButton bSave;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
