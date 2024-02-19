<%@page import="logica.Horario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>
<%@include file="components/bodyprimero.jsp"%>
<h1>Alta Horarios</h1>
<% Horario editHorario = (Horario)request.getSession().getAttribute("editHorario"); %>
<hr>
<form id="formulario" class="user" action="SvHorario" method="POST">
    <div class="form-group row">           
        <div class="col-sm-6 mb-3 mb-sm-0">
            <label for="txtInicio" class="h6 text-dark">Inicio del Horario</label>
            <input type="text" class="form-control" id="txtInicio" name="txtInicio"
                   placeholder="Ingrese inicio del Horario" <% if(editHorario!=null){%> value="<%=editHorario.getHorario_inicio() %>"<%}%>>
        </div>
        <div class="col-sm-6 mb-3 mb-sm-0">
            <label for="txtFin" class="h6 text-dark">Fin del Horario</label>
            <input type="text" class="form-control" id="txtFin" name="txtFin"
                   placeholder="Ingrese fin del Horario" <% if(editHorario!=null){%> value="<%=editHorario.getHorario_fin() %>"<%}%>>
        </div>          
    </div>
    <div style="display: flex; justify-content: space-between; align-items: center;">
        <button class="btn btn-primary btn-user btn-block col-sm-4" type="submit">
            Crear Horario
        </button>
        <button id="editarHorarioBtn" class="btn btn-primary btn-user btn-block col-sm-4" type="submit">
            Editar Horario
        </button>
    </div>
    <hr>
</form>

<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Tabla de Horarios</h6>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Inicio del Horario</th>
                        <th>Fin del Horario</th>
                        <th style="width: 210px">Acción</th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th>ID</th>
                        <th>Inicio del Horario</th>
                        <th>Fin del Horario</th>
                        <th style="width: 210px">Acción</th>
                    </tr>
                </tfoot>
                
                <% //Traemos la lista de usuarios desde el servelets mediante la session, casteamos al tipo list la respuesta del servelets.
                   List<Horario> listHorarios = (List)request.getSession().getAttribute("listHorarios");
                %>                
                <tbody>                   
                    <%//recorremos la lista de usuarios con un forEach y lo agregamos a nuestra tabla
                        for(Horario horario: listHorarios){%>
                    <tr>
                        <td id="id_user"><%=horario.getId_horario() %></td>
                        <td><%=horario.getHorario_inicio() %></td>
                        <td><%=horario.getHorario_fin() %></td>
                        <td style="display: flex; width: 230px">  
                            <form name="delete" action="SvDeleteHorario" method="POST"><!-- Llama al Servelets encargado de eliminar -->
                                <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color: red; margin-right: 5px">
                                    <i class="fas fa-solid fa-trash"></i> Eliminar                                   
                                </button>
                                <input type="hidden" name="id" value="<%=horario.getId_horario() %>"><!-- Obtenemos la ID para el metodo de eliminar -->
                            </form>                          
                            <form name="edit" action="SvEditHorario" method="GET"><!-- Llama al Servelets encargado de editar -->
                                <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-left: 5px">
                                    <i class="fas fa-pencil-alt"></i> Editar
                                </button>
                                <input type="hidden" name="id" value="<%=horario.getId_horario() %>"><!-- Obtenemos la ID para el metodo de editar -->
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
        $("#editarHorarioBtn").click(function() {
            $("#formulario").attr("action", "SvEditHorario");
        });
    });
</script>
<%@include file="components/bodysegundo.jsp"%>