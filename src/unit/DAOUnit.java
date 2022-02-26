package unit;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static unit.SqlUnit.getConnection;

/**
 * @author mo7984130
 * @Classname DAOUnit
 * @Description TODO
 * @Date 2022/2/12 11:24 下午
 */
public class DAOUnit<T> {

    Class<?> cl;
    Field[] fields;
    String database;


    /**
     *  初始化
     * @param t 泛型实例化类
     */
    public DAOUnit(T t) {
        cl = t.getClass();
        fields = cl.getDeclaredFields();
        for (Field field : fields){
            try {
                field.setAccessible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            database = (String) fields[0].get(t);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将类添加进数据库中
     * @param t 类
     */
    public void add(T t){
        StringBuilder sb = new StringBuilder();
        sb.append("insert into ").append(database).append(" values(null,");
        try {
            for (int i = 2 ; i<fields.length ; i++){
                fields[i].setAccessible(true);
                if(i != fields.length-1){
                    sb.append("'").append(fields[i].get(t)).append("',");
                }else{
                    sb.append("'").append(fields[i].get(t)).append("')");
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        try(
                Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sb.toString())
        ) {

            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取数据库总数
     * @return
     */
    public int getTotal(){
        int total = 0;
        String sql = "select count(*) from " + database;
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return total;
    }

    public int getTotal(int page){
        int total = getTotal();
        int totalPage = 0;

        total -= page;
        totalPage++;

        while (total > 0){
            total -= page;
            totalPage++;
        }

        return totalPage;
    }

    public ArrayList<T> list() {
        return list(0,Short.MAX_VALUE);
    }

    public ArrayList<T> list(int start, int offset){
        ArrayList<T> list = new ArrayList<>();
        String sql = "select * from " + database + " limit ?,?";
        try(
                Connection c = getConnection();PreparedStatement ps = c.prepareStatement(sql)
        ) {

            ps.setInt(1,start);
            ps.setInt(2,offset);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                T t = (T) cl.newInstance();
                for (int i = 1 ;i< fields.length ; i++){
                    Object o = rs.getObject(i);
                    fields[i].set(t,o);
                }
                list.add(t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<T> get(String field , String value){
        return get(new String[]{field},new String[]{value});
    }

    public ArrayList<T> get(String[] field , String[] values){

        ArrayList<T> list = new ArrayList<T>();

        StringBuilder sql = new StringBuilder("select * from ");
        sql.append(database + " where ");
        for (int i = 0 ; i < field.length ; i++) {
            if (i != field.length - 1) {
                sql.append(field[i]).append(" = '").append(values[i]).append("' and ");
            }else {
                sql.append(field[i]).append(" = '").append(values[i]).append("'");
            }
        }
        try(
                Connection c = getConnection();PreparedStatement ps = c.prepareStatement(sql.toString())
        ) {

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                T t = (T) cl.newInstance();
                for (int i = 1 ;i< fields.length ; i++){
                    fields[i].set(t,rs.getObject(i));
                }
                list.add(t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;

    }

    public ArrayList<T> fuzzySearch(String field , String value){
        return get(new String[]{field},new String[]{value});
    }

    public ArrayList<T> fuzzySearch(String[] field , String[] values){

        ArrayList<T> list = new ArrayList<>();

        StringBuilder sql = new StringBuilder("select * from ");
        sql.append(database + " where like ");
        for (int i = 0 ; i < field.length ; i++) {
            if (i != field.length - 1) {
                sql.append(field[i]).append(" = '").append("%" + values[i] + "%").append("' and ");
            }else {
                sql.append(field[i]).append(" = '").append("%" + values[i] + "%").append("'");
            }
        }

        try(
                Connection c = getConnection();PreparedStatement ps = c.prepareStatement(sql.toString())
        ) {

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                T t = (T) cl.newInstance();
                for (int i1 = 1 ;i1< fields.length ; i1++){
                    fields[i1].set(t,rs.getObject(i1));
                }
                list.add(t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;

    }

    public ArrayList<T> fuzzySearchByOne(String value , String[] field){

        ArrayList<T> list = new ArrayList<>();

        for (int i = 0 ; i < field.length ; i++) {
            StringBuilder sql = new StringBuilder("select * from ");
            sql.append(database + " where ");
            sql.append(field[i]).append(" LIKE '").append("%" + value + "%").append("'");

            try(
                    Connection c = getConnection();PreparedStatement ps = c.prepareStatement(sql.toString())
            ) {

                ResultSet rs = ps.executeQuery();

                while(rs.next()) {
                    T t = (T) cl.newInstance();
                    for (int i1 = 1 ;i1< fields.length ; i1++){
                        fields[i1].set(t,rs.getObject(i1));
                    }
                    list.add(t);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return list;

    }



    public boolean exists(String field , String value){
        return exists(new String[]{field},new String[]{value});
    }

    public boolean exists(String[] field , String[] values) {

        StringBuilder sql = new StringBuilder("select * from ");
        sql.append(database).append(" where ");
        for (int i = 0 ; i < field.length ; i++) {
            if (i != field.length - 1) {
                sql.append(field[i]).append(" = '").append(values[i]).append("' and ");
            }else {
                sql.append(field[i]).append(" = '").append(values[i]).append("'");
            }
        }
        try(
                Connection c = getConnection();PreparedStatement ps = c.prepareStatement(sql.toString())
        ) {

            int count = 0;
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                count++;
            }

            return count != 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public void update(T t){

        StringBuilder sql = new StringBuilder();
        sql.append("update ").append(database).append(" set ");
        try {
            for (int i = 2 ; i<fields.length ; i++){
                fields[i].setAccessible(true);
                if(i != fields.length-1){
                    sql.append(fields[i].getName()).append(" = '").append(fields[i].get(t)).append("' , ");
                }else{
                    sql.append(fields[i].getName()).append(" = '").append(fields[i].get(t)).append("'");
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            sql.append(" where id = '").append(fields[1].get(t)).append("'");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        try(
                Connection c = getConnection();PreparedStatement ps = c.prepareStatement(sql.toString())
        ) {

        ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void update(String where , String value , String set , String values){
        update(new String[]{where} , new String[]{value} , new String[]{set} , new String[]{values});
    }

    public void update(String[] where , String[] value , String[] set , String[] values){

        StringBuilder sql = new StringBuilder("update ");
        sql.append(database + " set ");
        for (int i = 0 ; i < set.length ; i++) {
            if (i != set.length - 1) {
                sql.append(set[i]).append(" = '").append(values[i]).append("' and ");
            }else {
                sql.append(set[i]).append(" = '").append(values[i]).append("'");
            }
        }

        sql.append(" where ");

        for (int i = 0 ; i < where.length ; i++) {
            if (i != where.length - 1) {
                sql.append(where[i]).append(" = '").append(value[i]).append("' and ");
            }else {
                sql.append(where[i]).append(" = '").append(value[i]).append("'");
            }
        }
        try(
                Connection c = getConnection();PreparedStatement ps = c.prepareStatement(sql.toString())
        ) {

            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void delete(String field , String value) {
        delete(new String[]{field},new String[]{value});
    }

    public void delete(String[] field , String[] values) {

        StringBuilder sql = new StringBuilder("delete from ");
        sql.append(database + " where ");

        for (int i = 0 ; i < field.length ; i++) {
            if (i != field.length - 1) {
                sql.append(field[i]).append(" = '").append(values[i]).append("' AND ");
            }else {
                sql.append(field[i]).append(" = '").append(values[i]).append("'");
            }
        }

        try(
                Connection c = getConnection();PreparedStatement ps = c.prepareStatement(sql.toString())
        ) {

        ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void delete(T t){

        ArrayList<String> f = new ArrayList<>();
        ArrayList<String> v = new ArrayList<>();
        for (Field field : fields){
            try {
                f.add(field.getName());
                v.add(String.valueOf(field.get(t)));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        delete(f.toArray(new String[0]) , v.toArray(new String[0]));

    }

}
