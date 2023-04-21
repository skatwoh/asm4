<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/7/2023
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.time.LocalDate" %>
<html>
<head>
    <title>Title</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<form action="/admin/update?id=${xeDap.id}" method="post">
  <div class="mb-3 mt-3">
    <label>Tên:</label>
    <input type="text" id="ten" placeholder="Nhập tên" name="ten" value="${xeDap.ten}">
  </div>
  <div class="mb-3">
    <label>Mô tả:</label>
    <input type="text" id="moTa" placeholder="Nhập mô tả" name="moTa" value="${xeDap.moTa}">
  </div>
  <div class="mb-3">
    <label>Giá:</label>
    <input type="number"  id="gia" placeholder="Nhập giá" name="gia" value="${xeDap.gia}">
  </div>
  <div class="mb-3">
    <label>Số lượng:</label>
    <input type="number"  id="soLuong" placeholder="Nhập số lượng" name="soLuong" value="${xeDap.soLuong}">
  </div>
  <div class="mb-3">
    <label>Hãng:</label>
    <input type="text"  id="hang" placeholder="Nhập hãng" name="hang" value="${xeDap.hang}">
  </div>
  <div class="mb-3">
    <label>Dòng:</label>
    <select name="dong">
      <option name="dong" >${xeDap.dong}</option>
      <option name="dong" value="xe thuong">Xe Thường</option>
      <option name="dong" value="xe dua">Xe Đua</option>
      <option name="dong" value="leo nui">Leo Núi</option>
      <option name="dong" value="the thao">Thể Thao</option>
    </select>
  </div>
  <input type="text" class="form-control" id="nguoiTao" name="nguoiTao" value="${xeDap.nguoiTaoBanGhi}" style="display: none">
  <input type="text" class="form-control" id="thoiGianTao" name="thoiGianTao" value="${xeDap.thoiDiemTao}" style="display: none">
  <input type="text" class="form-control" id="nguoiDoi" name="nguoiDoi" style="display: none" value="${sessionScope.username}">
  <input type="text" class="form-control" id="thoiGianDoi" name="thoiGianDoi" style="display: none" value="<%= LocalDate.now().toString() %>">
  <div class="mb-3">
    <label>Đã xóa:</label>
  <input type="text" id="daXoa" name="daXoa" value="${xeDap.daXoa}">
  </div>
  <button type="submit" class="btn btn-primary">Update</button>
</form>
</body>
</html>
