<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>addDept</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/r/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/r/css/style.css">
</head>
<body>
<div class="container">
    <div class="row head"></div>
    <div class="row body">
        <form class="form-horizontal" id="addDeptForm" action="${pageContext.request.contextPath}/dept/addDept" method="post">
            <div class="form-group">
                <label for="dname" class="col-sm-2 control-label">部门名称</label>
                <div class="col-sm-6 dname">
                    <input type="text" class="form-control" id="dname" name="dname">
                </div>
                <div class="col-sm-4 checkdname">

                </div>
            </div>
            <div class="form-group">
                <label for="location" class="col-sm-2 control-label">工作地点</label>
                <div class="col-sm-6 location">
                    <input type="text" class="form-control" id="location" name="location">
                </div>
                <div class="col-sm-4 checklocation">

                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="button" class="btn btn-primary sub">提交</button>
                </div>
            </div>
        </form>
    </div>
    <div class="row foot"></div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/r/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/r/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(function () {
        var isdname = false;
        var islocation = false;
       $("#dname").blur(function () {
           var dname = $(this).val();
           var reg = /^[\u4e00-\u9fa5]{3,5}$/;
           if(reg.test(dname)){
               $(".dname").attr("class" ,"col-sm-6 name has-success");
               $(".checkdname").html("√");
               isdname = true;
           }else{
               $(".dname").attr("class" ,"col-sm-6 name has-error");
               $(".checkdname").html("请输入3-5位的中文字符");
               isdname = false;
           }
       });

        $("#location").blur(function () {
            var location = $(this).val();
            var reg = /^[\u4e00-\u9fa5]{2,4}$/;
            if(reg.test(location)){
                $(".location").attr("class" ,"col-sm-6 location has-success");
                $(".checklocation").html("√");
                islocation = true;
            }else{
                $(".location").attr("class" ,"col-sm-6 location has-error");
                $(".checklocation").html("请输入2-4位的中文字符");
                islocation = false;
            }
        });

        $(".sub").click(function () {
            if(isdname && islocation){
                $("#addDeptForm").submit();
            }
        });
    });
</script>
</body>
</html>