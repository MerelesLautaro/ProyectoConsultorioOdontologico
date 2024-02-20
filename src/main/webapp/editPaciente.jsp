<%@page import="logica.Paciente"%>
<%@page import="logica.Responsable"%>
<%@page import="logica.Horario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>
<%@include file="components/bodyprimero.jsp"%>
<h1>Alta Pacientes<h1/>
    <% List<Responsable> listResponsable = (List)request.getSession().getAttribute("listResponsable");
       Paciente paciente = (Paciente)request.getSession().getAttribute("pacienteEdit");
    %>
    <hr>
    <form class="user" action="SvEditPaciente" method="POST">
        <div class="form-group row">           
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtDni" class="h6 text-dark">DNI</label>
                <input type="text" class="form-control" id="txtDni" name="txtDni"
                       value="<%=paciente.getDni() %>">
            </div>
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtNombre" class="h6 text-dark">Nombre</label>
                <input type="text" class="form-control" id="txtNombre" name="txtNombre"
                       value="<%=paciente.getNombre() %>">
            </div>        
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtApellido" class="h6 text-dark">Apellido</label>
                <input type="text" class="form-control" id="txtApellido" name="txtApellido"
                       value="<%=paciente.getApellido() %>">
            </div>
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtTelefono" class="h6 text-dark">Teléfono</label>
                <input type="text" class="form-control" id="txtTelefono" name="txtTelefono"
                       value="<%=paciente.getTelefono()%>">
            </div>
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtDireccion" class="h6 text-dark">Dirección</label>
                <input type="text" class="form-control" id="txtDireccion" name="txtDireccion"
                       value="<%=paciente.getDireccion() %>">
            </div>
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtNac" class="h6 text-dark">Fecha Nac.</label>
                <input type="date" class="form-control" id="txtNac" name="txtNac"
                       value="<%=paciente.getFecha_nac() %>">
            </div>
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtSangre" class="h6 text-dark">Tipo de Sangre</label>
                <input type="text" class="form-control" id="txtSangre" name="txtSangre"
                       value="<%=paciente.getTipo_sangre() %>">
            </div>
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="cmbOS" class="h6 text-dark">Tiene Obra Social</label>               
                <select type="text" class="form-control" id="cmbOS" name="cmbOS">
                    <option value="1">SI</option>
                    <option value="2">NO</option>
                </select> 
            </div>
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtHorario" class="h6 text-dark">Responsable</label>               
                <select type="text" class="form-control" id="txtHorario" name="txtRes"
                       placeholder="Ingrese su Horario">
                    <% for(Responsable responsable: listResponsable){ %>
                    <option value="<%=responsable.getId() %>"><%=responsable.getNombre() %> <%=responsable.getDni() %></option>
                    <%}%>
                </select> 
            </div>
        </div>
        <div style="display: flex; justify-content: center; align-items: center">
            <button class="btn btn-primary btn-user btn-block col-sm-4">
                Editar Paciente
            </button>
        </div>
        <hr>
    </form>

<%@include file="components/bodysegundo.jsp"%>
