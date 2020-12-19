package dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import vo.Content;
import vo.Image;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ImageDao {
    public static List<Image> select() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/excise?useUnicode=true&characterEncoding=utf-8",
                "root","Lyl99999");

        String sql1="select * from t_image";
        PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql1);
        ResultSet rs=(ResultSet) ps.executeQuery();

        List<Image> c_list= new ArrayList<>();
        while(rs.next()) {
            String pid=rs.getString("pid");
            String path=rs.getString("path");

            Image c=new Image(pid,path);
            c_list.add(c);
        }

        ps.close();
        rs.close();
        con.close();

        return c_list;
    }
}
