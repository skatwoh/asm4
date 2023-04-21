<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/31/2023
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.time.LocalDate" %>
<html>
<head>
    <title>Trang chủ</title>
    <style>
        .popup {
            margin: 75px auto;
            padding: 20px;
            background: #fff;
            border: 1px solid #666;
            width: 300px;
            box-shadow: 0 0 50px rgba(0, 0, 0, 0.5);
            position: relative;
        }
        .light .popup {
            border-color: #aaa;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.25);
        }
        .popup h2 {
            margin-top: 0;
            color: #666;
            font-family: "Trebuchet MS", Tahoma, Arial, sans-serif;
        }
        .popup .close {
            position: absolute;
            width: 20px;
            height: 20px;
            top: 20px;
            right: 20px;
            opacity: 0.8;
            transition: all 200ms;
            font-size: 24px;
            font-weight: bold;
            text-decoration: none;
            color: #666;
        }
        .popup .close:hover {
            opacity: 1;
        }
        .popup .content {
            max-height: 400px;
            overflow: auto;
        }
        .popup p {
            margin: 0 0 1em;
        }
        .popup p:last-child {
            margin: 0;
        }
        .overlay {
            position: absolute;
            top: 0;
            bottom: 0;
            left: 0;
            right: 0;
            background: rgba(0, 0, 0, 0.5);
            transition: opacity 200ms;
            visibility: hidden;
            opacity: 0;
        }
        .overlay.light {
            background: rgba(255, 255, 255, 0.5);
        }
        .overlay .cancel {
            position: absolute;
            width: 100%;
            height: 100%;
            cursor: default;
        }
        .overlay:target {
            visibility: visible;
            opacity: 1;
        }
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
<a class="btn btn-info" href="#popup1">Add</a>
<div id="popup1" class="overlay">
    <div class="popup">
        <h2>Add products</h2>
        <a class="close" href="#">&times;</a>
        <form action="/user/add" method="post">
            <div class="mb-3 mt-3">
                <label>Tên:</label>
                <input type="text" class="form-control" id="ten" placeholder="Nhập tên" name="ten" required>
            </div>
            <div class="mb-3">
                <label>Mô tả:</label>
                <input type="text" class="form-control" id="moTa" placeholder="Nhập mô tả" name="moTa" required>
            </div>
            <div class="mb-3">
                <label>Giá:</label>
                <input type="number" class="form-control" id="gia" placeholder="Nhập giá" name="gia" required>
            </div>
            <div class="mb-3">
                <label>Số lượng:</label>
                <input type="number" class="form-control" id="soLuong" placeholder="Nhập số lượng" name="soLuong" required>
            </div>
            <div class="mb-3">
                <label>Hãng:</label>
                <input type="text" class="form-control" id="hang" placeholder="Nhập hãng" name="hang" required>
            </div>
            <div class="mb-3">
                <label>Dòng:</label>
                <select name="dong">
                    <option name="dong" value="xe thuong">Xe Thường</option>
                    <option name="dong" value="xe dua">Xe Đua</option>
                    <option name="dong" value="leo nui">Leo Núi</option>
                    <option name="dong" value="the thao">Thể Thao</option>
                </select>
            </div>
            <input type="text" class="form-control" id="nguoiTao" name="nguoiTao" value="${sessionScope.username}" style="display: none">
            <input type="text" class="form-control" id="thoiGianTao" name="thoiGianTao" value="<%= LocalDate.now().toString() %>" style="display: none">
            <input type="text" class="form-control" id="nguoiDoi" name="nguoiDoi" style="display: none" value="${sessionScope.username}">
            <input type="text" class="form-control" id="thoiGianDoi" name="thoiGianDoi" style="display: none" value="<%= LocalDate.now().toString() %>">
            <input type="text" class="form-control" id="daXoa" name="daXoa" style="display: none" value="1">
            <button type="submit" class="btn btn-primary"><i class="fa-solid fa-floppy-disk"></i></button>
        </form>
    </div>
</div>
<section>
    <br>
    <form class="filter" style="width: 20%;float: left" action="/user/loc" method="post">
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
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listXeDapU}" var="x">
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
                    <td>
                        <a href="/user/view?id=${x.id}" class="btn btn-primary"><i class="fa-solid fa-pen-to-square"></i></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </article>
</section>

</body>
</html>
