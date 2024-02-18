package logica;

import java.util.Date;
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

    public void crearOdontolog(String dni, String nombre, String apellido, String telefono, String direccion, Date fechaNac, String especialidad) {
        Odontologo odontologo = new Odontologo();
        
        odontologo.setDni(dni);
        odontologo.setNombre(nombre);
        odontologo.setApellido(apellido);
        odontologo.setTelefono(telefono);
        odontologo.setDireccion(direccion);
        odontologo.setFecha_nac(fechaNac);
        odontologo.setEspecialidad(especialidad);
        
        controlPersistencia.crearOdontologo(odontologo);
    }

    public List<Odontologo> getOdonto() {
        return controlPersistencia.getOdonto();
    }

    public void crearSecretaria(String dni, String nombre, String apellido, String telefono, String direccion, Date fechaNac, String sector, String nombreUsuario) {
        Secretaria secretaria = new Secretaria();
        
        secretaria.setDni(dni);
        secretaria.setNombre(nombre);
        secretaria.setApellido(apellido);
        secretaria.setTelefono(telefono);
        secretaria.setDireccion(direccion);
        secretaria.setFecha_nac(fechaNac);
        secretaria.setSector(sector);
        
        Usuario usu = new Usuario();
        
        usu = this.traerUsuario(nombreUsuario);
        
        if(usu!=null){
            secretaria.setUsuario(usu);
        }
        
        controlPersistencia.crearSecretaria(secretaria);
    }
    
    private Usuario traerUsuario(String nombreUsuario){
        List<Usuario> listaUsuarios = this.getUsers();
                
        for(Usuario usuario:listaUsuarios){
            //Si el rol que nos paso el usuario esta, retornamos el rol completo.
            if(usuario.getNombreUsuario().equals(nombreUsuario))
                return usuario;
        }
        //Si no se encuentra retorna null
        return null;      
    }

    public List<Secretaria> getSecretarias() {
        return controlPersistencia.getSecretarias();
    }

    public void deleteSecretaria(int id) {
        controlPersistencia.deleteSecretaria(id);
    }

        
}
