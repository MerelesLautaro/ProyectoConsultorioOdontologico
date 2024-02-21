package servelets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Turno;

@WebServlet(name = "SvEditTurno", urlPatterns = {"/SvEditTurno"})
public class SvEditTurno extends HttpServlet {
    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Turno turnoEdit = control.getOneTurno(id);
        
        HttpSession mysession = request.getSession();
        mysession.setAttribute("turnoEdit",turnoEdit);
        
        response.sendRedirect("SvTurno");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Turno turnoEdit = (Turno)request.getSession().getAttribute("turnoEdit");
        try {
            String atencion = request.getParameter("txtAtencion");
            String fechaStr = request.getParameter("txtFecha");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaTurno = dateFormat.parse(fechaStr);
            String horaTurno = request.getParameter("txtHora");
            int idOdontologo = Integer.parseInt(request.getParameter("txtOdontologo"));
            int idPaciente = Integer.parseInt(request.getParameter("txtPaciente"));

            control.editTurno(turnoEdit,atencion, fechaTurno, horaTurno, idOdontologo, idPaciente);

        } catch (ParseException ex) {
            Logger.getLogger(SvTurno.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.sendRedirect("SvTurno");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
