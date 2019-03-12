<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11.03.2019
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SqlWebAppByVlasov</title>
</head>
<body>
    <br>
    Добро пожаловать в базу данных))<br>
    Введите текст согласно паттерну команды в окно ввода и выберите подходящую операцию<br>
    <form action="/workwithdb" method="post">
        <input type="text" name="sqlParameters" size="100"><br>
        <input type="radio" name="command" value="create">Создать таблицу<br>
        <input type="radio" name="command" value="insert">Добавить данные в таблицу<br>
        <input type="radio" name="command" value="update">Обновить данные в таблице<br>
        <input type="radio" name="command" value="delete">Удалить данные из таблицы<br>
        <input type="radio" name="command" value="find">Показать содержимое таблицы<br>
        <input type="radio" name="command" value="clear">Очистить таблицу<br>
        <input type="radio" name="command" value="drop">Удалить таблицу<br>
        <input type="radio" name="command" value="exit">Отсоединиться и вернуться на главную страницу<br>
        <input type="submit" name="send">
    </form>
</body>
</html>
