package gui.panel;

import dialog.AddDialog;
import dialog.LogDialog;
import log.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static gui.frame.MainFrame.getMainFrame;

/**
 * @author mo7984130
 * @Classname FuntionPanel
 * @Description TODO
 * @Date 2022/2/12 10:56 下午
 */
public class FunctionPanel extends JPanel {

    private static FunctionPanel instance = new FunctionPanel();

    public static FunctionPanel getFunctionPanel() { return  instance; }

    private FunctionPanel(){
        setLayout(new GridLayout(1, 5));

        bRefresh.setText("刷新");
        bRefresh.addActionListener(this::refresh);
        add(bRefresh);

        bAdd.setText("添加");
        bAdd.addActionListener(this::addBook);
        add(bAdd);

        bDelete.setText("删除");
        add(bDelete);

        bLog.setText("日志");
        bLog.addActionListener(this::log);
        add(bLog);
    }

    private JButton bRefresh = new JButton();
    private JButton bAdd = new JButton();
    private JButton bDelete = new JButton();
    private JButton bLog = new JButton();

    private void addBook(ActionEvent e){
        new AddDialog(getMainFrame()).showDialog();
    }

    private void refresh(ActionEvent e){
        BookPanel.getBookPanel().refresh();
    }

    private void log(ActionEvent e){
        new LogDialog(Log.getAllLogFile()).reset(1);
    }
}
