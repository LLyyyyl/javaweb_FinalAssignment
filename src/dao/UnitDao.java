package dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import vo.Unit;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UnitDao {
    public static List<Unit> select() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/excise?useUnicode=true&characterEncoding=utf-8",
                "root","Lyl99999");

        String sql1="select * from add_unit";
        PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql1);
        ResultSet rs=(ResultSet) ps.executeQuery();

        List<Unit> unit_list =new ArrayList<>();
        while(rs.next()) {
            String unitId=rs.getString("unitId");
            String unitName=rs.getString("unitName");

            Unit unit=new Unit(unitId,unitName);
            unit_list.add(unit);
        }

        ps.close();
        rs.close();
        con.close();

        return unit_list;
    }
}
