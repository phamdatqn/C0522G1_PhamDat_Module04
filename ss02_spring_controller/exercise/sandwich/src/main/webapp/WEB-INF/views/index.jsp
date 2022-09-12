<%--
  Created by IntelliJ IDEA.
  User: phamd
  Date: 12/09/2022
  Time: 11:16 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="/save" method="post">
    <table>
        <tr>
            <td>
                <input type="checkbox" name="condiment" value="Lettuce">Lettuce
            </td>
            <td>
                <input type="checkbox" name="condiment" value="Tomato">Tomato
            </td>
            <td>
                <input type="checkbox" name="condiment" value="Mustard">Mustard

            </td>
            <td>
                <input type="checkbox" name="condiment" value="Sprouts">Sprouts
            </td>
        </tr>
    </table>
    <button>Save</button>
</form>
</body>
</html>
