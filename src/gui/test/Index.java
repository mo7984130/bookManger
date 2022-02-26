/*
 * Created by JFormDesigner on Sat Feb 12 22:51:38 CST 2022
 */

package gui.test;

import dialog.AddDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static gui.frame.MainFrame.getMainFrame;

/**
 * @author unknown
 */
public class Index {
    public Index() {
        initComponents();
    }

    private void add(ActionEvent e) {
        new AddDialog(getMainFrame()).setVisible(true);
    }

    private void borroBook(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        mainPanel = new JPanel();
        funtionPanel = new JPanel();
        bSelected = new JButton();
        bAdd = new JButton();
        bDelete = new JButton();
        bLog = new JButton();
        bookPanel = new JPanel();
        inforPanel = new JPanel();
        lIsSelected = new JLabel();
        label4 = new JLabel();
        label3 = new JLabel();
        label1 = new JLabel();
        label2 = new JLabel();
        oneBookPanel = new JPanel();
        isSelected = new JCheckBox();
        lBookName = new JLabel();
        lOwner = new JLabel();
        bBorroBook = new JButton();
        bReturnBook = new JButton();
        pagePanel = new JPanel();
        bFirstPage = new JButton();
        bPreviousPage = new JButton();
        tfPage = new JTextField();
        bSearch = new JButton();
        bNextPage = new JButton();
        bLastPage = new JButton();

        //======== mainPanel ========
        {
            mainPanel.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing
            . border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e", javax. swing. border. TitledBorder
            . CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dialo\u0067" ,java .
            awt .Font .BOLD ,12 ), java. awt. Color. red) ,mainPanel. getBorder( )) )
            ; mainPanel. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
            ) {if ("borde\u0072" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} )
            ;
            mainPanel.setLayout(new BorderLayout());

            //======== funtionPanel ========
            {
                funtionPanel.setLayout(new GridLayout(1, 5));

                //---- bSelected ----
                bSelected.setText("\u5237\u65b0");
                funtionPanel.add(bSelected);

                //---- bAdd ----
                bAdd.setText("\u6dfb\u52a0");
                bAdd.addActionListener(e -> add(e));
                funtionPanel.add(bAdd);

                //---- bDelete ----
                bDelete.setText("\u5220\u9664");
                funtionPanel.add(bDelete);

                //---- bLog ----
                bLog.setText("\u65e5\u5fd7");
                funtionPanel.add(bLog);
            }
            mainPanel.add(funtionPanel, BorderLayout.NORTH);

            //======== bookPanel ========
            {
                bookPanel.setLayout(new GridLayout(10, 1));

                //======== inforPanel ========
                {
                    inforPanel.setLayout(new GridLayout(1, 5));

                    //---- lIsSelected ----
                    lIsSelected.setText("\u662f\u5426\u88ab\u9009\u4e2d");
                    inforPanel.add(lIsSelected);

                    //---- label4 ----
                    label4.setText("\u4e66\u540d");
                    inforPanel.add(label4);

                    //---- label3 ----
                    label3.setText("\u6240\u6709\u4eba");
                    inforPanel.add(label3);

                    //---- label1 ----
                    label1.setText("\u501f\u4e66");
                    inforPanel.add(label1);

                    //---- label2 ----
                    label2.setText("\u8fd8\u4e66");
                    inforPanel.add(label2);
                }
                bookPanel.add(inforPanel);

                //======== oneBookPanel ========
                {
                    oneBookPanel.setLayout(new GridLayout(1, 5));

                    //---- isSelected ----
                    isSelected.setHorizontalAlignment(SwingConstants.CENTER);
                    oneBookPanel.add(isSelected);

                    //---- lBookName ----
                    lBookName.setText("bookName");
                    lBookName.setHorizontalAlignment(SwingConstants.CENTER);
                    oneBookPanel.add(lBookName);

                    //---- lOwner ----
                    lOwner.setText("owner");
                    oneBookPanel.add(lOwner);

                    //---- bBorroBook ----
                    bBorroBook.setText("\u501f\u4e66");
                    bBorroBook.addActionListener(e -> borroBook(e));
                    oneBookPanel.add(bBorroBook);

                    //---- bReturnBook ----
                    bReturnBook.setText("\u8fd8\u4e66");
                    oneBookPanel.add(bReturnBook);
                }
                bookPanel.add(oneBookPanel);
            }
            mainPanel.add(bookPanel, BorderLayout.CENTER);

            //======== pagePanel ========
            {
                pagePanel.setLayout(new GridLayout(1, 5));

                //---- bFirstPage ----
                bFirstPage.setText("\u9996\u9875");
                pagePanel.add(bFirstPage);

                //---- bPreviousPage ----
                bPreviousPage.setText("\u4e0a\u4e00\u9875");
                pagePanel.add(bPreviousPage);
                pagePanel.add(tfPage);

                //---- bSearch ----
                bSearch.setText("\u641c\u7d22");
                pagePanel.add(bSearch);

                //---- bNextPage ----
                bNextPage.setText("\u4e0b\u4e00\u9875");
                pagePanel.add(bNextPage);

                //---- bLastPage ----
                bLastPage.setText("\u5c3e\u9875");
                pagePanel.add(bLastPage);
            }
            mainPanel.add(pagePanel, BorderLayout.SOUTH);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel mainPanel;
    private JPanel funtionPanel;
    private JButton bSelected;
    private JButton bAdd;
    private JButton bDelete;
    private JButton bLog;
    private JPanel bookPanel;
    private JPanel inforPanel;
    private JLabel lIsSelected;
    private JLabel label4;
    private JLabel label3;
    private JLabel label1;
    private JLabel label2;
    private JPanel oneBookPanel;
    private JCheckBox isSelected;
    private JLabel lBookName;
    private JLabel lOwner;
    private JButton bBorroBook;
    private JButton bReturnBook;
    private JPanel pagePanel;
    private JButton bFirstPage;
    private JButton bPreviousPage;
    private JTextField tfPage;
    private JButton bSearch;
    private JButton bNextPage;
    private JButton bLastPage;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public int page = 0;
}
