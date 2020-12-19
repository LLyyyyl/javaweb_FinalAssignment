package controller;

import com.google.gson.Gson;
import dao.CheckExist;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet(name = "CheckExistServlet",urlPatterns = "/CheckExistServlet")
public class CheckExistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String barCode = request.getParameter("barCode");

        CheckExist dao = new CheckExist();
        int isexist = 0;
        try {
            isexist = dao.select(barCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        HashMap<String,Object> map=new HashMap<String,Object>();
        if(isexist==0)
        {
            map.put("code", 0);
            map.put("info", "没有重复");
        }else{
            map.put("code", 1);
            map.put("info", "条形码重复");
        }
        String jsonStr = new Gson().toJson(map);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        System.out.println(jsonStr);
        out.print(jsonStr);
        out.flush();
        out.close();
    }
}
