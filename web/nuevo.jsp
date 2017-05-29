<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Nueva tarea</h1>
        <form action="Procesa?op=guardarNuevo" method="post">
            Tarea: <input type="text" name="descripcion" value="">
            <br>
            Prioridad: <input type="number" name="prioridad" value="">
            <br>
            Observaciones: <textarea name="observaciones"></textarea>
            <br>
            <input type="submit">
        </form>
    </body>
</html>
