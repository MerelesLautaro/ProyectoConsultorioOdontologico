<%@page import="logica.Odontologo"%>
<%@page import="logica.Turno"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>
<%@include file="components/bodyprimero.jsp"%>
<h2>Turnos Registrados</h2>
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Tabla de Turnos</h6>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered table-sm" id="dataTable" width="100%" cellspacing="0">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Atención</th>
                        <th>Fecha del Turno</th>
                        <th>Hora del Turno</th>
                        <th>Odontólogo</th>
                        <th>Paciente</th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th>ID</th>
                        <th>Atención</th>
                        <th>Fecha del Turno</th>
                        <th>Hora del Turno</th>
                        <th>Odontólogo</th>
                        <th>Paciente</th>
                    </tr>
                </tfoot>
                
                <% //Traemos la lista de usuarios desde el servelets mediante la session, casteamos al tipo list la respuesta del servelets.
                   List<Turno> listTurno = (List)request.getSession().getAttribute("listTurno");
                %>                
                <tbody>                   
                    <%//recorremos la lista de usuarios con un forEach y lo agregamos a nuestra tabla
                        for(Turno turno: listTurno){%>
                    <tr>
                        <td id="id_user"><%=turno.getId_turno() %></td>
                        <td><%=turno.getAtencion() %></td>
                        <td><%=turno.getFecha_turno() %></td>
                        <td><%=turno.getHora_turno() %></td>
                        <td><%=turno.getOdontologo().getNombre() %></td>
                        <td><%=turno.getPaciente().getNombre() %> <%=turno.getPaciente().getApellido() %></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </div>
</div>
<hr>

<h2>Lista de Odontólogos</h2>
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Tabla de Odontologos</h6>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>DNI</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Teléfono</th>
                        <th>Dirección</th>
                        <th>Fecha_de_Nac.</th>
                        <th>Especialidad</th>
                        <th>Horario</th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th>ID</th>
                        <th>DNI</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Teléfono</th>
                        <th>Dirección</th>
                        <th>Fecha_de_Nac.</th>
                        <th>Especialidad</th>
                        <th>Horario</th>
                    </tr>
                </tfoot>
                
                <% //Traemos la lista de usuarios desde el servelets mediante la session, casteamos al tipo list la respuesta del servelets.
                    List<Odontologo> listOdonto = (List)request.getSession().getAttribute("listOdonto");                                                            
                %>                
                <tbody>                   
                    <%//recorremos la lista de usuarios con un forEach y lo agregamos a nuestra tabla
                    for(Odontologo odontologo: listOdonto){%>
                    <tr>
                        <td id="id_user"><%=odontologo.getId() %></td>
                        <td><%=odontologo.getDni() %></td>
                        <td><%=odontologo.getNombre() %></td>
                        <td><%=odontologo.getApellido() %></td>
                        <td><%=odontologo.getTelefono() %></td>
                        <td><%=odontologo.getDireccion() %></td>
                        <td><%=odontologo.getFecha_nac() %></td>
                        <td><%=odontologo.getEspecialidad() %></td>
                        <td><%=odontologo.getHorario().getHorario_inicio() %> a <%=odontologo.getHorario().getHorario_fin() %></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@include file="components/bodysegundo.jsp"%>