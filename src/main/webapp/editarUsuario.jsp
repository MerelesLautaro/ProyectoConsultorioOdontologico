<%@page import="logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>
<%@include file="components/bodyprimero.jsp"%>
<h1>Editar Usuarios<h1/>
    <%
        String msjError = (String)request.getSession().getAttribute("msjError");
        Usuario usuario = (Usuario)request.getSession().getAttribute("userEdit");
    %>
    <hr>
    <form class="user" action="SvEditUser" method="POST">
        <div class="form-group row">           
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtDni" class="h6 text-dark">Nombre Usuario</label>
                <input type="text" class="form-control" id="txtNombre" name="txtNombre" value="<%=usuario.getNombreUsuario() %>">
            </div>
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtTelefono" class="h6 text-dark">Rol</label>
                <input type="text" class="form-control" id="txtRol" name="txtRol" value="<%=usuario.getRol() %>">
            </div>    
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtDni" class="h6 text-dark">Contraseña</label>
                <input type="password" class="form-control" id="txtPassword" name="txtPassword" value="<%=usuario.getContrasenia() %>" >
            </div>        
            <div class="col-sm-6 mb-3 mb-sm-0">
                <label for="txtApellido" class="h6 text-dark">Repita su Contraseña</label>
                <input type="password" class="form-control" id="txtPasswordTwo" name="txtPasswordTwo"
                       placeholder="Repita la contraseña a editar">
            </div>
            <%if(msjError!=null){%>
                <div style="text-align: center;" class="col-sm-12 mb-6 mb-sm-0">
                    <label style="font-size: 25px;color: red;"><%= msjError%></label>
                </div>
            <%}%>
        </div>
        <div style="display: flex; justify-content: center; align-items: center">
            <button class="btn btn-primary btn-user btn-block col-sm-6" type="submit">
                Editar Usuario
            </button>
        </div>
        <hr>
    </form>
<%@include file="components/bodysegundo.jsp"%>