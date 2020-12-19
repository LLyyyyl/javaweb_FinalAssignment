package dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.sql.DriverManager;
import java.sql.ResultSet;

public class CheckExist {
    public static int select(String barCode) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/excise?useUnicode=true&characterEncoding=utf-8",
                "root","Lyl99999");

        String sql1="select count(*) from add_goods where barCode=?";
        PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql1);
        ps.setString(1, barCode);
        ResultSet rs=(ResultSet) ps.executeQuery();

        int num=0;
        while(rs.next()) {
            num=rs.getInt(1);
        }

        ps.close();
        rs.close();
        con.close();

        return num;
    }
}
