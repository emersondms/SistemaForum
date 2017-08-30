<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Tópicos</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <div class="links">
            <span id="titulo_topicos" class="titulo">Tópicos</span>
            <div id="link_ranking"><a href="RankingServlet">Ranking</a></div>
            <div id="link_inserir_topico"><a href="insere_topico.jsp">Inserir tópico</a></div>
        </div><br><br><br><br><br>
        <c:forEach var="topico" items="${topicos}">
            <div id="topico">
                <a href="ExibeTopicoServlet?id_topico=${topico.getId()}">
                    ${topico.getTitulo()}
                </a>
                <p id="topico_login">${topico.getLogin()}</p>
            </div><br>
            <hr>
        </c:forEach>
    </body>
</html>
