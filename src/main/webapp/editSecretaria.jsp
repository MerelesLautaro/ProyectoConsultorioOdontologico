<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="logica.Secretaria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>
<%@include file="components/bodyprimero.jsp"%>
<h1>Editar Secretaria<h1/>
    <% Secretaria secretaria = (Secretaria)request.getSession().getAttribute("editSecretaria"); 
    %>
    <hr>
    <form class="user" action="SvEditSecretaria" method="POST">
        <div class="form-group row">           
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtDni" class="h6 text-dark">DNI</label>
                <input type="text" class="form-control" id="txtDni" name="txtDni" value="<%=secretaria.getDni() %>">
            </div>
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtNombre" class="h6 text-dark">Nombre</label>
                <input type="text" class="form-control" id="txtNombre" name="txtNombre"
                       value="<%=secretaria.getNombre() %>">
            </div>        
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtApellido" class="h6 text-dark">Apellido</label>
                <input type="text" class="form-control" id="txtApellido" name="txtApellido"
                       value="<%=secretaria.getApellido() %>">
            </div>
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtTelefono" class="h6 text-dark">Teléfono</label>
                <input type="text" class="form-control" id="txtTelefono" name="txtTelefono"
                       value="<%=secretaria.getTelefono() %>">
            </div>
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtDireccion" class="h6 text-dark">Dirección</label>
                <input type="text" class="form-control" id="txtDireccion" name="txtDireccion"
                       value="<%=secretaria.getDireccion() %>">
            </div>
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtNac" class="h6 text-dark">Fecha Nac.</label>
                <input type="date" class="form-control" id="txtNac" name="txtNac"
                       value="<%=secretaria.getFecha_nac() %>">
            </div>
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtEsp" class="h6 text-dark">Sector</label>
                <input type="text" class="form-control" id="txtEsp" name="txtSector"
                       value="<%=secretaria.getSector() %>">
            </div>
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtEsp" class="h6 text-dark">Usuario</label>
                <input type="text" class="form-control" id="txtEsp" name="txtUsuario"
                       value="<%=secretaria.getUsuario().getNombreUsuario() %>">
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
