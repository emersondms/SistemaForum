<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <div id="form_cadastro">
            <form action="CadastroServlet">
                <p class="titulo">Cadastro</p>
                <input type="text" name="nome" placeholder="Nome" required/><br><br>
                <input type="text" name="login" placeholder="Usuário" required/><br><br>
                <input type="text" name="email" placeholder="E-mail" required/><br><br>
                <input type="password" name="senha" placeholder="Senha" required/><br><br>
                <input type="submit" value="Cadastrar">
            </form>
        </div>
    </body>
</html>
