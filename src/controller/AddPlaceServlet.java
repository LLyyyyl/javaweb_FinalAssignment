package controller;

import com.google.gson.Gson;
import dao.PlaceDao;
import vo.Place;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AddPlaceServlet",urlPatterns = "/AddPlaceServlet")
public class AddPlaceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jsonStr= "";
        PlaceDao dao = new PlaceDao();
        try {
            List<Place> list = dao.select();
            jsonStr = new Gson().toJson(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out =response.getWriter();
        System.out.println(jsonStr);
        out.print(jsonStr);
        out.flush();
        out.close();

    }
}
