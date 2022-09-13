<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: phamd
  Date: 13/09/2022
  Time: 6:13 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HOME</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
    <style>
        .textCenTer {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container-fluid " style="margin-top: 30px">
    <div class="row textCenTer fw-bold">
        <span class="textCenTer" style="font-size: 40px"> TỜ KHAI Y TẾ</span>
    </div>

    <div class="row textCenTer fw-bold">
        <span class="textCenTer" style="font-size: 25px">ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ
            LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</span>
    </div>

    <div class="row textCenTer">
        <span class="textCenTer" style="font-size: 25px;color: red">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự</span>
    </div>

    <div class="row" style="height: 30px"></div>

    <div class="row">
        <form:form action="/create" method="post" modelAttribute="declaration">
            <table class="table table-striped">
                <tr>
                    <td colspan="6"><p class="fw-bold">Họ tên (ghi chữ IN HOA) <span style="color: red">(*)</span></p>
                    </td>
                </tr>
                <tr>
                    <td colspan="6"><form:input path="name" size="100%"/></td>
                </tr>

                <tr>
                    <td colspan="2"><span class="fw-bold">Năm sinh <span style="color: red">(*)</span></span></td>
                    <td colspan="2"><span class="fw-bold">Giới tính <span style="color: red">(*)</span></span></td>
                    <td colspan="2"><span class="fw-bold">Quốc tịch <span style="color: red">(*)</span></span></td>
                </tr>
                <tr>
                    <td colspan="2"><form:input path="birthday"/> </td>
                    <td colspan="2"><form:select path="gender" items="${genderList}"/>
                    <td colspan="2"><form:select path="country" items="${countryList}"/></td>
                </tr>

                <tr>
                    <td colspan="6"><span
                            class="fw-bold">Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác <span
                            style="color: red">(*)</span></span>
                    </td>
                </tr>
                <tr>
                    <td colspan="6"><form:input path="idCard"/></td>
                </tr>

                <tr>
                    <td colspan="6"><span class="fw-bold">Thông tin đi lại <span style="color: red">(*)</span></span>
                    </td>
                </tr>
                <tr>
                    <td colspan="6">
                        <form:radiobuttons path="phuongTien" items="${danhSachPhuongTien}"/>
                    </td>
                </tr>

                <tr>
                    <td colspan="3"><p class="fw-bold">Số phương tiện</p></td>
                    <td colspan="3"><p class="fw-bold">Số ghế</p></td>
                </tr>
                <tr>
                    <td colspan="3">
                        <form:input path="tenPhuongTien"/>
                    </td>
                    <td colspan="3">
                        <form:input path="soGhe"/>
                    </td>
                </tr>

                <tr>
                    <td colspan="3"><p class="fw-bold">Ngày khởi hành</p></td>
                    <td colspan="3"><p class="fw-bold">Ngày kết thúc</p></td>
                </tr>
                <tr>
                    <td colspan="3">
                        <form:input path="ngayKhoiHanh"/>
                    </td>
                    <td colspan="3">
                        <form:input path="ngayKetThuc"/>
                    </td>
                </tr>

                <tr>
                    <td colspan="6"><span class="fw-bold">Trong 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào? <span
                            style="color: red">(*)</span></span></td>
                </tr>
                <tr>
                    <td colspan="6">
                        <form:input path="tinhDaDen"/>
                    </td>
                </tr>

            </table>
            <button>Gửi</button>
        </form:form>
    </div>
</div>
</body>
</html>
