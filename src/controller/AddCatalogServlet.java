package controller;

import com.google.gson.Gson;
import dao.GetCatalogDao;
import vo.Catalog1;
import vo.Catalog2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AddCatalogServlet",urlPatterns = "/AddCatalogServlet")
public class AddCatalogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");


        String catalog1Code = request.getParameter("catalog1Code");
        String catalog2Code = request.getParameter("catalog2Code");
        System.out.println(catalog2Code);

        String jsonStr = "";
        GetCatalogDao dao = new GetCatalogDao();

        if(catalog1Code == null) {
            List<Catalog1> list = null;
            try {
                list = dao.select1();
            } catch (Exception e) {
                e.printStackTrace();
            }
            jsonStr = new Gson().toJson(list);
        }else {
            List<Catalog2> list = null;
            try {
                list = dao.select2(catalog1Code);
            } catch (Exception e) {
                e.printStackTrace();
            }
            jsonStr = new Gson().toJson(list);
        }

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        System.out.println(jsonStr);
        out.print(jsonStr);
        out.flush();
        out.close();
    }

}
