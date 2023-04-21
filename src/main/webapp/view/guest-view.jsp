<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/4/2023
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        .filter{
            width: 18%;
            height: 100%;
            border: 1px solid #38434A;
            border-radius: 30px;
            background-color: #f5e7e1;
        }
        .one{
            margin-top: 20px;
            margin-left: 20px;
        }
    </style>
</head>
<body>
<jsp:include page="/layout/narbar.jsp"></jsp:include>
<br>
<section>
    <form class="filter" style="width: 20%;float: left" action="/xe-dap/loc" method="post">
        <div class="one">
            <button type="submit" class="btn btn-warning">All</button>
            <hr>
            <input style="border: none; border-color: rgba(117,137,239,0);height: 30px; border-radius: 10px" type="search" name="ten" placeholder="Nhập tên">
            <hr>
            <h4>Hãng</h4>
            <hr>
            <select name="hang">
                <option value="">None</option>
                <option value="thong nhat">Thống nhất</option>
                <option value="jas">Jas</option>
                <option value="rubicon">Rubicon</option>
                <option value="kia">Kia</option>
            </select>
            <hr>
            <h4>Dòng</h4>
            <hr>
            <select name="dong">
                <option value="">None</option>
                <option value="xe dua">Xe đua</option>
                <option value="xe thuong">Xe thường</option>
                <option value="the thao">Thể thao</option>
                <option value="leo nui">Leo núi</option>
            </select>
            <hr>
            <button type="submit" class="btn btn-danger">Apply</button>
        </div>
    </form>

    <article style="width: 80%; float: left">
        <table class="table table-hover table-bordered">
            <thead>
            <tr>
                <th>Id</th>
                <th>Tên</th>
                <th>Mô tả</th>
                <th>Giá</th>
                <th>Số lượng</th>
                <th>Người tạo</th>
                <th>Thời điểm tạo</th>
                <th>Người sửa</th>
                <th>Thời điểm sửa</th>
                <th>Hãng</th>
                <th>Dòng</th>
                <th>Đã xóa</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listXeDap}" var="x">
                <tr>
                    <td>${x.id}</td>
                    <td>${x.ten}</td>
                    <td>${x.moTa}</td>
                    <td>${x.gia}</td>
                    <td>${x.soLuong}</td>
                    <td>${x.nguoiTaoBanGhi}</td>
                    <td>${x.thoiDiemTao}</td>
                    <td>${x.nguoiThayDoiCuoi}</td>
                    <td>${x.thoiDiemThayDoiCuoi}</td>
                    <td>${x.hang}</td>
                    <td>${x.dong}</td>
                    <td>
                        <c:if test="${x.daXoa}">
                            Đã xóa
                        </c:if>
                        <c:if test="${!x.daXoa}">
                            Tồn tại
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </article>
</section>
</body>
</html>
