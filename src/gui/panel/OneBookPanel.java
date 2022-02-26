package gui.panel;

import dialog.BorrowBookDialog;
import dialog.ManagementDialog;
import dialog.ReturnDialog;
import entity.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static gui.frame.MainFrame.getMainFrame;

/**
 * @author mo7984130
 * @Classname OneBookPanel
 * @Description TODO
 * @Date 2022/2/13 11:31 下午
 */
public class OneBookPanel extends JPanel {

    private Book book;

    public OneBookPanel(Book book) {

        this.book = book;

        setLayout(new GridLayout());

        //---- lBookName ----
        lBookName.setText(book.getBookName());
        lBookName.setHorizontalAlignment(SwingConstants.CENTER);
        add(lBookName);

        //---- lOwner ----
        lOwner.setText(book.getOwner());
        lOwner.setHorizontalAlignment(SwingConstants.CENTER);
        add(lOwner);

        //---- bBorrowBook ----
        bBorrowBook.setText("借书");
        bBorrowBook.setHorizontalAlignment(SwingConstants.CENTER);
        bBorrowBook.addActionListener(this::borrowBook);
        add(bBorrowBook);

        //---- bReturnBook ----
        bReturnBook.setText("还书");
        bReturnBook.setHorizontalAlignment(SwingConstants.CENTER);
        bReturnBook.addActionListener(this::returnBook);
        add(bReturnBook);

        bManagement.setText("管理");
        bManagement.setHorizontalAlignment(SwingConstants.CENTER);
        bManagement.addActionListener(this::showManagement);
        add(bManagement);

        if (book.isAvailable()){
            bReturnBook.setEnabled(false);
        }else{
            bBorrowBook.setEnabled(false);
        }
    }

    public JLabel lBookName = new JLabel();
    public JLabel lOwner = new JLabel();
    public JButton bBorrowBook = new JButton();
    public JButton bReturnBook = new JButton();
    public JButton bManagement = new JButton();

    private void borrowBook(ActionEvent e){
        new BorrowBookDialog(getMainFrame() , book).setVisible(true);
    }

    private void returnBook(ActionEvent e){
        new ReturnDialog(book).setVisible(true);
    }

    private void showManagement(ActionEvent e){
        new ManagementDialog(getMainFrame() , book).setVisible(true);
    }
}
