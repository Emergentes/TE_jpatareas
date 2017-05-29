/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import emergentes.entidades.Tarea;
import emergentes.modelo.BeanTarea;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Procesa", urlPatterns = {"/Procesa"})
public class Procesa extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String opcion = request.getParameter("op");
        int id;
        BeanTarea bt = new BeanTarea();
        Tarea t = new Tarea();

        if (opcion.equals("editar")) {
            id = Integer.parseInt(request.getParameter("id"));

            t = bt.buscarTarea(id);
            request.setAttribute("tarea", t);
            request.getRequestDispatcher("editar.jsp").forward(request, response);
        }
        
        if (opcion.equals("eliminar")){
            id = Integer.parseInt(request.getParameter("id"));
            bt.eliminar(id);
            response.sendRedirect("index.jsp");
        }
        
        if (opcion.equals("guardarNuevo")) {

            t.setDescripcion(request.getParameter("descripcion"));
            t.setPrioridad(Integer.parseInt(request.getParameter("prioridad")));
            t.setObservaciones(request.getParameter("observaciones"));
            bt.insertar(t);
            response.sendRedirect("index.jsp");
        }
        if (opcion.equals("guardar")) {
            id = Integer.parseInt(request.getParameter("id"));
            t = bt.buscarTarea(id);
            t.setDescripcion(request.getParameter("descripcion"));
            t.setPrioridad(Integer.parseInt(request.getParameter("prioridad")));
            t.setObservaciones(request.getParameter("observaciones"));
            bt.editar(t);
            response.sendRedirect("index.jsp");
        }




    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
