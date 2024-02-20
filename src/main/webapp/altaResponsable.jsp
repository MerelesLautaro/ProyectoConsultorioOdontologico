<%@page import="logica.Responsable"%>
<%@page import="logica.Horario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>
<%@include file="components/bodyprimero.jsp"%>
<h1>Alta Responsables<h1/>
    <% Responsable responsableEdit = (Responsable) request.getSession().getAttribute("editResponsable"); %>
    <hr>
<form id="formulario" class="user" action="SvResponsable" method="POST">
    <div class="form-group row">           
        <div class="col-sm-6 mb-3 mb-sm-0">
            <label for="txtDni" class="h6 text-dark">DNI</label>
            <input type="text" class="form-control" id="txtDni" name="txtDni"
                   placeholder="Ingrese su DNI"  <%if (responsableEdit != null) {%>value="<%=responsableEdit.getDni()%>"<%}%>>
        </div>
        <div class="col-sm-6 mb-3 mb-sm-0">
            <label for="txtNombre" class="h6 text-dark">Nombre</label>
            <input type="text" class="form-control" id="txtNombre" name="txtNombre"
                   placeholder="Ingrese su Nombre" <%if (responsableEdit != null) {%>value="<%=responsableEdit.getNombre()%>"<%}%>>
        </div>        
        <div class="col-sm-6 mb-3 mb-sm-0">
            <label for="txtApellido" class="h6 text-dark">Apellido</label>
            <input type="text" class="form-control" id="txtApellido" name="txtApellido"
                   placeholder="Ingrese su Apellido" <%if (responsableEdit != null) {%>value="<%=responsableEdit.getApellido()%>"<%}%>>
        </div>
        <div class="col-sm-6 mb-3 mb-sm-0">
            <label for="txtTelefono" class="h6 text-dark">Teléfono</label>
            <input type="text" class="form-control" id="txtTelefono" name="txtTelefono"
                   placeholder="Ingrese su Telefono" <%if (responsableEdit != null) {%>value="<%=responsableEdit.getTelefono()%>"<%}%>>
        </div>
        <div class="col-sm-6 mb-3 mb-sm-0">
            <label for="txtDireccion" class="h6 text-dark">Dirección</label>
            <input type="text" class="form-control" id="txtDireccion" name="txtDireccion"
                   placeholder="Ingrese su Dirección" <%if (responsableEdit != null) {%>value="<%=responsableEdit.getDireccion()%>"<%}%>>
        </div>
        <div class="col-sm-6 mb-3 mb-sm-0">
            <label for="txtNac" class="h6 text-dark">Fecha Nac.</label>
            <input type="date" class="form-control" id="txtNac" name="txtNac">
        </div>
        <div class="col-sm-6 mb-3 mb-sm-0">
            <label for="txtRes" class="h6 text-dark">Tipo de responsabilidad</label>
            <input type="text" class="form-control" id="txtRes" name="txtResponsabilidad"
                   placeholder="Ingrese su T. Responsabilidad" <%if (responsableEdit != null) {%>value="<%=responsableEdit.getTipo_responsabilidad()%>"<%}%>>
        </div>
    </div>
    <div style="display: flex; justify-content: space-between; align-items: center;">
        <button class="btn btn-primary btn-user btn-block col-sm-4">
            Register Account
        </button>
        <button id="editarResponsableBtn" class="btn btn-primary btn-user btn-block col-sm-4" type="submit">
            Editar Responsable
        </button>
    </div>
    <hr>
</form>
<div class="card shadow mb-4" style="font-size: 0.5em;">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Tabla de Responsables</h6>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered table-sm" id="dataTable" width="100%" cellspacing="0" style="font-size: 0.8em;">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>DNI</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Teléfono</th>
                        <th>Dirección</th>
                        <th>Fecha Nac.</th>
                        <th>Tipo Responsabilidad</th>
                        <th style="width: 210px">Acción</th>
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
                        <th>Fecha Nac.</th>
                        <th>Tipo Responsabilidad</th>
                        <th style="width: 210px">Acción</th>
                    </tr>
                </tfoot>              
                <% //Traemos la lista de usuarios desde el servelets mediante la session, casteamos al tipo list la respuesta del servelets.
                    List<Responsable> listResponsable = (List)request.getSession().getAttribute("listResponsable"); 
                %>                
                <tbody>                   
                    <%//recorremos la lista de usuarios con un forEach y lo agregamos a nuestra tabla
                        for(Responsable responsable: listResponsable){%>
                    <tr>
                        <td id="id_user"><%=responsable.getId() %></td>
                        <td><%=responsable.getDni() %></td>
                        <td><%=responsable.getNombre() %></td>
                        <td><%=responsable.getApellido() %></td>
                        <td><%=responsable.getTelefono() %></td>
                        <td><%=responsable.getDireccion() %></td>
                        <td><%=responsable.getFecha_nac() %></td>
                        <td><%=responsable.getTipo_responsabilidad()%></td>
                        <td style="display: flex; width: 230px">  
                            <form name="delete" action="SvDeleteResponsable" method="POST"><!-- Llama al Servelets encargado de eliminar -->
                                <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color: red; margin-right: 5px">
                                    <i class="fas fa-solid fa-trash"></i> Eliminar                                   
                                </button>
                                <input type="hidden" name="id" value="<%=responsable.getId() %>"><!-- Obtenemos la ID para el metodo de eliminar -->
                            </form>                          
                            <form name="edit" action="SvEditResponsable" method="GET"><!-- Llama al Servelets encargado de editar -->
                                <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-left: 5px">
                                    <i class="fas fa-pencil-alt"></i> Editar
                                </button>
                                <input type="hidden" name="id" value="<%=responsable.getId() %>"><!-- Obtenemos la ID para el metodo de editar -->
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
        $("#editarResponsableBtn").click(function() {
            $("#formulario").attr("action", "SvEditResponsable");
        });
    });
</script>
<%@include file="components/bodysegundo.jsp"%>
