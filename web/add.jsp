<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>商品信息录入</title>
    <link rel="stylesheet" href="css/add.css">
    <script src="js/jquery-3.5.0.min.js"></script>
    <script src="js/add.js"></script>
</head>
<body>
<div class="header">
    商品信息录入
</div>

<div class="container">
    <div class="heading">
        <div style="color:#999999">基本信息</div>
    </div>
    <hr size="2px" noshade="noshade">

    <div class="details">
        <form id="AddCatalogServlet">
        <div class="long">商品中文名称&emsp;&emsp;
            <input class="inl" id="ChineseName" name="ChineseName" type="text" placeholder="请输入商品名称">
            <span class="auth_err" id="ChineseNameError"></span>
        </div>
        <br>
            <p>商品货号&emsp;&emsp;
                <input class="inl" id="huohao" name="huohao" type="text" placeholder="请输入商品货号">
                <span class="auth_err" id="huohaoError"></span>
            </p>
            <br>

            <p>条形码&emsp;&emsp;
                <input class="inl" id="barCode" name="barCode" type="text" placeholder="请输入条形码">
                <span class="auth_err" id="barCodeError"></span>
            </p>
            <br>


            <p>产地&emsp;&emsp;
                <select id="placeName" name="placeNameCode">
                    <option value="">--请选择--</option>
                    <span class="auth_err" id="placeNameError"></span>
                </select>
            </p>
            <br><br>

            <p>计量单位&emsp;&emsp;
                <select id="unitName" name="unitNameCode">
                    <option value="">--请选择--</option>
                    <span class="auth_err" id="unitNameError"></span>
                </select>
            </p>
            <br><br>

            <p> 一级目录&emsp;&emsp;
                <select id="catalog1Code" name="catalog1Code">
                <option value="">--请选择--</option>
                </select>
                <span class="auth_err" id="catalog1Error"></span>
            </p>

            <br>
            <p> 二级目录&emsp;&emsp;
                <select id="catalog2Code" name="catalog2Code">
                    <option value="">--请选择--</option>
                </select>
                <span class="auth_err" id="catalog2Error"></span>
            </p>

        <div class="bt">
            <input id="btLogin" type="submit" value="&emsp;商品保存&emsp;"/>
            <input type="submit" value="&emsp;取消&emsp;" onclick="exit();"/>
            <input type="submit" value="&emsp;退出&emsp;" onclick="exit();"/>
        </div>
        </form>

    </div>
</div>

<div class="base">
    Copyright 2017 版权所有 武汉市海欢商贸有限公司&emsp;&emsp;客服热线：400-076-6288&emsp;&emsp;&emsp;鄂ICP备14061524号-2
</div>

</body>
</html>