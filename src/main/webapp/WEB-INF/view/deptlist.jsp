<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>deptlist</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/r/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/r/css/style.css">
</head>
<body>
    <div class="container">
        <div class="row head">
            欢迎${user.username}
            <img src="${pageContext.request.contextPath}/${user.headimg}" class="img-circle" height="30px" width="30px">
        </div>
        <div class="row">
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th><input type="checkbox" class="choseAll"></th>
                        <th>#</th>
                        <th>部门名称</th>
                        <th>部门地点</th>
                        <th width="15%">操作</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${pageInfo.list}" var="dept" varStatus="index">
                        <tr>
                            <td><input type="checkbox" class="item" value="${dept.id}"></td>
                            <td>${index.index + 1}</td>
                            <td>${dept.dname}</td>
                            <td>${dept.location}</td>
                            <td>
                                <button type="button" class="btn btn-info">修改</button>
                                <button type="button" class="btn btn-danger delete-one" delete-id="${dept.id}">删除</button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="row">
            <div class="col-sm-9">
                <button type="button" class="btn btn-primary emp">员工列表</button>
                <button type="button" class="btn btn-primary">增加</button>
                <button type="button" class="btn btn-danger deleteAll">删除</button>
            </div>
            <div class="col-sm-3">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <c:if test="${pageInfo.isFirstPage}">
                            <li class="disabled">
                                <a href="javaScript:;" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:if test="${!pageInfo.isFirstPage}">
                            <li>
                                <a href="${pageContext.request.contextPath}/dept/deptlist?pageNum=${pageInfo.prePage}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:forEach items="${pageInfo.navigatepageNums}" var="num">
                            <li  <c:if test="${pageInfo.pageNum == num}">class="active"</c:if> ><a href="${pageContext.request.contextPath}/dept/deptlist?pageNum=${num}">${num}</a></li>

                        </c:forEach>
                        <c:if test="${pageInfo.isLastPage}">
                            <li class="disabled">
                                <a href="javaScript:;" aria-label="Previous">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:if test="${!pageInfo.isLastPage}">
                            <li>
                                <a href="${pageContext.request.contextPath}/dept/deptlist?pageNum=${pageInfo.nextPage}" aria-label="Previous">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:if>
                    </ul>
                </nav>
            </div>
        </div>
        <div class="row foot"></div>
    </div>

    <script type="text/javascript" src="${pageContext.request.contextPath}/r/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/r/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $(".delete-one").click(function () {
                var id = $(this).attr("delete-id");
                var path = "${pageContext.request.contextPath}/dept/deleteDeptById?id=" + id;
                location.href = path;
            });

            //全选的点击事件
            $(".choseAll").click(function () {
                /*var ischecked = $(this)[0].checked;
                var items = $(".item");
                if (ischecked){
                    for(var i = 0;i <items.length;i++ ){
                        items[i].checked = true;
                    }
                }else {
                    for (var i = 0; i < items.length; i++) {
                        items[i].checked = false;
                    }
                }*/

                $(".item").prop("checked",$(this).prop("checked"));

            });


            $(".deleteAll").click(function () {
                //1、拿到所有多选框状态
                var ids = [];
                $(".item").each(function () {
                    var item = $(this);
                    if (item.prop("checked")){
                        var id = item.val();
                        ids[ids.length] = id;
                    }
                });
                var path = "${pageContext.request.contextPath}/dept/deleteDeptById?id=" + ids;
                location.href = path;

            });

            $(".emp").click(function () {
                var path = "${pageContext.request.contextPath}/emp/emplist";
                location.href = path;
            });
        });
    </script>
</body>
</html>