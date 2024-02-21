package logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Turno implements Serializable {  
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_turno;
    @Temporal(TemporalType.DATE)
    private Date fecha_turno;
    private String hora_turno;
    private String atencion;
    //Relacion con la tabla Odontologo (N a 1) y establecemos la columna que los "une" o FK.
    @ManyToOne
    @JoinColumn(name="fk_odontologo")
    private Odontologo odontologo;
    //Relacion con la tabla Paciente (N a 1) y establecemos la columna que los "une" o FK.
    @ManyToOne
    @JoinColumn(name="fk_paciente")
    private Paciente paciente;
    
    

    public Turno() {
    }

    public Turno(int id_turno, Date fecha_turno, String hora_turno, String atencion) {
        this.id_turno = id_turno;
        this.fecha_turno = fecha_turno;
        this.hora_turno = hora_turno;
        this.atencion = atencion;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public int getId_turno() {
        return id_turno;
    }

    public void setId_turno(int id_turno) {
        this.id_turno = id_turno;
    }

    public Date getFecha_turno() {
        return fecha_turno;
    }

    public void setFecha_turno(Date fecha_turno) {
        this.fecha_turno = fecha_turno;
    }

    public String getHora_turno() {
        return hora_turno;
    }

    public void setHora_turno(String hora_turno) {
        this.hora_turno = hora_turno;
    }

    public String getAtencion() {
        return atencion;
    }

    public void setAtencion(String atencion) {
        this.atencion = atencion;
    }
    
    
}
