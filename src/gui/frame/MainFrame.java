package gui.frame;

import gui.panel.PagePanel;

import javax.swing.*;
import java.awt.*;

import static gui.panel.BookPanel.getBookPanel;
import static gui.panel.FunctionPanel.getFunctionPanel;

/**
 * @author mo7984130
 * @Classname MainFrame
 * @Description TODO
 * @Date 2022/2/12 10:46 下午
 */
public class MainFrame extends JFrame {

    private static MainFrame instance = new MainFrame();

    public static MainFrame getMainFrame() { return  instance; }

    private MainFrame(){

        this.setSize(500,450);
        this.setTitle("图书管理");
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        add(getFunctionPanel(), BorderLayout.NORTH);

        add(getBookPanel(), BorderLayout.CENTER);

        add(PagePanel.getPagePanel() , BorderLayout.SOUTH);

        getBookPanel().reset(1);
    }

}
