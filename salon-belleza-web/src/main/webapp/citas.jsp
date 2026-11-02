
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Gestión de Citas - Salón de Belleza</title>

    <style>
        /* Estilos generales de la página */
        body {
            font-family: Arial, sans-serif;
            background-color: #fceef3;
            margin: 0;
            padding: 30px;
        }

        /* Contenedor principal */
        .contenedor {
            max-width: 650px;
            margin: auto;
            background: white;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 3px 12px #cccccc;
        }

        h1, h2 {
            color: #a33d68;
            text-align: center;
        }

        /* Campos del formulario */
        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
        }

        input, select {
            width: 100%;
            padding: 11px;
            margin-top: 6px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 6px;
        }

        /* Boton de registro */
        button {
            width: 100%;
            margin-top: 22px;
            padding: 13px;
            background-color: #b84f7b;
            color: white;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-size: 16px;
        }

        button:hover {
            background-color: #92365e;
        }

        /* Presentacion de las citas */
        .cita {
            background: #fff1f6;
            padding: 12px;
            margin-top: 10px;
            border-radius: 6px;
        }
    </style>
</head>

<body>

<div class="contenedor">

    <h1>Salón de Belleza</h1>
    <h2>Agendar una cita</h2>

    <!-- Formulario para registrar una cita -->
    <form action="${pageContext.request.contextPath}/citas" method="post">

        <label for="nombre">Nombre del cliente:</label>
        <input type="text" id="nombre" name="nombre"
               maxlength="100" required>

        <label for="servicio">Servicio:</label>
        <select id="servicio" name="servicio" required>
            <option value="">Seleccione un servicio</option>
            <option value="Corte de cabello">Corte de cabello</option>
            <option value="Manicure">Manicure</option>
            <option value="Pedicure">Pedicure</option>
            <option value="Peinado">Peinado</option>
            <option value="Tinte">Tinte</option>
        </select>

        <label for="fecha">Fecha:</label>
        <input type="date" id="fecha" name="fecha" required>

        <label for="hora">Hora:</label>
        <input type="time" id="hora" name="hora" required>

        <button type="submit">Registrar cita</button>

    </form>

    <!-- Seccion donde aparecen las citas registradas -->
    <h2>Citas registradas</h2>

    <%
        // Recuperar la lista enviada por el Servlet.
        List<String> citas =
            (List<String>) request.getAttribute("citas");

        // Comprobar si existen citas registradas.
        if (citas != null && !citas.isEmpty()) {
            for (String cita : citas) {
    %>

        <div class="cita">
            <%= cita %>
        </div>

    <%
            }
        } else {
    %>

        <p style="text-align:center;">
            Todavía no hay citas registradas.
        </p>

    <%
        }
    %>

</div>

</body>
</html>
