package dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import vo.Nav;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NavDao {
    public static List<Nav> select(String role) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/excise?useUnicode=true&characterEncoding=utf-8",
                "root","Lyl99999");

        String sql2="select * from t_nav where trole !='管理员'";
        PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql2);
        ResultSet rs=(ResultSet) ps.executeQuery();

        List<Nav> nav_list= new ArrayList<>();

        while(rs.next()) {
            String tid=rs.getString("tid");
            String tname=rs.getString("tname");
            String tlink=rs.getString("tlink");
            String trole=rs.getString("trole");
            Nav nav=new Nav(tid,tname,tlink,trole);
            nav_list.add(nav);
        }

        ps.close();
        rs.close();
        con.close();
        return nav_list;
    }

    public static List<Nav> select_all(String role) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/excise?useUnicode=true&characterEncoding=utf-8",
                "root","Lyl99999");

        String sql3="select * from t_nav";
        PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql3);
        ResultSet rs=(ResultSet) ps.executeQuery();

        List<Nav> nav_list= new ArrayList<>();

        while(rs.next()) {
            String tid=rs.getString("tid");
            String tname=rs.getString("tname");
            String tlink=rs.getString("tlink");
            String trole=rs.getString("trole");
            Nav nav=new Nav(tid,tname,tlink,trole);
            nav_list.add(nav);
        }

        ps.close();
        rs.close();
        con.close();
        return nav_list;
    }
}
