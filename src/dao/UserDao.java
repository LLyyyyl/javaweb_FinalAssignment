package dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import tools.DataBaseConnection;
import vo.User;

import java.sql.DriverManager;
import java.sql.ResultSet;

public class UserDao {
    public static User select(String userName, String password) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/excise?useUnicode=true&characterEncoding=utf-8",
                "root","Lyl99999");

        String sql1="select * from t_user";
        PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql1);
        ResultSet rs=(ResultSet) ps.executeQuery();

        while(rs.next()) {
            String name=rs.getString("userName");
            String word=rs.getString("password");

            if(name.equals(userName) && word.equals(password)) {
                String chrName=rs.getString("chrName");
                String role=rs.getString("role");
                User user=new User(name,word,chrName,role);
                return user;
            }
        }

        ps.close();
        rs.close();
        con.close();

        return null;
    }
}
