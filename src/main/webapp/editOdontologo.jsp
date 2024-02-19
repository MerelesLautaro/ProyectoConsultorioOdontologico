<%@page import="logica.Odontologo"%>
<%@page import="logica.Horario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>
<%@include file="components/bodyprimero.jsp"%>
<h1>Alta Odontólogos<h1/>
    <% Odontologo odontologo = (Odontologo)request.getSession().getAttribute("editOdontologo");
       List<Horario> listHorarios = (List)request.getSession().getAttribute("listHorarios");
    %>
    <hr>
    <form class="user" action="SvEditOdontologo" method="POST">
        <div class="form-group row">           
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtDni" class="h6 text-dark">DNI</label>
                <input type="text" class="form-control" id="txtDni" name="txtDniOdon"
                       value="<%=odontologo.getDni() %>">
            </div>
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtNombre" class="h6 text-dark">Nombre</label>
                <input type="text" class="form-control" id="txtNombre" name="txtNombreOdon"
                       value="<%=odontologo.getNombre() %>">
            </div>        
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtApellido" class="h6 text-dark">Apellido</label>
                <input type="text" class="form-control" id="txtApellido" name="txtApellidoOdon"
                       value="<%=odontologo.getApellido() %>">
            </div>
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtTelefono" class="h6 text-dark">Teléfono</label>
                <input type="text" class="form-control" id="txtTelefono" name="txtTelefonoOdon"
                       value="<%=odontologo.getTelefono() %>">
            </div>
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtDireccion" class="h6 text-dark">Dirección</label>
                <input type="text" class="form-control" id="txtDireccion" name="txtDireccionOdon"
                       value="<%=odontologo.getDireccion() %>">
            </div>
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtNac" class="h6 text-dark">Fecha Nac.</label>
                <input type="date" class="form-control" id="txtNac" name="txtNacOdon"
                       value="<%=odontologo.getFecha_nac() %>">
            </div>
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtEsp" class="h6 text-dark">Especialidad</label>
                <input type="text" class="form-control" id="txtEsp" name="txtEspecialidadOdon"
                       value="<%=odontologo.getEspecialidad() %>">
            </div>
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtHorario" class="h6 text-dark">Horario</label>               
                <select type="text" class="form-control" id="txtHorario" name="txtHorarioOdon"
                       placeholder="Ingrese su Horario">
                    <% for(Horario horario: listHorarios){ %>
                    <option value="<%=horario.getId_horario() %>"><%=horario.getHorario_inicio() %> a <%=horario.getHorario_fin() %></option>
                    <%}%>
                </select> 
            </div>
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtUsuario" class="h6 text-dark">Usuario</label>
                <input type="text" class="form-control" id="txtUsuario" name="txtUsuarioOdon"
                       value="<%=odontologo.getUsuario().getNombreUsuario() %>">
            </div>
        </div>
        <div style="display: flex; justify-content: center; align-items: center">
            <button class="btn btn-primary btn-user btn-block col-sm-4">
                Editar Odontólogo
            </button>
        </div>
        <hr>
    </form>

<%@include file="components/bodysegundo.jsp"%>
