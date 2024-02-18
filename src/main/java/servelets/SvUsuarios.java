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
import logica.Usuario;

@WebServlet(name = "SvUsuarios", urlPatterns = {"/SvUsuarios"})
public class SvUsuarios extends HttpServlet {
    
    Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Usuario> listUsers = new ArrayList<Usuario>();
        
        
        
        listUsers = control.getUsers();
        
        HttpSession mysession = request.getSession();
        mysession.setAttribute("listUsers",listUsers);
        
        response.sendRedirect("verUsuarios.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("txtNombre");
        String contrasenia = request.getParameter("txtPassword");
        String confContrasenia = request.getParameter("txtPasswordTwo");
        String rol = request.getParameter("txtRol");
        
        if(contrasenia.equals(confContrasenia)){
            control.crearUsuario(nombre,contrasenia,rol);
            String msjError = "";
            HttpSession sessionError = request.getSession();
            sessionError.setAttribute("msjError", msjError);
            response.sendRedirect("altaUsuario.jsp");  
        } else {
            String msjError = "Verifique los datos ingresados";
            HttpSession sessionError = request.getSession();
            sessionError.setAttribute("msjError", msjError);
            response.sendRedirect("altaUsuario.jsp");  
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
