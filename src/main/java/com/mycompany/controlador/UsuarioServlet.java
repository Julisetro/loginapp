package com.mycompany.controlador;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet para gestionar el registro de usuarios.
 * Utiliza el ServletContext para almacenar la lista de usuarios en memoria (caché),
 * para que los datos sean compartidos por toda la aplicación.
 */
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/login"})
public class UsuarioServlet extends HttpServlet {

    /**
     * Clase interna estática para representar a un Usuario.
     */
    public static class Usuario implements Serializable {
        private static final long serialVersionUID = 1L;
        private final String nombre;
        private final String email;

        public Usuario(String nombre, String email) {
            this.nombre = nombre;
            this.email = email;
        }

        public String getNombre() { return nombre; }
        public String getEmail() { return email; }
    }

    /**
     * Se ejecuta una sola vez al inicializar el servlet.
     * Crea la lista de usuarios y la guarda en el ServletContext.
     */
    @Override
    public void init() throws ServletException {
        // Se crea una lista que actuará como "base de datos" en memoria.
        List<Usuario> usuarios = new ArrayList<>();
        // Se guarda en el context de la aplicación para que sea accesible globalmente.
        getServletContext().setAttribute("listaUsuarios", usuarios);
    }

    /**
     * Maneja las peticiones GET.
     * Redirige al formulario de registro para evitar URLs directas al servlet.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Redirige al usuario al formulario si intenta acceder por GET.
        response.sendRedirect(request.getContextPath() + "/index.html");
    }

    /**
     * Maneja las peticiones POST del formulario de registro.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener los datos del formulario.
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        // La contraseña se recibe pero no se almacena para este ejercicio

        // Crear el objeto Usuario.
        Usuario nuevoUsuario = new Usuario(nombre, email);

        // Obtener la lista del ServletContext de forma segura.
        ServletContext context = getServletContext();
        List<Usuario> listaUsuarios = (List<Usuario>) context.getAttribute("listaUsuarios");

        // Sincronizar el acceso a la lista para evitar problemas de concurrencia.
        synchronized (listaUsuarios) {
            listaUsuarios.add(nuevoUsuario);
        }

        // Redirigir a la página de visualización (Patrón Post-Redirect-Get).
        response.sendRedirect(request.getContextPath() + "/listarUsuarios.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Servlet para registrar usuarios y almacenarlos en caché.";
    }
}