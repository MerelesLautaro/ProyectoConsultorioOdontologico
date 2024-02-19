package servelets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Horario;

@WebServlet(name = "SvHorario", urlPatterns = {"/SvHorario"})
public class SvHorario extends HttpServlet {
    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Horario> listHorarios = new ArrayList<>();
        
        listHorarios = control.getHorarios();
        
        HttpSession mysession = request.getSession();
        mysession.setAttribute("listHorarios", listHorarios);
        response.sendRedirect("altaHorarios.jsp");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       
            String horarioInicio = request.getParameter("txtInicio");
            String horarioFin = request.getParameter("txtFin");

            control.crearHorario(horarioInicio, horarioFin);
            response.sendRedirect("SvHorario");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
