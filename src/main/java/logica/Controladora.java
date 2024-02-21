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

    public void crearOdontolog(String dni, String nombre, String apellido, String telefono, String direccion, Date fechaNac, String especialidad, String usuarioOdon, int idHorario) {
        Odontologo odontologo = new Odontologo();
        
        odontologo.setDni(dni);
        odontologo.setNombre(nombre);
        odontologo.setApellido(apellido);
        odontologo.setTelefono(telefono);
        odontologo.setDireccion(direccion);
        odontologo.setFecha_nac(fechaNac);
        odontologo.setEspecialidad(especialidad);
        
        //Comparamos el usuario ingresado para el odontologo con los existentes
        //Si el usuario existe lo seteamos.
        Usuario usu = new Usuario();        
        usu = this.traerUsuario(usuarioOdon);     
        if(usu!=null){
            odontologo.setUsuario(usu);
        }        
        
        //Comparamos el horario ingresado para el odontologo con los existentes
        //Si el horario existe lo seteamos.
        Horario horarioLaboral = new Horario();
        horarioLaboral = this.traerHorario(idHorario);
        if(horarioLaboral!=null){
            odontologo.setHorario(horarioLaboral);
        }
        
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

    public Secretaria getOneSecretaria(int id) {
        return controlPersistencia.getOneSecretaria(id);
    }

    public void editarSecretaria(Secretaria secretaria, String dni, String nombre, String apellido, String telefono, String direccion, Date fechaNac, String sector, String nombreUsuario) {
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
        
        controlPersistencia.editarSecretaria(secretaria);
    }

    public void crearHorario(String horarioInicio, String horarioFin) {
        Horario horario = new Horario();
        horario.setHorario_inicio(horarioInicio);
        horario.setHorario_fin(horarioFin);               
        controlPersistencia.crearHorario(horario);
    }

    public List<Horario> getHorarios() {
        return controlPersistencia.getHorarios();
    }

    public void deleteHorario(int id) {
        controlPersistencia.deleteHorario(id);
    }

    public Horario getOneHorario(int id) {
        return controlPersistencia.getOneHorario(id);
    }

    public void editHorario(Horario editHorario, String horaInicio, String horaFin) {
        editHorario.setHorario_fin(horaFin);
        editHorario.setHorario_inicio(horaInicio);
        
        controlPersistencia.editHorario(editHorario);
    }

    private Horario traerHorario(int idHorario) {
        List<Horario> horariosLaborales = controlPersistencia.getHorarios();
        
        for(Horario horaLaboral: horariosLaborales){
            if(idHorario ==(horaLaboral.getId_horario())){
                return horaLaboral;
            }
        }
        return null;
    }

    public void deleteOdontologo(int id) {
        controlPersistencia.deleteOdontologo(id);
    }

    public Odontologo getOneOdontologo(int id) {
        return controlPersistencia.getOneOdontologo(id);
    }

    public void editOdontologo(Odontologo odontologo, String dni, String nombre, String apellido, String telefono, String direccion, Date fechaNac, String especialidad, String nombreUsuario, int idHorario) {
        odontologo.setDni(dni);
        odontologo.setNombre(nombre);
        odontologo.setApellido(apellido);
        odontologo.setTelefono(telefono);
        odontologo.setDireccion(direccion);
        odontologo.setFecha_nac(fechaNac);
        odontologo.setEspecialidad(especialidad);
        
        //Comparamos el usuario ingresado para el odontologo con los existentes
        //Si el usuario existe lo seteamos.
        Usuario usu = new Usuario();        
        usu = this.traerUsuario(nombreUsuario);     
        if(usu!=null){
            odontologo.setUsuario(usu);
        }        
        
        //Comparamos el horario ingresado para el odontologo con los existentes
        //Si el horario existe lo seteamos.
        Horario horarioLaboral = new Horario();
        horarioLaboral = this.traerHorario(idHorario);
        if(horarioLaboral!=null){
            odontologo.setHorario(horarioLaboral);
        }
        
        controlPersistencia.editOdontologo(odontologo);
    }

    public void createResponsable(String dni, String nombre, String apellido, String telefono, String direccion, Date fechaNac, String tipoRes) {
        Responsable responsable = new Responsable();
        responsable.setDni(dni);
        responsable.setNombre(nombre);
        responsable.setApellido(apellido);
        responsable.setTelefono(telefono);
        responsable.setDireccion(direccion);
        responsable.setFecha_nac(fechaNac);
        responsable.setTipo_responsabilidad(tipoRes);
        
        controlPersistencia.createResponsable(responsable);
    }

    public List<Responsable> getResponsables() {
        return controlPersistencia.getResponsables();
    }

    public Responsable getOneResponsable(int id) {
        return controlPersistencia.getOneResponsable(id);
    }

    public void editResponsable(Responsable responsableEdit, String dni, String nombre, String apellido, String direccion, String tipoRes, Date fechaNac) {
        responsableEdit.setDni(dni);
        responsableEdit.setNombre(nombre);
        responsableEdit.setApellido(apellido);
        responsableEdit.setDireccion(direccion);
        responsableEdit.setTipo_responsabilidad(tipoRes);
        responsableEdit.setFecha_nac(fechaNac);
        
        controlPersistencia.editResponsable(responsableEdit);
    }

    public void deleteResponsable(int id) {
        controlPersistencia.deleteResponsable(id);
    }

    public void createPaciente(String dni, String nombre, String apellido, String telefono, String direccion, Date fechaNac, String tipoSangre, boolean obraSocial, int idResponsable) {
        Paciente paciente = new Paciente();
        paciente.setDni(dni);
        paciente.setNombre(nombre);
        paciente.setApellido(apellido);
        paciente.setTelefono(telefono);
        paciente.setDireccion(direccion);
        paciente.setFecha_nac(fechaNac);
        paciente.setTipo_sangre(tipoSangre);
        paciente.setTiene_OS(obraSocial);
        
        Responsable responsable = new Responsable();
        responsable = this.getOneResponsable(idResponsable);
        paciente.setResponsable(responsable);
        
        controlPersistencia.createPaciente(paciente);
        
    }

    public List<Paciente> getPacientes() {
        return controlPersistencia.getPacientes();
    }

    public void deletePaciente(int id) {
        controlPersistencia.deletePaciente(id);
    }

    public Paciente getOnePaciente(int id) {
        return controlPersistencia.getOnePaciente(id);
    }

    public void editPaciente(Paciente pacienteEdit, String dni, String nombre, String apellido, String telefono, String direccion, Date fechaNac, String tipoSangre, boolean obraSocial, int idResponsable) {
        
        pacienteEdit.setDni(dni);
        pacienteEdit.setNombre(nombre);
        pacienteEdit.setApellido(apellido);
        pacienteEdit.setTelefono(telefono);
        pacienteEdit.setDireccion(direccion);
        pacienteEdit.setFecha_nac(fechaNac);
        pacienteEdit.setTipo_sangre(tipoSangre);
        pacienteEdit.setTiene_OS(obraSocial);
        
        Responsable responsable = new Responsable();
        responsable = this.getOneResponsable(idResponsable);
        pacienteEdit.setResponsable(responsable);
        
        controlPersistencia.editPaciente(pacienteEdit);
    }

    public void createTurno(String atencion, Date fechaTurno, String horaTurno, int idOdontologo, int idPaciente) {
        Turno turno = new Turno();
        turno.setAtencion(atencion);
        turno.setFecha_turno(fechaTurno);
        turno.setHora_turno(horaTurno);
        
        Odontologo odontologo = new Odontologo();
        odontologo = this.getOneOdontologo(idOdontologo);
        turno.setOdontologo(odontologo);
        
        Paciente paciente = new Paciente();
        paciente = this.getOnePaciente(idPaciente);
        turno.setPaciente(paciente);
        
        controlPersistencia.createTurno(turno);
    }

    public List<Turno> getTurnos() {
        return controlPersistencia.getTurnos();
    }

    public void deleteTurno(int id) {
        controlPersistencia.deleteTurno(id);
    }

    public Turno getOneTurno(int id) {
        return controlPersistencia.getOneTurno(id);
    }

    public void editTurno(Turno turnoEdit, String atencion, Date fechaTurno, String horaTurno, int idOdontologo, int idPaciente) {
        turnoEdit.setAtencion(atencion);
        turnoEdit.setFecha_turno(fechaTurno);
        turnoEdit.setHora_turno(horaTurno);
        
        Odontologo odontologo = new Odontologo();
        odontologo = this.getOneOdontologo(idOdontologo);
        turnoEdit.setOdontologo(odontologo);
        
        Paciente paciente = new Paciente();
        paciente = this.getOnePaciente(idPaciente);
        turnoEdit.setPaciente(paciente);
        
        controlPersistencia.editTurno(turnoEdit);
    }





 
}
