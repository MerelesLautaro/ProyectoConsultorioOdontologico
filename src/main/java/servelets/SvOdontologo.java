package servelets;

import java.io.IOException;
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

@WebServlet(name = "SvOdontologo", urlPatterns = {"/SvOdontologo"})
public class SvOdontologo extends HttpServlet {
    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Odontologo> listOdonto = new ArrayList<Odontologo>();
             
        listOdonto = control.getOdonto();
        
        HttpSession mysession = request.getSession();
        mysession.setAttribute("listOdonto",listOdonto);
        
        response.sendRedirect("verOdontologos.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            String dni = request.getParameter("txtDniOdon");
            String nombre = request.getParameter("txtNombreOdon");
            String apellido = request.getParameter("txtApellidoOdon");
            String telefono = request.getParameter("txtTelefonoOdon");
            String direccion = request.getParameter("txtDireccionOdon");
            String fechaNacStr = request.getParameter("txtNacOdon");
            //Parseo de la fecha de nac. de String a Date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaNac = dateFormat.parse(fechaNacStr);
            String especialidad = request.getParameter("txtEspecialidadOdon");
            
            control.crearOdontolog(dni,nombre,apellido,telefono,direccion,fechaNac,especialidad);
            
            response.sendRedirect("altaOdontologo.jsp");
            
        } catch (ParseException ex) {
            Logger.getLogger(SvOdontologo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
