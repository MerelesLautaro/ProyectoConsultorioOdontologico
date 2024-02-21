package persistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Horario;
import logica.Odontologo;
import logica.Paciente;
import logica.Responsable;
import logica.Secretaria;
import logica.Turno;
import logica.Usuario;
import persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {
    HorarioJpaController horarioController = new HorarioJpaController();
    OdontologoJpaController odontologoController = new OdontologoJpaController();
    PacienteJpaController pacienteController = new PacienteJpaController();
    PersonaJpaController personaController = new PersonaJpaController();
    ResponsableJpaController responsableController = new ResponsableJpaController();
    SecretariaJpaController secretariaController = new SecretariaJpaController();
    TurnoJpaController turnoController = new TurnoJpaController();
    UsuarioJpaController usuarioController = new UsuarioJpaController();

    public void crearUsuario(Usuario usuario) {
        usuarioController.create(usuario);
    }

    public List<Usuario> getUsers() {
        return usuarioController.findUsuarioEntities();
    }

    public void deleteUser(int id) {
        try {
            usuarioController.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario getOneUser(int id) {
        return usuarioController.findUsuario(id);
    }
    
    public void editUser(Usuario usuario){
        try {
            usuarioController.edit(usuario);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearOdontologo(Odontologo odontologo) {
        odontologoController.create(odontologo);   
    }

    public List<Odontologo> getOdonto() {
        return odontologoController.findOdontologoEntities();
    }    

    public void crearSecretaria(Secretaria secretaria) {
        secretariaController.create(secretaria);
    }

    public List<Secretaria> getSecretarias() {
        return secretariaController.findSecretariaEntities();
    }

    public void deleteSecretaria(int id) {
        try {
            secretariaController.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Secretaria getOneSecretaria(int id) {
        return secretariaController.findSecretaria(id);
    }

    public void editarSecretaria(Secretaria secretaria) {
        try {
            secretariaController.edit(secretaria);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearHorario(Horario horario) {
        horarioController.create(horario);
    }

    public List<Horario> getHorarios() {
        return horarioController.findHorarioEntities();
    }

    public void deleteHorario(int id) {
        try {
            horarioController.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Horario getOneHorario(int id) {
        return horarioController.findHorario(id);
    }

    public void editHorario(Horario editHorario) {
        try {
            horarioController.edit(editHorario);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteOdontologo(int id) {
        try {
            odontologoController.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Odontologo getOneOdontologo(int id) {
        return odontologoController.findOdontologo(id);
    }

    public void editOdontologo(Odontologo odontologo) {
        try {
            odontologoController.edit(odontologo);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createResponsable(Responsable responsable) {
        responsableController.create(responsable);
    }

    public List<Responsable> getResponsables() {
        return responsableController.findResponsableEntities();
    }

    public Responsable getOneResponsable(int id) {
        return responsableController.findResponsable(id);
    }

    public void editResponsable(Responsable responsableEdit) {
        try {
            responsableController.edit(responsableEdit);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteResponsable(int id) {
        try {
            responsableController.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createPaciente(Paciente paciente) {
        pacienteController.create(paciente);
    }

    public List<Paciente> getPacientes() {
        return pacienteController.findPacienteEntities();
    }

    public void deletePaciente(int id) {
        try {
            pacienteController.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Paciente getOnePaciente(int id) {
        return pacienteController.findPaciente(id);
    }

    public void editPaciente(Paciente pacienteEdit) {
        try {
            pacienteController.edit(pacienteEdit);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createTurno(Turno turno) {
        turnoController.create(turno);
    }

    public List<Turno> getTurnos() {
        return turnoController.findTurnoEntities();
    }

    public void deleteTurno(int id) {
        try {
            turnoController.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Turno getOneTurno(int id) {
        return turnoController.findTurno(id);
    }

    public void editTurno(Turno turnoEdit) {
        try {
            turnoController.edit(turnoEdit);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
