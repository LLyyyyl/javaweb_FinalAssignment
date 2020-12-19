package dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import vo.Content;
import vo.Nav;
import vo.User;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ContentDao {
    public static List<Content> select(String t) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/excise?useUnicode=true&characterEncoding=utf-8",
                "root","Lyl99999");

        String sql1="select * from s_nav where tid=?";
        PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql1);
        ps.setString(1, t);
        ResultSet rs=(ResultSet) ps.executeQuery();

        List<Content> c_list= new ArrayList<>();
        while(rs.next()) {
            String tid=rs.getString("tid");
            String sid=rs.getString("sid");
            String sname=rs.getString("sname");
            String slink=rs.getString("slink");

            Content c=new Content(tid,sid,sname,slink);
            c_list.add(c);
        }

        ps.close();
        rs.close();
        con.close();

        return c_list;
    }
}
