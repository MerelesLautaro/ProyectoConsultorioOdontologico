<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>
<%@include file="components/bodyprimero.jsp"%>
<h1>Alta Odontólogos<h1/>
    <hr>
    <form class="user">
        <div class="form-group row">           
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtDni" class="h6 text-dark">DNI</label>
                <input type="text" class="form-control" id="txtDni"
                       placeholder="Ingrese su DNI">
            </div>
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtDni" class="h6 text-dark">Nombre</label>
                <input type="text" class="form-control" id="txtNombre"
                       placeholder="Ingrese su Nombre">
            </div>        
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtApellido" class="h6 text-dark">Apellido</label>
                <input type="text" class="form-control" id="txtApellido"
                       placeholder="Ingrese su Apellido">
            </div>
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtTelefono" class="h6 text-dark">Teléfono</label>
                <input type="text" class="form-control" id="txtTelefono"
                       placeholder="Ingrese su Telefono">
            </div>
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtDireccion" class="h6 text-dark">Dirección</label>
                <input type="text" class="form-control" id="txtDireccion"
                       placeholder="Ingrese su Dirección">
            </div>
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtNac" class="h6 text-dark">Fecha Nac.</label>
                <input type="date" class="form-control" id="txtNac"
                       placeholder="Ingrese su Fecha de Nacimiento">
            </div>
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtEsp" class="h6 text-dark">Especialidad</label>
                <input type="text" class="form-control" id="txtEsp"
                       placeholder="Ingrese su Especialidad">
            </div>
        </div>
        <div style="display: flex; justify-content: center; align-items: center">
            <a href="login.html" class="btn btn-primary btn-user btn-block col-sm-6">
                Register Account
            </a>
        </div>
        <hr>
    </form>

<%@include file="components/bodysegundo.jsp"%>
