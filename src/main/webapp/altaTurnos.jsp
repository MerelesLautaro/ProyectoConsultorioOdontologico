<%@page import="logica.Turno"%>
<%@page import="logica.Paciente"%>
<%@page import="logica.Odontologo"%>
<%@page import="logica.Horario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>
<%@include file="components/bodyprimero.jsp"%>
<h1>Alta Turnos<h1/>
    <% List<Odontologo> listOdontologo = (List) request.getSession().getAttribute("listOdontologo");
       List<Paciente> listPaciente = (List) request.getSession().getAttribute("listPaciente");
       Turno turnoEdit = (Turno)request.getSession().getAttribute("turnoEdit");
        %>
    <hr>
    <form id="formulario" class="user" action="SvTurno" method="POST">
        <div class="form-group row">           
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtAtencion" class="h6 text-dark">Atención</label>
                <input type="text" class="form-control" id="txtAtencion" name="txtAtencion"
                       placeholder="Detalle la atención a recibir" <%if(turnoEdit!=null){ %>value="<%=turnoEdit.getAtencion() %>"<%}%>>
            </div>
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtFecha" class="h6 text-dark">Fecha del Turno</label>
                <input type="date" class="form-control" id="txtFecha" name="txtFecha">
            </div>        
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtHora" class="h6 text-dark">Hora del turno</label>
                <input type="text" class="form-control" id="txtHora" name="txtHora"
                       placeholder="Ingrese la Hora del turno" <%if(turnoEdit!=null){ %>value="<%=turnoEdit.getHora_turno() %>"<%}%>>
            </div>
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtHorario" class="h6 text-dark">Odontólogo</label>               
                <select type="text" class="form-control" id="txtHorario" name="txtOdontologo">
                    <% for(Odontologo odontologo : listOdontologo){ %>
                    <option value="<%=odontologo.getId() %>"><%=odontologo.getNombre() %></option>
                    <%}%>
                </select> 
            </div>
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtHorario" class="h6 text-dark">Paciente</label>               
                <select type="text" class="form-control" id="txtHorario" name="txtPaciente">
                    <% for(Paciente paciente : listPaciente){ %>
                    <option value="<%=paciente.getId() %>"><%=paciente.getNombre() %> <%=paciente.getApellido() %></option>
                    <%}%>
                </select> 
            </div>
        </div>
        <div style="display: flex; justify-content: space-between; align-items: center">
            <button class="btn btn-primary btn-user btn-block col-sm-4">
                Registrar Turno
            </button>
            <button id="editarTurnoBtn" class="btn btn-primary btn-user btn-block col-sm-4" type="submit">
                Editar Horario
            </button>
        </div>
        <hr>
    </form>

<div class="card shadow mb-4" style="font-size: 0.5em;" >
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Tabla de Turnos</h6>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered table-sm" id="dataTable" width="100%" cellspacing="0" style="font-size: 0.8em;">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Atención</th>
                        <th>Fecha del Turno</th>
                        <th>Hora del Turno</th>
                        <th>Odontólogo</th>
                        <th>Paciente</th>
                        <th style="width: 210px">Acción</th>
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
                        <th style="width: 210px">Acción</th>
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
                        <td style="display: flex; width: 230px">  
                            <form name="delete" action="SvDeleteTurno" method="POST"><!-- Llama al Servelets encargado de eliminar -->
                                <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color: red; margin-right: 5px">
                                    <i class="fas fa-solid fa-trash"></i> Eliminar                                   
                                </button>
                                <input type="hidden" name="id" value="<%=turno.getId_turno() %>"><!-- Obtenemos la ID para el metodo de eliminar -->
                            </form>                          
                            <form name="edit" action="SvEditTurno" method="GET"><!-- Llama al Servelets encargado de editar -->
                                <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-left: 5px">
                                    <i class="fas fa-pencil-alt"></i> Editar
                                </button>
                                <input type="hidden" name="id" value="<%=turno.getId_turno() %>"><!-- Obtenemos la ID para el metodo de editar -->
                            </form>   
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $(document).ready(function() {
        $("#editarTurnoBtn").click(function() {
            $("#formulario").attr("action", "SvEditTurno");
        });
    });
</script>
<%@include file="components/bodysegundo.jsp"%>
