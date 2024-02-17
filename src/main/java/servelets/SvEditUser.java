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
import logica.Usuario;

@WebServlet(name = "SvEditUser", urlPatterns = {"/SvEditUser"})
public class SvEditUser extends HttpServlet {
    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Traemos la ID del usuario el cual vamos a editar
        int id = Integer.parseInt(request.getParameter("id"));       
        //Guardamos el objeto usuario segun la ID obtenida.
        Usuario usuario = control.getOneUser(id);
        
        HttpSession mysession = request.getSession();
        mysession.setAttribute("userEdit", usuario);
        
        response.sendRedirect("editarUsuario.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("txtNombre");
        String password = request.getParameter("txtPassword");
        String passwordConf = request.getParameter("txtPasswordTwo");
        String rol = request.getParameter("txtRol");
        
        Usuario usuario = (Usuario)request.getSession().getAttribute("userEdit");
        
        if(password.equals(passwordConf)){
            control.editUser(usuario,nombre,password,rol);
            response.sendRedirect("SvUsuarios");
        } else {
            String msjError = "Verifique los datos ingresados";
            HttpSession sessionError = request.getSession();
            sessionError.setAttribute("msjError", msjError);
            response.sendRedirect("editarUsuario.jsp");
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
