
package com.salon.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Servlet encargado de gestionar las citas del salon.
@WebServlet("/citas")
public class CitaServlet extends HttpServlet {

    // Lista temporal para almacenar las citas registradas.
    private static final List<String> citas = new ArrayList<>();

    // Metodo GET: muestra las citas registradas.
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("citas", citas);

        request.getRequestDispatcher("/citas.jsp")
               .forward(request, response);
    }

    // Metodo POST: recibe y registra una nueva cita.
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        // Obtener los datos enviados desde el formulario.
        String nombre = request.getParameter("nombre");
        String servicio = request.getParameter("servicio");
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");

        // Validar que todos los campos esten completos.
        if (nombre == null || nombre.isBlank()
                || servicio == null || servicio.isBlank()
                || fecha == null || fecha.isBlank()
                || hora == null || hora.isBlank()) {

            response.sendError(
                HttpServletResponse.SC_BAD_REQUEST,
                "Todos los campos son obligatorios."
            );
            return;
        }

        // Crear una nueva cita con los datos del cliente.
        String nuevaCita = "Cliente: " + nombre
                + " | Servicio: " + servicio
                + " | Fecha: " + fecha
                + " | Hora: " + hora;

        // Agregar la cita a la lista.
        citas.add(nuevaCita);

        // Redirigir para mostrar las citas actualizadas.
        response.sendRedirect(
                request.getContextPath() + "/citas"
        );
    }
}
