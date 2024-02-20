package servelets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import logica.Paciente;
import logica.Responsable;

@WebServlet(name = "SvEditPaciente", urlPatterns = {"/SvEditPaciente"})
public class SvEditPaciente extends HttpServlet {
    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Responsable> listResponsable = control.getResponsables();
        HttpSession mysessionOne = request.getSession();
        mysessionOne.setAttribute("listResponsable", listResponsable); 
        
        
        int id = Integer.parseInt(request.getParameter("id"));
        Paciente paciente = control.getOnePaciente(id);
        HttpSession mysession = request.getSession();
        mysession.setAttribute("pacienteEdit", paciente);
        response.sendRedirect("editPaciente.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Paciente pacienteEdit = (Paciente)request.getSession().getAttribute("pacienteEdit");
        try {
            String dni = request.getParameter("txtDni");
            String nombre = request.getParameter("txtNombre");
            String apellido = request.getParameter("txtApellido");
            String telefono = request.getParameter("txtTelefono");
            String direccion = request.getParameter("txtDireccion");
            String fechaNacStr = request.getParameter("txtNac");
            int idResponsable = Integer.parseInt(request.getParameter("txtRes"));
            //Parseo de la fecha de nac. de String a Date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaNac = dateFormat.parse(fechaNacStr);
            String tipoSangre = request.getParameter("txtSangre");
            //Pasamos el valor de la obra Social a true o false (debido a que la clase tiene ese atributo como boolean)
            String obraSocialStr = request.getParameter("cmbOS");
            boolean obraSocial = true;
            if (obraSocialStr.equals("SI")) {
                obraSocial = true;
            } else if (obraSocialStr.equals("NO")) {
                obraSocial = false;
            }
            control.editPaciente(pacienteEdit, dni, nombre, apellido, telefono, direccion, fechaNac, tipoSangre, obraSocial, idResponsable);
            response.sendRedirect("SvDeletePaciente");

        } catch (ParseException ex) {
            Logger.getLogger(SvOdontologo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
