<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">

    <title> Sistema Veterinaria BETA</title>

    <link href="../../static/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../static/css/style.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="../../static/js/html5shiv.min.js"></script>
    <script src="../../static/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<div role="navigation">
    <div class="navbar navbar-inverse">
        <a href="/" class="navbar-brand">VETERINARIA</a>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="nuevo-clientes">INGRESAR CLIENTE</a></li>
                <li><a href="lista-clientes">LISTA DE CLIENTES</a></li>
                <li><a href="lista-mascotas">LISTA DE MASCOTAS</a></li>
                <li><a href="lista-consulta">LISTA DE CONSULTA</a></li>
            </ul>
        </div>
    </div>
</div>

<c:choose>
    <c:when test="${mode == 'MODE_HOME'}">
        <div class="container" id="homeDiv">
            <div class="jumbotron text-center">
                <h1>Bienvenido a Sistema Veterinario</h1>
            </div>
        </div>
    </c:when>
    <c:when test="${mode == 'MODE_LISTA'}">
        <div class="container text-center" id="clienteDiv">
            <h3> Lista Clientes </h3>
            <hr>
            <div class="table-responsive">
                <table class="table table-striped table-bordered text-left">
                    <thead>
                    <tr>
                        <th>
                            Rut
                        </th>

                        <th>
                            Nombre
                        </th>
                        <th>
                            Editar
                        </th>
                        <th>
                            Borrar
                        </th>
                        <th>
                            Agregar Mascota
                        </th>


                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="cliente" items="${listaCliente}">
                        <tr>
                            <td>
                                    ${cliente.rut}
                            </td>

                            <td>
                                    ${cliente.nombre}
                            </td>

                            <td>
                                <a href="actualizar-cliente?rut=${cliente.rut}"><span class="glyphicon glyphicon-pencil"></span></a>
                            </td>
                            <td>
                                <a href="borrar-cliente?rut=${cliente.rut}"><span class="glyphicon glyphicon-trash"></span></a>
                            </td>
                            <td>
                                <a href="nueva-mascota?rut=${cliente.rut}"><span class="glyphicon glyphicon-plus"></span></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

    </c:when>
    <c:when test="${mode == 'MODE_NUEVO' || mode == 'MODE_ACTUALIZAR'}">
        <div class="container text-center">
            <h3> Control Cliente</h3>
            <form class="form-horizontal" method="POST" action="salvar-clientes">
                <div class="form-group">
                    <label class="control-label col-md-3">RUT</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="rut" value="${cliente.rut}">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-3">Nombre</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="nombre" value="${cliente.nombre}">
                    </div>
                </div>

                <div class="form-group">
                    <input type="submit" class="btn btn-primary" value="Agregar">
                </div>
            </form>
        </div>
    </c:when>

    <c:when test="${mode == 'MODE_AGREGARMAS'}">
        <div class="container text-center">
            <h3> Control Mascota</h3>
            <form class="form-horizontal" method="POST" action="salvar-mascota">

                <div class="form-group">
                    <label class="control-label col-md-3">RUT CLIENTE</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="rut" value="${rutCliente}" readonly="readonly">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-3">Nombre</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="nombre">
                    </div>
                </div>

                <div class="form-group">
                    <input type="submit" class="btn btn-primary" value="Agregar">
                </div>
            </form>
        </div>
    </c:when>


    <c:when test="${mode == 'MODE_LISTAMAS'}">
        <div class="container text-center" id="clienteDiv">
            <h3> Lista Mascotas </h3>
            <hr>
            <div class="table-responsive">
                <table class="table table-striped table-bordered text-left">
                    <thead>
                    <tr>
                        <th>
                            ID
                        </th>

                        <th>
                            RUT PROPIETARIO
                        </th>

                        <th>
                            NOMBRE PACIENTE
                        </th>
                        <th>
                            BORRAR
                        </th>
                        <th>
                            AGREGAR CITA
                        </th>

                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="mascota" items="${listaMascota}">
                        <tr>

                            <td>
                                    ${mascota.id}
                            </td>

                            <td>
                                    ${mascota.rut}
                            </td>

                            <td>
                                    ${mascota.nombre}
                            </td>
                            <td>
                                <a href="borrar-mascota?id=${mascota.id}"><span class="glyphicon glyphicon-trash"></span></a>
                            </td>
                            <td>
                                <a href="nueva-consulta?rut=${mascota.rut}"><span class="glyphicon glyphicon-calendar"></span></a>
                            </td>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

    </c:when>

    <c:when test="${mode == 'MODE_AGREGARCONS'}">
        <div class="container text-center">
            <h3> Control Consulta</h3>
            <form class="form-horizontal" method="POST" action="salvar-consulta">
                <div class="form-group">
                    <label class="control-label col-md-3">RUT CLIENTE</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="rut_cliente" value="${rut}" readonly="readonly">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">id Mascota</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" value="${id}" readonly="readonly">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">fecha</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="fecha">
                    </div>
                </div>




                <div class="form-group">
                    <input type="submit" class="btn btn-primary" value="Agregar">
                </div>
            </form>
        </div>
    </c:when>

    <c:when test="${mode == 'MODE_LISTACONS'}">
        <div class="container text-center" id="clienteDiv">
            <h3> Lista Mascotas </h3>
            <hr>
            <div class="table-responsive">
                <table class="table table-striped table-bordered text-left">
                    <thead>
                    <tr>

                        <th>
                           RUT CLIENTE
                        </th>

                        <th>
                            FECHA
                        </th>

                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="consulta" items="${listaConsultas}">
                        <tr>


                            <td>
                                    ${consulta.rut_cliente}
                            </td>

                            <td>
                                    ${consulta.fecha}
                            </td>


                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

    </c:when>



</c:choose>







<script src="../../static/js/jquery-1.11.1.min.js"></script>
<script src="../../static/js/bootstrap.min.js"></script>

</body>

</html>
