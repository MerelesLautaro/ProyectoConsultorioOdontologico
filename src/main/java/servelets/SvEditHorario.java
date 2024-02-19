package servelets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Horario;


@WebServlet(name = "SvEditHorario", urlPatterns = {"/SvEditHorario"})
public class SvEditHorario extends HttpServlet {
    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
                
        Horario editHorario = control.getOneHorario(id);
        
        HttpSession mysessionEdit = request.getSession();
        mysessionEdit.setAttribute("editHorario", editHorario);
        response.sendRedirect("SvHorario");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String horaInicio = request.getParameter("txtInicio");
        String horaFin = request.getParameter("txtFin");
        
        Horario editHorario = (Horario) request.getSession().getAttribute("editHorario");
        
        control.editHorario(editHorario,horaInicio,horaFin);
        response.sendRedirect("SvHorario");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
