
package com.salon.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/citas")
public class CitaServlet extends HttpServlet {

    private static final List<String> citas = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("citas", citas);
        request.getRequestDispatcher("/citas.jsp")
               .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String nombre = request.getParameter("nombre");
        String servicio = request.getParameter("servicio");
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");

        String nuevaCita = "Cliente: " + nombre
                + " | Servicio: " + servicio
                + " | Fecha: " + fecha
                + " | Hora: " + hora;

        citas.add(nuevaCita);

        response.sendRedirect(
                request.getContextPath() + "/citas"
        );
    }
}

