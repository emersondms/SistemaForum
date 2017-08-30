<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Inserir tópico</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <div id="form_insere_topico">
            <form action="InsereTopicoServlet">
                <p class="titulo">Inserir tópico</p>
                <input type="text" name="titulo" placeholder="Título" required/><br><br>
                <textarea name="conteudo" rows="3" cols="29" placeholder="Conteúdo" required></textarea><br><br>
                <input type="submit" value="Inserir"/>
            </form>
        </div>
    </body>
</html>
