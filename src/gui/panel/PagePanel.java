package gui.panel;

import entity.Book;
import unit.DAOUnit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * @author mo7984130
 * @Classname PagePanel
 * @Description TODO
 * @Date 2022/2/19 11:29 下午
 */
public class PagePanel extends JPanel {
    
    private static PagePanel instance = new PagePanel();
    
    public static PagePanel getPagePanel(){
        return instance;
    }

    private BookPanel bookPanel;
    
    private PagePanel(){
        setLayout(new GridLayout(1, 5));

        bFirstPage = new JButton();
        bPreviousPage = new JButton();
        tfSearch = new JTextField();
        bSearch = new JButton();
        bNextPage = new JButton();
        bLastPage = new JButton();
        
        bFirstPage.setText("首页");
        bFirstPage.addActionListener(this::firstPage);
        add(bFirstPage);
        
        bPreviousPage.setText("上一页");
        bPreviousPage.addActionListener(this::previousPage);
        add(bPreviousPage);
        add(tfSearch);

        bSearch.setText("搜索");
        bSearch.addActionListener(this::search);
        add(bSearch);

        
        bNextPage.setText("下一页");
        bNextPage.addActionListener(this::nextPage);
        add(bNextPage);

        bLastPage.setText("尾页");
        bLastPage.addActionListener(this::lastPage);
        add(bLastPage);

        bookPanel = BookPanel.getBookPanel();

        checkPage();
    }

    private void firstPage(ActionEvent e){
        bookPanel.reset(1);
        checkPage();
    }

    private void previousPage(ActionEvent e){
        bookPanel.reset(bookPanel.page - 1);
        checkPage();
    }

    private  void nextPage(ActionEvent e){
        bookPanel.reset(bookPanel.page + 1);
        checkPage();
    }

    private void lastPage(ActionEvent e){
        bookPanel.reset(bookPanel.lastPage);
        checkPage();
    }

    public void checkPage(){
        if(bookPanel.page == 1){
            bFirstPage.setEnabled(false);
            bPreviousPage.setEnabled(false);

            bNextPage.setEnabled(true);
            bLastPage.setEnabled(true);
        }else if(bookPanel.page == bookPanel.lastPage){
            bFirstPage.setEnabled(true);
            bPreviousPage.setEnabled(true);

            bNextPage.setEnabled(false);
            bLastPage.setEnabled(false);
        }else{
            bFirstPage.setEnabled(true);
            bPreviousPage.setEnabled(true);

            bNextPage.setEnabled(true);
            bLastPage.setEnabled(true);
        }
    }

    private void search(ActionEvent e){
        ArrayList<Book> books = new DAOUnit<Book>(new Book()).fuzzySearchByOne(tfSearch.getText() , new String[]{"bookName" , "owner" , "borrower" , "type" , "isAvailable"});

        BookPanel.getBookPanel().reset(books);
    }

    private JButton bFirstPage;
    private JButton bPreviousPage;
    private JTextField tfSearch;
    private JButton bSearch;
    private JButton bNextPage;
    private JButton bLastPage;
}
