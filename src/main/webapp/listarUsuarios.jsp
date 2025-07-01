<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.controlador.UsuarioServlet.Usuario" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Usuarios Registrados</title>
    <style>
        body { font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif; margin: 40px; background-color: #f4f7f6; color: #333; }
        .container { max-width: 800px; margin: auto; background: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.1); text-align: center; }
        h2 { color: #0056b3; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { padding: 12px; text-align: left; border-bottom: 1px solid #ddd; }
        thead { background-color: #007bff; color: white; }
        tbody tr:nth-child(even) { background-color: #f9f9f9; }
        tbody tr:hover { background-color: #e9ecef; }
        a { display: inline-block; margin-top: 20px; padding: 10px 15px; background-color: #28a745; color: white; text-decoration: none; border-radius: 5px; }
        a:hover { background-color: #218838; }
    </style>
</head>
<body>

    <div class="container">
        <h2>Lista de Usuarios Registrados en Caché</h2>

        <table>
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Correo Electrónico</th>
                </tr>
            </thead>
            <tbody>
                <%--
                    Obtenemos la lista de usuarios del 'application scope' (ServletContext).
                    Hacemos un cast al tipo de dato correcto (List<Usuario>).
                --%>
                <%
                    List<Usuario> usuarios = (List<Usuario>) application.getAttribute("listaUsuarios");
                    if (usuarios != null && !usuarios.isEmpty()) {
                        // Si la lista no es nula ni vacía, iteramos sobre ella.
                        for (Usuario usuario : usuarios) {
                %>
                            <tr>
                                <%-- Usamos los getters de la clase Usuario para mostrar los datos de forma segura --%>
                                <td><%= usuario.getNombre() %></td>
                                <td><%= usuario.getEmail() %></td>
                            </tr>
                <%
                        }
                    } else {
                        // Si no hay usuarios, mostramos un mensaje
                %>
                        <tr>
                            <td colspan="2">No hay usuarios registrados todavía. ¡Sé el primero!</td>
                        </tr>
                <%
                    }
                %>
            </tbody>
        </table>

        <a href="index.html">Registrar un nuevo usuario</a>
    </div>

</body>
</html>