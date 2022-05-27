<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arithmetic Calculator</title>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>
        <form method="POST" action="arithmetic">
            <label>First:</label>
            <input type="text" name="first_number" value="${firstNumber}">
            <br>
            <label>Second:</label>
            <input type="text" name="second_number" value="${secondNumber}">
            <br>
            <input type="submit" name="add" value="+">
            <input type="submit" name="sub" value="-">
            <input type="submit" name="mul" value="*">
            <input type="submit" name="mod" value="%">
        </form>
        <p>Result: ${message}</p>
        <a href="age">Age Calculator</a>  
    </body>
</html>