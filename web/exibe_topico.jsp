<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Exibir tópico</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <div id="conteudo_exibe_topico">
            <div class="links">
                <span id="titulo_exibir_topico" class="titulo">Exibir tópico</span>
                <div id="link_topicos"><a href="TopicosServlet">Tópicos</a></div>
            </div><br><br><br><br><br>
            <p id="titulo_topico">${topico.getTitulo()}</p>
            <hr>
            <span id="login_topico"><b>${topico.getLogin()}</b></span><br><br>
            <div id="conteudo_topico">${topico.getConteudo()}</div><br>
            <p>Comentários:</p>
            <form action="InsereComentarioServlet">
                <div>
                    <textarea name="comentario" cols="50" placeholder="Insira um comentário"></textarea>   
                    <input type="submit" id="botao_comentar" value="Comentar">
                </div><br>
                <input name="id_topico" value="${topico.getId()}" hidden/>
            </form>
            <c:forEach var="comentario" items="${comentarios}">
                <span id="login_comentario"><b>${comentario.getLogin()}</b></span><br>
                <span id="comentario">${comentario.getComentario()}</span><br>
                <hr>
            </c:forEach>
        </div>
    </body>
</html>
