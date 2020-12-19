//产地
function fillPlaceName() {
    $.ajax({
        type:"post",
        url:"AddPlaceServlet",
        data:{},
        dataType:"json",
        success:function (response) {
            var placeNameElement = document.getElementById("placeName");
            //清除select的所有option
            placeNameElement.options.length=0;
            //增加一个选项
            placeNameElement.add(new Option("--请选择--",""));
            //循环增加其他所有选项
            for(let index = 0; index<response.length;index++){
                placeNameElement.add(new Option(response[index].palceName, response[index].placeId));
            }
        }
    });
}

//计量单位
function fillUnitName() {
    $.ajax({
        type:"post",
        url:"AddUnitServlet",
        data:{},
        dataType:"json",
        success:function (response) {
            var unitNameElement = document.getElementById("unitName");
            //清除select的所有option
            unitNameElement.options.length=0;
            //增加一个选项
            unitNameElement.add(new Option("--请选择--",""));
            //循环增加其他所有选项
            for(let index = 0; index<response.length;index++){
                unitNameElement.add(new Option(response[index].unitName, response[index].unitId));
            }
        }
    });
}

//一级目录
function fillCatalog1() {
    $.ajax({
        type: "post",
        url: "AddCatalogServlet",
        data: {},
        dataType: "json",
        success: function(response) {
            var catalog1Element = document.getElementById("catalog1Code");
            //清除select的所有option
            catalog1Element.options.length = 0;
            //增加一个选项
            catalog1Element.add(new Option("--请选择--", ""));
            //循环增加其他所有选项
            for (index = 0; index < response.length; index++) {
                catalog1Element.add(new Option(response[index].catalog1Name,
                    response[index].catalog1Id));
            }
        }
    });
}

//二级目录
var fillCatalog2 = function(catalog2Code) {
    var catalog1Code = $("#catalog1Code").val();
    if (catalog1Code == "") {
        $("#catalog1Error").css("color", " #c00202");
        $("#catalog1Error").text("必须选择！");
        return;
    }
    province_correct = true;
    $("#catalog1Error").text("");
    $("#catalog2Code").empty();
    $("#catalog2Code").append($("<option>").val("").text("--请选择--"));
    $.ajax({
        type: "post",
        url: "AddCatalogServlet",
        data: { catalog1Code: catalog1Code },
        dataType: "json",
        success: function(response) {
            for (index = 0; index < response.length; index++) {
                var option = $("<option>").val(response[index].catalog2Id)
                    .text(response[index].catalog2Name);
                $("#catalog2Code").append(option);
            }
            $("#catalog2Code").val(catalog2Code);
            if ($("#catalog2Code").val != "") {
                catalog2_correct = true;
            }
        }
    });
}

//检查条形码是否存在
function checkBarCode() {
    if ($('#barCode').val() == "") {
        $("#barCodeError").css("color", " #c00202");
        $("#barCodeError").text("条形码不能为空");
        return;
    }
    $.ajax({
        type: "post",
        url: "CheckExistServlet",
        data: { barCode: $(this).val() },
        dataType: "json",
        success: function(response) {
            if (response.code == 0) {
                $("#barCodeError").css("color", "green");
                $("#barCodeError").text("条形码唯一");
                barCode_correct = true;
            } else {
                $("#barCodeError").css("color", "#c00202");
                $("#barCodeError").text("条形码已存在");
            }
        }
    });
}

var barCode_correct = false;
var catalog1_correct = false;
var catalog2_correct = false;
var placeName_correct = false;
var unitName_correct = false;
$(document).ready(function() {
    fillPlaceName();
    fillUnitName();
    fillCatalog1(); //调用函数，填充下拉框
    $("#catalog1Code").change(fillCatalog2); //绑定下拉框变化事件

    //绑定下拉框离开事件
    $("#catalog1Code").blur(function (e) {
        if ($(this).val() == "") {
            $("#catalog1Error").css("color", " #c00202");
            $("#catalog1Error").text("必须选择！");
        } else {
            $("#catalog1Error").text("");
            catalog1_correct = true;
        }
    });

    $("#catalog2Code").blur(function (e) {
        if ($("#catalog2Code").val() == "") {
            $("#catalog2Error").css("color", " #c00202");
            $("#catalog2Error").text("必须选择！");
        } else {
            $("#catalog2Error").text("");
            catalog2_correct = true;
        }
    });

    //条形码输入框离开事件
    $('#barCode').blur(checkBarCode);

    //商品中文名称输入框离开事件：
    $("#ChineseName").blur(function() {
        if ($('#ChineseName').val() == "") {
            $("#ChineseNameError").css("color", " #c00202");
            $("#ChineseNameError").text("商品中文名称不能为空");
            return;
        }
    });

    //商品货号输入框离开事件：
    $("#huohao").blur(function() {
        if ($('#huohao').val() == "") {
            $("#huohaoError").css("color", " #c00202");
            $("#huohaoError").text("商品货号不能为空");
            return;
        }
    });

    //产地绑定下拉框离开事件
    $("#placeName").blur(function (e) {
        if ($(this).val() == "") {
            $("#placeNameError").css("color", " #c00202");
            $("#placeNameError").text("必须选择！");
        } else {
            $("#placeNameError").text("");
            placeName_correct = true;
        }
    });

    //计量单位绑定下拉框离开事件
    $("#unitName").blur(function (e) {
        if ($(this).val() == "") {
            $("#unitNameError").css("color", " #c00202");
            $("#unitNameError").text("必须选择！");
        } else {
            $("#unitNameError").text("");
            unitName_correct = true;
        }
    });


    /**
     * 提交按钮点击事件
     */
    $("#btLogin").click(function(e) {
        if (barCode_correct & catalog1_correct && catalog2_correct && province_correct && placeName_correct && unitName_correct) {
            $.ajax({
                type: "post",
                url: "AddServlet",
                data: $("#AddCatalogServlet").serialize(), //将表单内容序列化成一个URL 编码字符串
                dataType: "json",
                success: function(response) {
                    alert(response.info);
                    if (response.code == 0) {
                        if ($("#action").val() != "") {
                            CloseDiv('MyDiv', 'fade');
                            reload();
                        } else {
                            window.location.href = "login.html";
                        }
                    }
                }
            });
        } else {
            $("#barCode_correct").blur();
            $('#catalog1_correct').blur();
            $("#catalog2_correct").blur();
            $("#province_correct").blur();
            $("#placeName_correct").blur();
            $("#unitName_correct").blur();
        }
    });


});

//取消 退出录入商品
function exit() {
    window.history.go(-1);
}