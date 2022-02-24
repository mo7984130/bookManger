package log;

import entity.Book;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Log {

    Book book;

    public File logFile;

    File allLogFile;

    public Log(Book book) {
        this.book = book;

        logFile = new File(getLogFilePath() + book.getBookName() + "_" + book.getOwner() + ".txt");

        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        initAllLogFile();
    }

    public static ArrayList<String> read(File file){

        ArrayList<String> log = new ArrayList<>();

        try (
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr)
        ){

            while(true){
                String line = br.readLine();
                if (null == line){
                    break;
                }

                log.add(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return log;

    }

    public void println(String type) {
        String message = "《%s》 被 %s %s 于 %s (备注:%s)";
        if ("add".equals(type)) {
            message = String.format(message, book.getBookName(), book.getOwner() , "添加" , book.getAddTime(),  book.getRemark());
        } else if ("lend".equals(type)) {
            message = String.format(message, book.getBookName(), book.getBorrower() , "借走" , book.getLendTime(), book.getRemark());
        } else if ("return".equals(type)) {
            message = String.format(message, book.getBookName(), book.getBorrower() , "归还" , book.getReturnTime(), book.getRemark());
        }
        ArrayList<String> lines = read(logFile);
        PrintWriter pw = getPrintWriter(logFile);
        for (String line : lines){
            pw.println(line);
        }
        pw.println(message);
        pw.flush();
        pw.close();

        printlnToAllLogFile(message);
    }


    private void printlnToAllLogFile(String message){

        ArrayList<String> lines = read(allLogFile);
        PrintWriter pw = getPrintWriter(allLogFile);
        for(String line : lines){
            pw.println(line);
        }

        pw.println(message);

        pw.flush();

        pw.close();

    }

    private void initAllLogFile(){
        String date = new SimpleDateFormat("yyyy-MM").format(new Date());
        allLogFile = new File(getLogFilePath() + date);

        if (!allLogFile.exists()){
            allLogFile.mkdirs();
        }

        allLogFile = new File(allLogFile , new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ".txt");

        if (!allLogFile.exists()){
            try {
                allLogFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String getLogFilePath() {
        return Log.class.getResource("/log").getPath() + File.separator;
    }

    private PrintWriter getPrintWriter(File file) {

        PrintWriter pw = null;

        try {
            FileWriter ous = new FileWriter(file);
            pw = new PrintWriter(ous);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pw;

    }

    public static File getAllLogFile(){
        String date = new SimpleDateFormat("yyyy-MM").format(new Date());
        File allLogFile = new File(getLogFilePath() + date);

        if (!allLogFile.exists()){
            allLogFile.mkdirs();
        }

        allLogFile = new File(allLogFile , new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ".txt");

        if (!allLogFile.exists()){
            try {
                allLogFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return allLogFile;
    }

}
