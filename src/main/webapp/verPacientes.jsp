<%@page import="logica.Paciente"%>
<%@page import="logica.Odontologo"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>
<%@include file="components/bodyprimero.jsp"%>
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
                        <th>Tipo de Sangre</th>
                        <th>Obra Social</th>
                        <th>Responsable</th>
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
                        <th>Fecha_de_Nac.</th>
                        <th>Tipo de Sangre</th>
                        <th>Obra Social</th>
                        <th>ID Responsable</th>
                        <th style="width: 210px">Acción</th>
                    </tr>
                </tfoot>
                
                <% //Traemos la lista de usuarios desde el servelets mediante la session, casteamos al tipo list la respuesta del servelets.
                   List<Paciente> listPacientes = (List)request.getSession().getAttribute("listPacientes");                                                          
                %>                
                <tbody>                   
                    <%//recorremos la lista de usuarios con un forEach y lo agregamos a nuestra tabla
                    for(Paciente paciente: listPacientes){%>
                    <tr>
                        <td id="id_user"><%=paciente.getId() %></td>
                        <td><%=paciente.getDni() %></td>
                        <td><%=paciente.getNombre() %></td>
                        <td><%=paciente.getApellido() %></td>
                        <td><%=paciente.getTelefono() %></td>
                        <td><%=paciente.getDireccion() %></td>
                        <td><%=paciente.getFecha_nac() %></td>
                        <td><%=paciente.getTipo_sangre() %></td>
                        <td><%=paciente.isTiene_OS()  %></td>
                        <td><%=paciente.getResponsable().getId() %></td>
                        <td style="display: flex; width: 230px">  
                            <form name="delete" action="SvDeletePaciente" method="POST"><!-- Llama al Servelets encargado de eliminar -->
                                <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color: red; margin-right: 5px">
                                    <i class="fas fa-solid fa-trash"></i> Eliminar                                   
                                </button>
                                <input type="hidden" name="id" value="<%=paciente.getId() %>"><!-- Obtenemos la ID para el metodo de eliminar -->
                            </form>                          
                            <form name="edit" action="SvEditPaciente" method="GET"><!-- Llama al Servelets encargado de editar -->
                                <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-left: 5px">
                                    <i class="fas fa-pencil-alt"></i> Editar
                                </button>
                                <input type="hidden" name="id" value="<%=paciente.getId() %>"><!-- Obtenemos la ID para el metodo de editar -->
                            </form>   
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@include file="components/bodysegundo.jsp"%>