<%@page import="logica.Horario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>
<%@include file="components/bodyprimero.jsp"%>
<h1>Alta Odontólogos<h1/>
    <% List<Horario> listHorarios = (List) request.getSession().getAttribute("listHorarios"); %>
    <hr>
    <form class="user" action="SvOdontologo" method="POST">
        <div class="form-group row">           
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtDni" class="h6 text-dark">DNI</label>
                <input type="text" class="form-control" id="txtDni" name="txtDniOdon"
                       placeholder="Ingrese su DNI">
            </div>
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtNombre" class="h6 text-dark">Nombre</label>
                <input type="text" class="form-control" id="txtNombre" name="txtNombreOdon"
                       placeholder="Ingrese su Nombre">
            </div>        
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtApellido" class="h6 text-dark">Apellido</label>
                <input type="text" class="form-control" id="txtApellido" name="txtApellidoOdon"
                       placeholder="Ingrese su Apellido">
            </div>
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtTelefono" class="h6 text-dark">Teléfono</label>
                <input type="text" class="form-control" id="txtTelefono" name="txtTelefonoOdon"
                       placeholder="Ingrese su Telefono">
            </div>
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtDireccion" class="h6 text-dark">Dirección</label>
                <input type="text" class="form-control" id="txtDireccion" name="txtDireccionOdon"
                       placeholder="Ingrese su Dirección">
            </div>
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtNac" class="h6 text-dark">Fecha Nac.</label>
                <input type="date" class="form-control" id="txtNac" name="txtNacOdon"
                       placeholder="Ingrese su Fecha de Nacimiento">
            </div>
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtEsp" class="h6 text-dark">Especialidad</label>
                <input type="text" class="form-control" id="txtEsp" name="txtEspecialidadOdon"
                       placeholder="Ingrese su Especialidad">
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
                       placeholder="Ingrese su Usuario">
            </div>
        </div>
        <div style="display: flex; justify-content: center; align-items: center">
            <button class="btn btn-primary btn-user btn-block col-sm-4">
                Register Account
            </button>
        </div>
        <hr>
    </form>

<%@include file="components/bodysegundo.jsp"%>
