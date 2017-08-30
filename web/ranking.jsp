<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Ranking</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <div id="conteudo_ranking">
            <div class="links">
                <span id="titulo_ranking" class="titulo">Ranking</span>
                <div id="link_topicos_ranking"><a href="TopicosServlet">Tópicos</a></div>
            </div><br><br><br><br>
            <table>
                <tr>
                    <th>#</th>
                    <th>Nome</th>
                    <th>Usuário</th>
                    <th>Pontos</th>
                </tr>    
                <c:set var="posicao" value="1"/> 
                <c:forEach var="usuario" items="${ranking}">
                    <tr>
                        <td>${posicao}</td>
                        <td>${usuario.getNome()}</td>
                        <td>${usuario.getLogin()}</td>
                        <td>${usuario.getPontos()}</td>
                    </tr>
                    <c:set var="posicao" value="${posicao + 1}"/> 
                </c:forEach>
            </table>
        </div>
    </body>
</html>
