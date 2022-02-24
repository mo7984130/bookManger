package gui.panel;

import entity.Book;
import unit.DAOUnit;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static gui.panel.InforPanel.getInforPanel;

/**
 * @author mo7984130
 * @Classname BookPanel
 * @Description TODO
 * @Date 2022/2/14 11:44 下午
 */

public class BookPanel extends JPanel {

    private static BookPanel instance = new BookPanel();

    public static BookPanel getBookPanel() { return  instance;}

    ArrayList<Book> books = new ArrayList<>();

    ArrayList<OneBookPanel> oneBookPanels = new ArrayList<>();

    public int page;

    public int lastPage;

    public BookPanel(){
        setLayout(new GridLayout(10, 1));

        lastPage = new DAOUnit<>(new Book()).getTotal(9);
    }

    public void reset(int page){
        this.page = page;

        lastPage = new DAOUnit<>(new Book()).getTotal(9);
        PagePanel.getPagePanel().checkPage();

        reset(new DAOUnit<>(new Book()).list( (page-1)*9 , 9));

        init();
    }

    public void reset(ArrayList<Book> books){
        this.books = books;
        init();
    }

    public void refresh(){
        reset(page);
    }


    public void init(){

        removeAll();

        oneBookPanels.clear();
        
        add(getInforPanel());

        for (Book book : books){
            OneBookPanel oneBookPanel = new OneBookPanel(book);
            oneBookPanels.add(oneBookPanel);
            add(new OneBookPanel(book));
        }

        validate();

        repaint();

    }

}
