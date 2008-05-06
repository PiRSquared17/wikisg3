<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>




	<div id="menuizq">
					<div id="inicio">
						<ul>
							<li><a href="FrontController?mod=1">Portada</a></li>
							<li><a href="FrontController?mod=1">Categorias</a></li>
							<li><a href="FrontController?mod=1">Art&iacute;culos</a></li>
							<li><a href="FrontController?mod=1">Actualidad</a></li>
							<li><a href="FrontController?mod=1">Ayuda</a></li>
						</ul>
					</div>
					<div id="usuario">
						<!-- Aquí irá el login y los datos del usuario -->
						<form action="por determinar">
							<fieldset>
								<legend>Login</legend>
								<label class="inputBlock" for="usuario">Usuario: </label>
								<input class="inputBlock" type="text"id="usuario" name="usuario" size="12">
								<label class="inputBlock" for="pass">Contrase�a: </label>
								<input class="inputBlock" id="pass" type="password" name="pass" size="12">
								<input class="inputBlock" type="submit" value="login">
							</fieldset>
						</form>
					</div>
					<div id="buscador">
						<form action="por determinar">
							<fieldset>
								<legend>
									Buscar 
								</legend>
								<input class="inputBlock" type="text" name="busca" id="busca" size="12">
								<input class="inputBlock" type="submit" title="Buscar" value="Buscar">
							</fieldset>
						</form>
					</div>
				</div>

