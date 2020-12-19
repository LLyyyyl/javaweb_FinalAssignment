<%--
  Created by IntelliJ IDEA.
  User: 3
  Date: 2020/12/15
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>系统主页</title>

    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="bootstroop/css/bootstrap.min.css">
    <script src="js/jquery-3.5.0.min.js"></script>
    <script src="bootstroop/js/bootstrap.min.js"></script>
</head>

<body>
<form action="AddCatalogServlet" mothod="post">
    <div class="header">
        <!--导航栏-->
        <div class="nav">
            <ul>
                <%String html1 = (String)request.getAttribute("html1");
                    out.println(html1);%>
            </ul>
        </div>
        <div class="user">
            当前用户：<%String chrName = (String)request.getAttribute("chrName");
            out.println(chrName);%>
        </div>

        <div class="role">
            武汉市海欢商贸有限公司:<%String role = (String)request.getAttribute("role");
            out.println(role);%>
        </div>
    </div>

    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="4"></li>
        </ol>
        <div class="carousel-inner">
            <%String html2 = (String)request.getAttribute("html2");
                out.println(html2);%>
        </div>

        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>

    <div class="bottom">
        <div class="name">跨境电商综合服务</div>
        <div class="introduct">为企业提供订单、支付、物流、通关相结合的一体化服务</div>

        <div class="content">
            <div class="goods">
                <h4>商品管理</h4>
                <div class="txt">企业商品信息的录入、备案申请、商品审核、浏览、维护等操作。支持在一账号下维护多销售渠道的商品。</div>
                <div class="pic"><img src="css/images/logo1.png" width="155px" height="150px"></div>
            </div>
            <div class="order">
                <h4>订单管理</h4>
                <div class="txt">订单的excel格式文件的批量上传、有效性检查、订单的审核、订单状态的查询、历史订单的下载导出。</div>
                <div class="pic"><img src="css/images/logo2.png" width="155px" height="150px"></div>
            </div>
            <div class="finance">
                <h4>财务管理</h4>
                <div class="txt">整合全方位数据，自动生成销售、财务等各类报表，完成对支付的确认，执行批量退款业务等操作。</div>
                <div class="pic"><img src="css/images/logo3.png" width="155px" height="150px"></div>
            </div>
            <div class="entry">
                <h4>报关管理</h4>
                <div class="txt">订单、支付单、物流单三单合一推送海关，产品出库手续齐全，有据可循，符合海关对跨境业务的要求。</div>
                <div class="pic"><img src="css/images/logo4.png" width="155px" height="150px"></div>
            </div>
            <div class="system">
                <h4>系统管理</h4>
                <div class="txt">商品类目、产地等基础信息的维护，商家、用户、角色、权限等管理，各类参数的配置。</div>
                <div class="pic"><img src="css/images/logo5.png" width="155px" height="150px"></div>
            </div>
        </div>

        <div class="base">
            Copyright 2017 版权所有 武汉市海欢商贸有限公司&emsp;&emsp;客服热线：400-076-6288&emsp;&emsp;&emsp;鄂ICP备14061524号-2
        </div>
    </div>
</form>
</body>

</html>
