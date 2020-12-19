package dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import vo.Goods;

import java.sql.DriverManager;
import java.sql.ResultSet;

public class AddDao {
    public static boolean insert(Goods goods) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/excise?useUnicode=true&characterEncoding=utf-8",
                "root","Lyl99999");

        String sql1="insert into add_goods values (?,?,?,?,?,?,?)";
        PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql1);
        String ChineseName = goods.getChineseName();
        String huohao = goods.getHuohao();
        String barCode = goods.getBarCode();
        String place  = goods.getPlace();
        String unit = goods.getUnit();
        String catalog1 = goods.getCatalog1();
        String catalog2 =goods.getCatalog2();
        ps.setString(1, ChineseName);
        ps.setString(2, huohao);
        ps.setString(3, barCode);
        ps.setString(4, place);
        ps.setString(5, unit);
        ps.setString(6, catalog1);
        ps.setString(7, catalog2);

        int i = ps.executeUpdate();
        boolean success = false;
        if (i > 0) {
            success = true;
        }


        ps.close();
        con.close();

        return success;
    }
}
