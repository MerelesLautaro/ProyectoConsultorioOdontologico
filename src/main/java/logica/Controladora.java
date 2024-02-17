package logica;

import java.util.ArrayList;
import java.util.List;
import persistencia.ControladoraPersistencia;

public class Controladora {
    ControladoraPersistencia controlPersistencia = new ControladoraPersistencia();

    public void crearUsuario(String nombre, String contrasenia, String rol) {
        Usuario usuario = new Usuario();
        
        usuario.setNombreUsuario(nombre);
        usuario.setContrasenia(contrasenia);
        usuario.setRol(rol);
        
        controlPersistencia.crearUsuario(usuario);
    }

    public List<Usuario> getUsers() {
        return controlPersistencia.getUsers();
    }

    public void deleteUser(int id) {
        controlPersistencia.deleteUser(id);
    }

    public Usuario getOneUser(int id) {
        return controlPersistencia.getOneUser(id);
    }

    public void editUser(Usuario usuario, String nombre, String password, String rol) {
        usuario.setNombreUsuario(nombre);
        usuario.setContrasenia(password);
        usuario.setRol(rol);
                   
        controlPersistencia.editUser(usuario);
    }
    
        
}
