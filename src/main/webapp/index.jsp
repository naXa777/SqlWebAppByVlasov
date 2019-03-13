<%--
  Created by IntelliJ IDEA.
  User: Eugen
  Date: 06.03.2019
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <title>SqlWebAppByVlasov</title>
</head>
<body>
<br>
<br>
<br>
 Приветствую тебя, Юзер. Перед началом работы присоединись к базе данных<br>
 Либо нажми на кнопку 'help', чтобы узнать значение всех кнопок<br>
<form action="connection" method="post">
    Логин: postgres<!--написал правильные данные для сравнения в качестве подсказки -->
    <input type = "text" name="login" size="40">
    <br>
    Пароль: root<!--написал правильные данные для сравнения в качестве подсказки -->
    <input type="password" name="password" size="40">
    <br>
    Имя БД: test<!--написал правильные данные для сравнения в качестве подсказки -->
    <input type="text" name="dbName" size="40">
    <br>
    <input type="submit" value="Присоедениться">
</form>
<form action="help.jsp" method="get">
    <button>help</button>
</form>
</body>
</html>
