package controller;

import com.google.gson.Gson;
import dao.AddDao;
import vo.Goods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "AddServlet")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String ChineseName=request.getParameter("ChineseName");
        String huohao = request.getParameter("huohao");
        String barCode = request.getParameter("barCode");
        String place = request.getParameter("placeName");
        String unit = request.getParameter("unitName");
        String catalog1 = request.getParameter("catalog1");
        String catalog2 = request.getParameter("catalog2Code");

        Goods goods = new Goods(ChineseName, huohao, barCode, place, unit,catalog1,catalog2);
        AddDao dao = new AddDao();
        boolean success = false ;
        String info="";

        try {
            success = dao.insert(goods);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, Object> map = new HashMap<String, Object>();
        if (success) {
            map.put("code", 0);
            map.put("info", info+"成功!");
        } else {
            map.put("code", 1);
            map.put("info", info+"失败!");
        }

        String jsonStr = new Gson().toJson(map);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print(jsonStr);
        out.flush();
        out.close();

    }

}
