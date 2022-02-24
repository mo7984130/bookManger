package dialog;

import entity.Book;
import entity.Students;
import log.Log;
import unit.DAOUnit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import static gui.panel.BookPanel.getBookPanel;

/**
 * @author mo7984130
 * @Classname BorrowBook
 * @Description TODO
 * @Date 2022/2/18 11:07 下午
 */
public class BorrowBookDialog extends JDialog {

    private Book book;


    private JPanel panel2;
    private JLabel lName;
    private JLabel lremark;
    private JButton bCancel;
    private JPanel panel1;
    private JTextField tfName;
    private JTextField tfremark;
    private JButton bBorrow;

    public BorrowBookDialog(JFrame f , Book book){
        super(f , true);
        this.book = book;
    }

    public void showDialog(){

        setTitle("借阅");
        setSize(200, 100);
        setLocationRelativeTo(null);

        panel2 = new JPanel();
        lName = new JLabel();
        lremark = new JLabel();
        bCancel = new JButton();
        panel1 = new JPanel();
        tfName = new JTextField();
        tfremark = new JTextField();
        bBorrow = new JButton();

        setLayout(new GridLayout(1, 2));

        panel2.setLayout(new GridLayout(3, 1));

        lName.setText("姓名");
        panel2.add(lName);

        lremark.setText("备注");
        panel2.add(lremark);

        bCancel.setText("取消");
        bCancel.addActionListener(this::cancel);
        panel2.add(bCancel);

        add(panel2);

        panel1.setLayout(new GridLayout(3, 1));
        panel1.add(tfName);

        panel1.add(tfremark);

        bBorrow.setText("借阅");
        bBorrow.addActionListener(this::borrow);
        panel1.add(bBorrow);

        add(panel1);

        setVisible(true);
    }

    private void cancel(ActionEvent e){
        dispose();
    }

    private void borrow(ActionEvent e){

        String name = tfName.getText();

        book.setBorrower(name);
        if (!Students.existsStudents(name)){
            JOptionPane.showMessageDialog(this, "请输入正确的姓名");
        }else{
            book.setRemark(tfremark.getText());

            book.setBorrower(tfName.getText());

            book.setLendTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

            book.setAvailable(1);

            new DAOUnit<>(book).update(book);

            new Log(book).println("lend");

            getBookPanel().refresh();

            JOptionPane.showMessageDialog(this, "借阅成功");

            dispose();
        }

    }
}
