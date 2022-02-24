package gui.panel;

import javax.swing.*;
import java.awt.*;

/**
 * @author mo7984130
 * @Classname InforPanel
 * @Description TODO
 * @Date 2022/2/17 11:36 下午
 */
public class InforPanel extends JPanel {

    private static InforPanel instance = new InforPanel();

    public static InforPanel getInforPanel() {return instance;}

    private  InforPanel(){
        setLayout(new GridLayout(1, 5));

        lIsSelected.setText("是否被选中");
        lIsSelected.setHorizontalAlignment(SwingConstants.CENTER);
        add(lIsSelected);

        lBookName.setText("书名");
        lBookName.setHorizontalAlignment(SwingConstants.CENTER);
        add(lBookName);

        lOwner.setText("所有者");
        lOwner.setHorizontalAlignment(SwingConstants.CENTER);
        add(lOwner);

        lBorrowBook.setText("借书");
        lBorrowBook.setHorizontalAlignment(SwingConstants.CENTER);
        add(lBorrowBook);

        lReturnBook.setText("还书");
        lReturnBook.setHorizontalAlignment(SwingConstants.CENTER);
        add(lReturnBook);
    }

    private JLabel lIsSelected = new JLabel();
    private JLabel lBookName = new JLabel();
    private JLabel lOwner = new JLabel();
    private JLabel lBorrowBook = new JLabel();
    private JLabel lReturnBook = new JLabel();

}
