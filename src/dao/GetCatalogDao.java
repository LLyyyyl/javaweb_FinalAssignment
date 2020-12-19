package dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import vo.Catalog1;
import vo.Catalog2;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GetCatalogDao {
    public static List<Catalog1> select1() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/excise?useUnicode=true&characterEncoding=utf-8",
                "root","Lyl99999");

        String sql1="select * from add_catalog1";
        PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql1);
        ResultSet rs=(ResultSet) ps.executeQuery();

        List<Catalog1> catalog1_list =new ArrayList<>();
        while(rs.next()) {
            String catalog1Id=rs.getString("catalog1Id");
            String catalog1Name=rs.getString("catalog1Name");

            Catalog1 catalog1=new Catalog1(catalog1Id,catalog1Name);
            catalog1_list.add(catalog1);
        }

        ps.close();
        rs.close();
        con.close();

        return catalog1_list;
    }

    public static List<Catalog2> select2(String catalog1Id) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/excise?useUnicode=true&characterEncoding=utf-8",
                "root","Lyl99999");

        String sql1="select * from add_catalog2 where catalog1Id=?";
        PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql1);
        ps.setString(1, catalog1Id);
        ResultSet rs=(ResultSet) ps.executeQuery();

        List<Catalog2> catalog2_list =new ArrayList<>();
        while(rs.next()) {
            String catalog2Id=rs.getString("catalog2Id");
            String catalog2Name=rs.getString("catalog2Name");

            Catalog2 catalog2=new Catalog2(catalog1Id,catalog2Id,catalog2Name);
            catalog2_list.add(catalog2);
        }

        ps.close();
        rs.close();
        con.close();

        return catalog2_list;
    }
}
