<%@page import="emergentes.entidades.Tarea"%>
<%@page import="java.util.List"%>
<%@page import="emergentes.modelo.BeanTarea"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Gestor de tareas</h1>
        <%
            BeanTarea bt = new BeanTarea();
            List<Tarea> tareas = bt.obtenerTodos();
        %>
            
        
        <a href="nuevo.jsp">Nuevo</a>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Descripcion</th>
                <th>Prioridad</th>
                <th>Observaciones</th>
                <th></th>
                <th></th>
            </tr>
            <%
            for (Tarea item : tareas){
            %>
            <tr>
                <td><%= item.getId() %></td>
                <td><%= item.getDescripcion()%></td>
                <td><%= item.getPrioridad()%></td>
                <td><%= item.getObservaciones()%></td>
                <td><a href="Procesa?op=editar&id=<%= item.getId() %>">Editar</a></td>
                <td><a href="Procesa?op=eliminar&id=<%= item.getId() %>" onclick="confirm('Esta seguro de eliminar el registro??')">Eliminar</a></td>
            </tr>
            <%
            }
            %>
        </table>
        
        
    </body>
</html>
