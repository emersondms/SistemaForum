<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <div id="form_login">
            <form action="LoginServlet">
                <p class="titulo">Login</p>
                <input type="text" name="usuario" placeholder="Usuário" required/><br><br>
                <input type="password" name="senha" placeholder="Senha" required/><br><br>
                <a href="cadastro.jsp">Cadastre-se</a>
                <input type="submit" value="Entrar">
            </form>
            <p id="erro">${erro}</p>
            <p id="usuario_cadastrado">${usuario_cadastrado}</p>
        </div>
    </body>
</html>
