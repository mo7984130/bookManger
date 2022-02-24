package unit;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author mo7984130
 * @Classname SqlUnit
 * @Description TODO
 * @Date 2022/2/12 11:24 下午
 */
public class SqlUnit {

    public static Connection getConnection(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bookManger";
            String user = "root";
            String password = "mo7984130";
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
