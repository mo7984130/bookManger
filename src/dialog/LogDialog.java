package dialog;

import gui.frame.MainFrame;
import gui.panel.LogPagePanel;
import log.Log;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

/**
 * @author mo7onePageOfNumber84130
 * @Classname LogDialog
 * @Description TODO
 * @Date 2022/2/20 11:38 下午
 */
public class LogDialog extends JDialog {


    ArrayList<String> logs;

    ArrayList<String> shows = new ArrayList<>();

    public int page = 1;

    public int lastPage;

    private LogPagePanel logPagePanel;

    private JTextArea showPanel;
    
    private final int onePageOfNumber = 10;

    public LogDialog(File logFile){
        super(MainFrame.getMainFrame() , true);

        setTitle("日志");
        setSize(1000, 500);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        logs = Log.read(logFile);

        int total = logs.size();
        lastPage = 0;

        total -= onePageOfNumber;
        lastPage++;

        while (total > 0){
            total -= onePageOfNumber;
            lastPage++;
        }

        this.logPagePanel = new LogPagePanel(this);
        logPagePanel.checkPage();

        add(logPagePanel , BorderLayout.SOUTH);

        showPanel = new JTextArea();
        showPanel.setLineWrap(true);
        showPanel.setEditable(false);
        showPanel.setFont(new Font("宋体", Font.BOLD, 30));

        add(showPanel , BorderLayout.CENTER);

        reset(page);
    }

    public void reset(int page){
        this.page = page;

        logPagePanel.checkPage();

        int start = (page-1)*onePageOfNumber;
        int end = page*onePageOfNumber;

        shows.clear();

        for (int i = start; i <= end; i++){

            if (i == logs.size()){
                break;
            }

            shows.add(logs.get(i));

        }

        init();
    }

    public void reset(ArrayList<String> log){
        this.shows = log;
        init();
    }

    public void init(){

        showPanel.setText("");

        for (String log : shows){
            showPanel.append(log + "\r\n");
        }

    }

}
