package dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import vo.Place;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PlaceDao {
    public static List<Place> select() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/excise?useUnicode=true&characterEncoding=utf-8",
                "root","Lyl99999");

        String sql1="select * from add_place";
        PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql1);
        ResultSet rs=(ResultSet) ps.executeQuery();

        List<Place> place_list =new ArrayList<>();
        while(rs.next()) {
            String placeId=rs.getString("placeId");
            String placeName=rs.getString("placeName");

             Place place=new Place(placeId,placeName);
             place_list.add(place);
        }

        ps.close();
        rs.close();
        con.close();

        return place_list;
    }
}
