package persistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Horario;
import logica.Odontologo;
import logica.Secretaria;
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

}
