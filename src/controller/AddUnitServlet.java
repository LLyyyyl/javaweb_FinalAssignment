package controller;

import com.google.gson.Gson;
import dao.UnitDao;
import vo.Unit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AddUnitServlet",urlPatterns = "/AddUnitServlet")
public class AddUnitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jsonStr= "";
        UnitDao dao = new UnitDao();
        try {
            List<Unit> list = dao.select();
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
