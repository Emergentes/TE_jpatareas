<%@page import="emergentes.entidades.Tarea"%>
<%
    Tarea t = new Tarea();
    
    t = (Tarea) request.getAttribute("tarea");
       
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tarea</h1>
        <form action="Procesa?opcion=guardar" method="post">
            <input type="hidden" name="id" value="<%= t.getId()%>">
            Tarea: <input type="text" name="descripcion" value="<%= t.getDescripcion()%>">
            <br>
            Prioridad: <input type="text" name="prioridad" value="<%= t.getPrioridad() %>">
            <br>
            Observaciones: <textarea name="observaciones"><%= t.getObservaciones() %></textarea>
            <br>
            <input type="submit">
        </form>
    </body>
</html>
