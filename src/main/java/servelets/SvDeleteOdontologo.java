package servelets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Horario;

@WebServlet(name = "SvDeleteOdontologo", urlPatterns = {"/SvDeleteOdontologo"})
public class SvDeleteOdontologo extends HttpServlet {
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
        mysession.setAttribute("listHorarios",listHorarios);
        
        response.sendRedirect("altaOdontologo.jsp");
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        control.deleteOdontologo(id);
        response.sendRedirect("SvOdontologo");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
