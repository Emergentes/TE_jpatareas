<%@page import="emergentes.modelo.BeanTarea"%>
<%@page import="emergentes.entidades.Tarea"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Editar tarea</h1>
        <%
            BeanTarea bt = new BeanTarea();
            Tarea t = new Tarea();
            t = (Tarea) request.getAttribute("tarea");
            %>
        <form action="Procesa?op=guardar" method="post">
            <input type="hidden" name="id" value="<%= t.getId() %>">
            Tarea: <input type="text" name="descripcion" value="<%= t.getDescripcion() %>">
            <br>
            Prioridad: <input type="number" name="prioridad" value="<%=t.getPrioridad()%>">
            <br>
            Observaciones: <textarea name="observaciones"><%=t.getObservaciones()%></textarea>
            <br>
            <input type="submit">
        </form>
    </body>
</html>
    </body>
</html>
