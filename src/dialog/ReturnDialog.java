package dialog;

import entity.Book;
import gui.panel.BookPanel;
import log.Log;
import unit.DAOUnit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author mo7984130
 * @Classname ReturnDialog
 * @Description TODO
 * @Date 2022/2/20 11:12 下午
 */
public class ReturnDialog extends JDialog {

    private Book book;

    public ReturnDialog(Book book) {
        this.book = book;

        setTitle("归还");
        setSize(200, 100);
        setLocationRelativeTo(null);

        panel2 = new JPanel();
        lremark = new JLabel();
        bCancel = new JButton();
        panel1 = new JPanel();
        tfremark = new JTextField();
        bReturn = new JButton();

        setLayout(new GridLayout(1, 2));

        panel2.setLayout(new GridLayout(2, 1));

        lremark.setText("备注");
        panel2.add(lremark);

        bCancel.setText("取消");
        bCancel.addActionListener(e ->{
            dispose();
        });
        panel2.add(bCancel);

        add(panel2);

        panel1.setLayout(new GridLayout(2, 1));
        panel1.add(tfremark);

        bReturn.setText("归还");
        bReturn.addActionListener(this::returnBook);
        panel1.add(bReturn);

        add(panel1);
    }

    private void returnBook(ActionEvent e){
        book.setReturnTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        book.setAvailable(0);
        book.setRemark(tfremark.getText());

        new Log(book).println("return");

        book.setBorrower(null);

        new DAOUnit<>(book).update(book);
        JOptionPane.showMessageDialog(this , "归还成功！");
        BookPanel.getBookPanel().refresh();

        dispose();
    }

    private JPanel panel2;
    private JLabel lremark;
    private JButton bCancel;
    private JPanel panel1;
    private JTextField tfremark;
    private JButton bReturn;

}
