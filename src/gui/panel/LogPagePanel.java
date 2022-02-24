package gui.panel;

import dialog.LogDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LogPagePanel extends JPanel {
    
    private LogDialog logDialog;

    public LogPagePanel(LogDialog logDialog){
        setLayout(new GridLayout(1, 5));

        bFirstPage = new JButton();
        bPreviousPage = new JButton();

        bNextPage = new JButton();
        bLastPage = new JButton();

        bFirstPage.setText("首页");
        bFirstPage.addActionListener(this::firstPage);
        add(bFirstPage);

        bPreviousPage.setText("上一页");
        bPreviousPage.addActionListener(this::previousPage);
        add(bPreviousPage);


        bNextPage.setText("下一页");
        bNextPage.addActionListener(this::nextPage);
        add(bNextPage);

        bLastPage.setText("尾页");
        bLastPage.addActionListener(this::lastPage);
        add(bLastPage);

        this.logDialog = logDialog;

        checkPage();
    }

    private void firstPage(ActionEvent e){
        logDialog.reset(1);
        checkPage();
    }

    private void previousPage(ActionEvent e){
        logDialog.reset(logDialog.page - 1);
        checkPage();
    }

    private  void nextPage(ActionEvent e){
        logDialog.reset(logDialog.page + 1);
        checkPage();
    }

    private void lastPage(ActionEvent e){
        logDialog.reset(logDialog.lastPage);
        checkPage();
    }

    public void checkPage(){
        bFirstPage.setEnabled(true);
        bPreviousPage.setEnabled(true);

        bNextPage.setEnabled(true);
        bLastPage.setEnabled(true);

        if(logDialog.page == 1){
            bFirstPage.setEnabled(false);
            bPreviousPage.setEnabled(false);
        }
        if(logDialog.page == logDialog.lastPage){
            bNextPage.setEnabled(false);
            bLastPage.setEnabled(false);
        }

    }

    private JButton bFirstPage;
    private JButton bPreviousPage;
    private JButton bNextPage;
    private JButton bLastPage;

}
