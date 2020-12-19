package controller;


import dao.ContentDao;
import dao.ImageDao;
import dao.NavDao;
import dao.UserDao;
import vo.Content;
import vo.Image;
import vo.Nav;
import vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        User user=new User();
        UserDao userDao = new UserDao();
        HttpSession session = request.getSession();

        String verityCode = session.getAttribute("verityCode").toString();
        //System.out.println(verityCode);

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String vcode = request.getParameter("vcode");

        //System.out.println(userName+","+password+","+vcode);


        boolean result = vcode.equalsIgnoreCase(verityCode);//判断验证码是否正确
        //System.out.println(result);

        if(result){
            //System.out.println("验证码正确");
            try {
                if(UserDao.select(userName, password)!=null) {//登录成功
                    user=UserDao.select(userName, password);
                    String chrName = user.getChrName();
                    request.setAttribute("chrName",chrName);

                    String role = user.getRole();
                    request.setAttribute("role",role);

                    //System.out.println("chrName"+chrName);
                    //System.out.println("role"+role);

                    request.getSession().setAttribute("user","user");


                    //主界面导航栏
                    int i,j;
                    List<Nav> n = new ArrayList<>();
                    if("管理员".equals(role))
                    {
                        try {
                            n = NavDao.select_all(role);
                            List<String> s1 = new ArrayList<>();
                            List<String> s2 = new ArrayList<>();
                            List<String> s3 = new ArrayList<>();
                            for (i = 0; i < n.size(); i++) {
                                Nav temp = (Nav) n.get(i);
                                s1.add(temp.getTname());
                                s2.add(temp.getTlink());
                                s3.add(temp.getTid());
                            }


                            String html1="";
                            for(i=0;i<s1.size();i++)
                            {
                                List<Content> c = new ArrayList<>();
                                List<String> a1 = new ArrayList<>();
                                List<String> a2 = new ArrayList<>();

                                try {
                                    c = ContentDao.select(s3.get(i));

                                    html1+="<li><a href=\""+s2.get(i)+"\">"+s1.get(i)+"</a>";
                                    if(c.size()!=0){
                                        html1+="<ul>";

                                        for (int a = 0; a < c.size(); a++) {
                                            Content temp = c.get(a);
                                            a1.add(temp.getSname());
                                            a2.add(temp.getSlink());

                                            html1+="<li><a href=\""+a2.get(a)+"\">"+a1.get(a)+"</a></li>";
                                        }
                                        html1+="</ul>";
                                    }
                                    html1+="</li>";
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                            }

                            request.setAttribute("html1", html1);
                            System.out.println(html1);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    else//普通用户
                    {
                        try {
                            n = NavDao.select(role);
                            List<String> s1 = new ArrayList<>();
                            List<String> s2 = new ArrayList<>();
                            List<String> s3 = new ArrayList<>();
                            for (i = 0; i < n.size(); i++) {
                                Nav temp = (Nav) n.get(i);
                                s1.add(temp.getTname());
                                s2.add(temp.getTlink());
                                s3.add(temp.getTid());
                            }

                            String html1="";
                            for(i=0;i<s1.size();i++)
                            {
                                List<Content> c = new ArrayList<>();
                                List<String> a1 = new ArrayList<>();
                                List<String> a2 = new ArrayList<>();

                                try {
                                    c = ContentDao.select(s3.get(i));

                                    html1+="<li><a href=\""+s2.get(i)+"\">"+s1.get(i)+"</a>";
                                    if(c.size()!=0){
                                        html1+="<ul>";

                                        for (int a = 0; a < c.size(); a++) {
                                            Content temp = c.get(a);
                                            a1.add(temp.getSname());
                                            a2.add(temp.getSlink());

                                            html1+="<li><a href=\""+a2.get(a)+"\">"+a1.get(a)+"</a></li>";
                                        }
                                        html1+="</ul>";
                                    }
                                    html1+="</li>";
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                            }

                            request.setAttribute("html1", html1);
                            System.out.println(html1);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    //主界面滚动图片
                    String html2="";
                    List<Image> imgs = new ArrayList<>();
                    List<String> img = new ArrayList<>();
                    try{
                        imgs= ImageDao.select();
                        html2+="<div class=\"carousel-item active bg\">";
                        for(i=0;i<5;i++)
                        {
                            img.add(imgs.get(i).getPath());
                            if(i!=0){
                                html2+="<div class=\"carousel-item bg\">";
                            }
                            html2+="<img src=\""+imgs.get(i).getPath()+"\" class=\"d-block w-100\"></div>";
                        }

                        request.setAttribute("html2", html2);

                    }catch (Exception e) {
                        e.printStackTrace();
                    }

                    request.getRequestDispatcher("/main.jsp").forward(request, response);//登录成功跳转主页面
                } else{//数据库中不存在当前用户或密码错误
                    String errors="用户名或密码错误!";
                    request.setAttribute("errors", errors);
                    request.getRequestDispatcher("/error.jsp").forward(request, response);
                }

            }catch(Exception e) {
                e.printStackTrace();
            }

        }
        else{//验证码错误
            String errors="抱歉，您输入的验证码不正确";
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
