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
import logica.Secretaria;

@WebServlet(name = "SvSecretaria", urlPatterns = {"/SvSecretaria"})
public class SvSecretaria extends HttpServlet {
    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Secretaria> listSecretaria = new ArrayList<>();
        
        listSecretaria = control.getSecretarias();
        
        HttpSession mysession = request.getSession();
        mysession.setAttribute("listSecretaria", listSecretaria);
        
        response.sendRedirect("verSecretarias.jsp");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try{
            String dni = request.getParameter("txtDni");
            String nombre = request.getParameter("txtNombre");
            String apellido = request.getParameter("txtApellido");
            String telefono = request.getParameter("txtTelefono");
            String direccion = request.getParameter("txtDireccion");
            String fechaNacStr = request.getParameter("txtNac");
            //Parseo de la fecha de nac. de String a Date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaNac = dateFormat.parse(fechaNacStr);
            String sector= request.getParameter("txtSector");
            String nombreUsuario = request.getParameter("txtUsuario");
            
            control.crearSecretaria(dni,nombre,apellido,telefono,direccion,fechaNac,sector,nombreUsuario);
            
            response.sendRedirect("altaSecretaria.jsp");
            
        } catch (ParseException ex) {
            Logger.getLogger(SvOdontologo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
