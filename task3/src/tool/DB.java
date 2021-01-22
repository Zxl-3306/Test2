package tool;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DB {
    static String driver=null;
    static String url=null;
    static String user=null;
    static String password=null;

    protected Connection conn=null;
    protected PreparedStatement ps=null;
    protected ResultSet rs=null;

    public void getConn(){
        try {
            //注册JDBC驱动程序
            Class.forName(driver);
            //建立连接
            conn = DriverManager.getConnection(url, user, password);
            }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void close() {
        try {
            if(rs!=null) rs.close();
            if(ps!=null) ps.close();
            if(conn!=null) conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    static{
        InputStream is=DB.class.getClassLoader().getResourceAsStream("config.properties");
        Properties pp=new Properties();
        try {
            pp.load(is);

            driver=pp.getProperty("a");
            url=pp.getProperty("b");
            user=pp.getProperty("c");
            password=pp.getProperty("d");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
