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
 * @Classname AddDialog
 * @Description TODO
 * @Date 2022/2/17 11:53 下午
 */
public class AddDialog extends JDialog {

    public AddDialog(JFrame f){
        super(f);

        setTitle("添加书籍");
        setSize(400, 300);
        setLocationRelativeTo(null);

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

        setLayout(new GridLayout(1, 2));
        panel2.setLayout(new GridLayout(5, 1));

        lBookName.setText("书名");
        panel2.add(lBookName);

        lOwner.setText("所有者");
        panel2.add(lOwner);

        lType.setText("类型");
        panel2.add(lType);

        lremark.setText("备注");
        panel2.add(lremark);

        bCancel.setText("取消");
        bCancel.addActionListener(e ->{
            this.dispose();
        });
        panel2.add(bCancel);

        add(panel2);

        panel1.setLayout(new GridLayout(5, 1));
        panel1.add(tfBookName);
        panel1.add(tfOwner);
        panel1.add(tfType);
        panel1.add(tfremark);

        bSave.setText("保存");
        bSave.addActionListener(this::save);
        panel1.add(bSave);

        add(panel1);
    }

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

    private void save(ActionEvent e) {
        Book book = new Book();
        book.setBookName(tfBookName.getText());
        book.setOwner(tfOwner.getText());

        if (!Students.existsStudents(tfOwner.getText())){
            JOptionPane.showMessageDialog(this, "请输入正确的姓名");
            return;
        }

        book.setRemark(tfremark.getText());
        book.setType(tfType.getText());
        book.setAddTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        new DAOUnit<>(book).add(book);

        new Log(book).println("add");

        getBookPanel().refresh();

        JOptionPane.showMessageDialog(this, "添加成功");

        dispose();
    }
}
