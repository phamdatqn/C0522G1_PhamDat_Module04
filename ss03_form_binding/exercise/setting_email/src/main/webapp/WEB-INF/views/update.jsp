<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: phamd
  Date: 13/09/2022
  Time: 12:48 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="email" method="post" action="/update">
    <table>
        <tr>
            <form:hidden path="id"/>
            <td>Languages</td>
            <td>
                <form:select path="languages" items="${languagesList}"/>
            </td>
        </tr>
        <tr>
            <td>Page Size</td>
            <td>
                show <form:select path="pageSize" items="${pageSizeList}"/> emails per page
            </td>
        </tr>
        <tr>
            <td>Spams filter</td>
            <td>
                <form:radiobutton path="spamsFilter" value="true" label="Enable spams filter"/>
            </td>
        </tr>
        <tr>
            <td>Signature</td>
            <td>
                <form:textarea path="signature"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button>Update</button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
