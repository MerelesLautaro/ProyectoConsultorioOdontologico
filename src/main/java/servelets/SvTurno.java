package servelets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Odontologo;
import logica.Paciente;
import logica.Turno;

@WebServlet(name = "SvTurno", urlPatterns = {"/SvTurno"})
public class SvTurno extends HttpServlet {
    Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Odontologo> listOdontologo = new ArrayList<>();
        List<Paciente> listPaciente = new ArrayList<>();
        List<Turno> listTurno = new ArrayList<>();
        
        listOdontologo = control.getOdonto();
        listPaciente = control.getPacientes();
        listTurno = control.getTurnos();
        
        HttpSession mysession = request.getSession();
        mysession.setAttribute("listOdontologo", listOdontologo);
        
        HttpSession mysessionTwo = request.getSession();
        mysessionTwo.setAttribute("listPaciente", listPaciente);
        
        HttpSession mysessionThree = request.getSession();
        mysessionThree.setAttribute("listTurno",listTurno);
        
        response.sendRedirect("altaTurnos.jsp");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String atencion = request.getParameter("txtAtencion");
            String fechaStr = request.getParameter("txtFecha");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaTurno = dateFormat.parse(fechaStr);
            String horaTurno = request.getParameter("txtHora");
            int idOdontologo = Integer.parseInt(request.getParameter("txtOdontologo"));
            int idPaciente = Integer.parseInt(request.getParameter("txtPaciente"));
            
            control.createTurno(atencion,fechaTurno,horaTurno,idOdontologo,idPaciente);
            
        } catch (ParseException ex) {
            Logger.getLogger(SvTurno.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.sendRedirect("altaTurnos.jsp");
        
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
