package logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Odontologo extends Persona implements Serializable {
    //private int id_odontologo;
    private String especialidad;
    
    //Relacion de Odontologo con la lista de turnos. (1 a N)
    @OneToMany(mappedBy="odontologo")
    private List<Turno> listaTurnos;
    //Relacion de Odontologo con su usuario (para el login) (1 a 1)
    @OneToOne
    private Usuario usuario;
    //Relacion de Odontologo con sus horarios (horarios en los que trabaja) (1 a 1)
    @OneToOne
    private Horario horario;


    public Odontologo() {
    }

    public Odontologo(String especialidad, List<Turno> listaTurnos, Usuario usuario, Horario horario, int id, String dni, String nombre, String apellido, String telefono, String direccion, Date fecha_nac) {
        super(id, dni, nombre, apellido, telefono, direccion, fecha_nac);
        this.especialidad = especialidad;
        this.listaTurnos = listaTurnos;
        this.usuario = usuario;
        this.horario = horario;
    }

    

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Turno> getListaTurnos() {
        return listaTurnos;
    }

    public void setListaTurnos(List<Turno> listaTurnos) {
        this.listaTurnos = listaTurnos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    
    
}
