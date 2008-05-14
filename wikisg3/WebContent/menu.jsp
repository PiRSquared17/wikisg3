<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>




	<div id="menuizq">
					<div id="inicio">
						<ul>
							<li><a href="FrontController?res=1">Portada</a></li>
							<li><a href="FrontController?res=C1">Categor&iacute;as</a></li>
							<li><a href="FrontController?res=A1">Art&iacute;culos</a></li>
							<li><a href="FrontController?res=A3e">Nuevo art&iacute;culo</a></li>
							<li><a href="FrontController?res=1">Actualidad</a></li>
							<li><a href="FrontController?res=1">Ayuda</a></li>
						</ul>
					</div>
					<div id="usuario">
						<!-- Aquí irá el login y los datos del usuario -->
						<form action="./Login" method="post">
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

