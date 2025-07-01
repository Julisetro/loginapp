# LoginApp

`LoginApp` es una aplicación web sencilla desarrollada como parte de la actividad de aprendizaje **GA7-220501096-AA2-EV02: Módulos de software codificados y probados**.

El objetivo principal de este ejercicio es demostrar el manejo de un formulario de registro utilizando Servlets y JSP. La aplicación permite a los usuarios registrarse con su nombre y correo electrónico. Los datos ingresados se almacenan temporalmente en la memoria caché de la aplicación (a través del `ServletContext`) y luego se muestran en una página JSP (`listarUsuarios.jsp`).

## Características

*   Formulario de registro de usuarios (nombre y correo electrónico).
*   Almacenamiento de datos en la memoria caché de la aplicación (los datos se pierden al reiniciar el servidor).
*   Visualización de los usuarios registrados en una tabla.
*   Uso del patrón Post-Redirect-Get para evitar reenvíos de formulario.

## Tecnologías Utilizadas

*   **Backend:** Java, Jakarta Servlets
*   **Frontend:** JSP, HTML, CSS
*   **Build:** Maven
*   **Servidor de Aplicaciones:** Compatible con Jakarta EE (ej. Apache Tomcat, GlassFish)

## ¿Cómo ejecutar el proyecto?

1.  Clona o descarga este repositorio.
2.  Abre el proyecto en tu IDE de Java preferido (como NetBeans, IntelliJ IDEA o Eclipse).
3.  Asegúrate de que las dependencias de Maven se descarguen correctamente (el proyecto usa `jakarta.jakartaee-api`).
4.  Construye el proyecto para generar el archivo `.war`.
5.  Despliega el archivo `.war` en un servidor de aplicaciones web como Apache Tomcat.
6.  Accede a la aplicación en tu navegador, generalmente en la URL: `http://localhost:8080/LoginApp/`.
