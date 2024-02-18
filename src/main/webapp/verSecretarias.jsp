<%@page import="logica.Secretaria"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>
<%@include file="components/bodyprimero.jsp"%>
<!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Tabla de Secretarias</h6>
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
                        <th>Sector</th>
                        <th>Usuario</th>
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
                        <th>Sector</th>
                        <th>Usuario</th>
                        <th style="width: 210px">Acción</th>
                    </tr>
                </tfoot>
                
                <% //Traemos la lista de usuarios desde el servelets mediante la session, casteamos al tipo list la respuesta del servelets.
                    List<Secretaria> listSecretaria = (List)request.getSession().getAttribute("listSecretaria");                                                            
                %>                
                <tbody>                   
                    <%//recorremos la lista de usuarios con un forEach y lo agregamos a nuestra tabla
                    for(Secretaria secretaria: listSecretaria){%>
                    <tr>
                        <td id="id_user"><%=secretaria.getId() %></td>
                        <td><%=secretaria.getDni() %></td>
                        <td><%=secretaria.getNombre() %></td>
                        <td><%=secretaria.getApellido() %></td>
                        <td><%=secretaria.getTelefono() %></td>
                        <td><%=secretaria.getDireccion() %></td>
                        <td><%=secretaria.getFecha_nac() %></td>
                        <td><%=secretaria.getSector() %></td>
                        <td><%=secretaria.getUsuario().getNombreUsuario() %></td>
                        <td style="display: flex; width: 230px">  
                            <form name="delete" action="SvDeleteSecretaria" method="POST"><!-- Llama al Servelets encargado de eliminar -->
                                <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color: red; margin-right: 5px">
                                    <i class="fas fa-solid fa-trash"></i> Eliminar                                   
                                </button>
                                <input type="hidden" name="id" value="<%=secretaria.getId() %>"><!-- Obtenemos la ID para el metodo de eliminar -->
                            </form>                          
                            <form name="edit" action="" method="GET"><!-- Llama al Servelets encargado de editar -->
                                <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-left: 5px">
                                    <i class="fas fa-pencil-alt"></i> Editar
                                </button>
                                <input type="hidden" name="id"><!-- Obtenemos la ID para el metodo de editar -->
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