<%-- 
    Document   : newjsp1
    Created on : 27 Dec 2022, 6:14:28 AM
    Author     : PULE
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

           prefix="security"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>  
<html lang="en">  
    <!--    <head>  
            <title> Bootstrap 4 Input groups Example </title>  
            <meta charset="utf-8">  
            <meta name="viewport" content="width=device-width, initial-scale=1">  
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">  
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>  
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>  
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>  
            <style>  
                .container {  
                    padding: 2rem 0rem;  
                }  
                h2 {  
                    position: relative;  
                    padding: 10;  
                    margin: 10;  
                    font-family: "Raleway", sans-serif;  
                    font-weight: 300;  
                    font-size: 40px;  
                    color: white;  
                    text-align: center;  
                    -webkit-transition: all 0.4s ease 0s;  
                    -o-transition: all 0.4s ease 0s;  
                    transition: all 0.4s ease 0s;  
                }  
                body {  
                    background-size: 400% 400%;  
                    margin: 2rem;  
                    background: linear-gradient(-45deg, #ee7752, #e73c7e, #23a6d5, #23d5ab);  
                    animation: gradient 15s ease infinite;  
                    height: 100vh;  
                }  
                @keyframes gradient {  
                    0% {  
                        background-position: 0% 50%;  
                    }  
                    50% {  
                        background-position: 100% 50%;  
                    }  
                    100% {  
                        background-position: 0% 50%;  
                    }  
                }  
                h4 {  
                    margin: 2rem 0rem 1rem;  
                }  
            </style>  
    
        </head>  
    
        <body>  
            <h2> Edit Tenant </h2>  
            <div class="container">  
                <div class="row">  
                    <div class="col-8">  
                        <form>
                        <div class="input-group mb-3">  
                            <div class="input-group-prepend">  
                                <span class="input-group-text" id="basic-addon1">@</span>  
                            </div>  
                            <input type="text" class="form-control" placeholder="Name" aria-label="Name" aria-describedby="basic-addon1">  
                        </div>  
                        <div class="input-group mb-3">  
                            <input type="text" class="form-control" placeholder="Recipient's username" aria-label="Recipient's username" aria-describedby="basic-addon2">  
                            <div class="input-group-append">  
                                <span class="input-group-text" id="basic-addon2"> @example.com </span>  
                            </div>  
                        </div>  
                        <div class="input-group mb-3">  
                            <div class="input-group-prepend">  
                                <span class="input-group-text"> $ </span>  
                            </div>  
                            <input type="text" class="form-control" aria-label="Amount (to the nearest dollar)">  
                            <div class="input-group-append">  
                                <span class="input-group-text"> .00 </span>  
                            </div>  
                        </div>   
                        <div class="input-group mb-3">  
                            <div class="input-group-prepend">  
                                <span class="input-group-text"> With textarea </span>  
                            </div>  
                            <textarea class="form-control" aria-label="With textarea"> </textarea>  
                        </div>  
                        <div class="input-group mb-3">  
                            <div class="input-group-prepend">  
                                <label class="input-group-text" for="inputGroupSelect01"> Options <label>  
                                        </div>  
                                        <select class="custom-select" id="inputGroupSelect01">  
                                            <option selected> Choose... </option>  
                                            <option value="1"> One </option>  
                                            <option value="2"> Two </option>  
                                            <option value="3"> Three </option>  
                                        </select>  
                                        </div>  
                                        <div class="input-group mb-3">  
                                            <div class="input-group-prepend">  
                                                <span class="input-group-text" id="inputGroupFileAddon01"> <i class="far fa-file-image"> </i> </span>  
                                            </div>  
                                            <div class="custom-file">  
                                                <input type="file" class="custom-file-input" id="inputGroupFile01" aria-describedby="inputGroupFileAddon01">  
                                                <label class="custom-file-label" for="inputGroupFile01"> Choose file </label>  
                                            </div>  
                                        </div> 
                        </form>
                                        </div>  
                                        </div>  
                                        </div>  
                                        </body>  -->




    <!-- Mirrored from iamsrinu.com/bluemoon2.1/calendar.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 01 Aug 2017 10:53:49 GMT -->

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link href="resources/template/css/bootstrap.min.css" rel="stylesheet"
              media="screen">
        <link href="resources/template/css/main.css" rel="stylesheet">
        <link href="resources/template/css/color-picker/minicolors.css"
              rel="stylesheet">
        <link href="resources/template/fonts/icomoon/icomoon.css"
              rel="stylesheet">
        <link href="resources/template/css/wysiwyg-editor/editor.css"
              rel="stylesheet">
        <link href="resources/template/css/datatables/fixedHeader.bs.css"
              rel="stylesheet">
        <link href="resources/template/css/datatables/dataTables.bs.min.css"
              rel="stylesheet">
        <link rel="stylesheet"
              href="resources/template/css/datatables/autoFill.bs.min.css">
        <%--<%@include file="static/header.jsp"%>--%>
    </head>

    <body>
        <%--<%@include file="static/top-header.jsp"%>--%>
        <div class="container-fluid">
            <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
            <%@include file="static/nav.jsp"%>
            <div class="dashboard-wrapper">
                <div class="top-bar clearfix">
                    <div class="row gutter">
                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                            <div class="page-title">
                                <h4>Gestion des Equipes</h4>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"></div>
                    </div>
                </div>
                <div class="main-container">
                    <div class="row gutter">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <div class="panel panel-blue">

                                <div class="panel-heading">
                                    <h4>Liste des Equipes</h4>
                                </div>

                                <div id="menuBarDiv" style="margin-left: 500px;">
                                    <button class="btn btn-primary">
                                        <i class="icon-printer2"></i> Imprimer
                                    </button>
                                    <button class="btn btn-primary" id="openAddModalBtn">
                                        <i class="icon-users3"></i> Nouvelle Equipe
                                    </button>
                                </div>

                                <div class="bar bar-header"></div>
                                <div class="panel-body">

                                    <div class="table-responsive">
                                        <table id="tableTeams"
                                               class="table table-striped table-bordered no-margin">
                                            <thead>
                                                <tr>
                                                    <th class="text-center">Nom</th>
                                                    <th class="text-center">Validateur</th>
                                                    <th class="text-center">Couleur</th>
                                                    <th class="text-center">Statut</th>
                                                    <th class="text-center">Actions</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach var="t" items="${teams}">
                                                <tr>
                                                    <td class="text-center">${t.name }</td>
                                                    <td class="text-center">${t.validateur.firstName}
                                                        ${t.validateur.lastName}</td>
                                                    <td class="text-center"><c:choose>
                                                            
                                                            
                                                    <c:when test="${t.isActif == true }">
                                                        <i class="icon-lens" style="color: #077a07;"></i>
                                                    </c:when>
                                                    <c:when test="${t.isActif == false }">
                                                        <i class="icon-lens" style="color: #c20b0b;"></i>
                                                    </c:when>
                                                </c:choose></td>
                                                <td class="text-center"><a
                                                        href="#update-team-modal_${t.id}" role="button"
                                                        class="btn btn-xs btn-transparent btn-info"
                                                        data-toggle="modal"><i
                                                            class="glyphicon glyphicon-edit" data-placement="bottom"
                                                            title="Editer"></i></a> <a
                                                        href="detailsTeam?id=<c:out value="${t.id}"></c:out>">
                                                        <button class="btn btn-xs btn-transparent btn-info">
                                                            <i class="glyphicon glyphicon-triangle-bottom"
                                                               data-toggle="tooltip" data-placement="bottom"
                                                               title="Voir Détails"></i>
                                                        </button>
                                                    </a><a
                                                        href="desactivateTeam?id=<c:out value="${t.id}"></c:out>">
                                                        <button class="btn btn-xs btn-transparent btn-danger ">
                                                            <i class="glyphicon glyphicon glyphicon-off"
                                                               data-toggle="tooltip" data-placement="bottom"
                                                               title="Désactiver"></i>
                                                        </button>
                                                    </a></td>
                                                </tr>
                                                <div class="modal fade" id="update-team-modal_${t.id}"
                                                     tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                                                     aria-hidden="true">
                                                    <div class="modal-dialog">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <h5>Modification Equipe</h5>
                                                            </div>
                                                            <div class="modal-body">
                                                                <form id="updateTeamForm" enctype="multipart/form-data"
                                                                      method="POST" action="updateTeam">

                                                                    <div class="form-group">
                                                                        <input id="id" type="hidden" name="id"
                                                                               class="form-control" value="${t.id}">
                                                                    </div>

                                                                    <label for="name">Nom </label><span class="req">*
                                                                    </span>
                                                                    <div class="form-group">
                                                                        <div class="input-group">
                                                                            <input type="text" name="name" id="name"
                                                                                   class="form-control-large" value="${t.name }"
                                                                                   required="required" />
                                                                        </div>
                                                                    </div>

                                                                    <label for="color">Couleur</label><span class="req">*
                                                                    </span>
                                                                    <div class="form-group">
                                                                        <input type="text" id="color" name="color"
                                                                               class="form-control demo" style="width: 200px;"
                                                                               data-swatches="#fff|#000|#f00|#0f0|#00f|#ff0|#0ff"
                                                                               value="${t.color}" required="required">
                                                                    </div>

                                                                    <div class="form-group">
                                                                        <label for="validateur">Validateur</label> <span
                                                                            class="req">* </span> <select
                                                                            class="form-control-small" id="validateur"
                                                                            name="validateur" required="required">
                                                                            <option value="${t.validateur.matricule}">${t.validateur.firstName }
                                                                                ${t.validateur.lastName }</option>
                                                                            <c:forEach var="u" items="${users}">
                                                                                <option value="${u.matricule}">${u.firstName}
                                                                                    ${u.lastName}</option>
                                                                            </c:forEach>
                                                                        </select>
                                                                    </div>
                                                                </form>
                                                            </div>
                                                            <div class="modal-footer">
                                                                <a><button type="submit" class="btn btn-info btn-ok" data-dismiss="modal">
                                                                        <i class="glyphicon glyphicon-ok" id="update"></i>Editer
                                                                    </button></a>
                                                                <button type="button" class="btn btn-primary"
                                                                        data-dismiss="modal">
                                                                    <i class="glyphicon glyphicon-remove"></i>Annuler
                                                                </button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal fade" id="add-team-modal" tabindex="-1" role="dialog"
             aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5>Nouvelle Equipe</h5>
                    </div>
                    <div class="modal-body">
                        <form id="addTeamForm" enctype="multipart/form-data" method="POST"
                              action="addTeam">
                            <label for="name">Nom </label><span class="req">* </span>
                            <div class="form-group">
                                <div class="input-group">
                                    <input type="text" name="name" id="name"
                                           class="form-control-large" required="required" />
                                </div>
                            </div>
                            <label for="color">Couleur</label><span class="req">* </span>
                            <div class="form-group">
                                <input type="text" id="color" name="color"
                                       class="form-control demo" style="width: 200px;"
                                       data-swatches="#fff|#000|#f00|#0f0|#00f|#ff0|#0ff"
                                       required="required">
                            </div>
                            <div class="form-group">
                                <label for="validateur">Validateur</label> <span class="req">*
                                </span> <select class="form-control-small" id="validateur"
                                                name="validateur" required="required">
                                    <option value="">-- Sélectionner un validateur --</option>
                                    <c:forEach var="u" items="${users}">
                                        <option value="${u.matricule}">${u.firstName}
                                            ${u.lastName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <a><button type="submit" id="save" class="btn btn-info btn-ok">
                                <i class="glyphicon glyphicon-ok"></i>Créer
                            </button></a>
                        <button type="button" class="btn btn-primary" id="cancelAdd"
                                data-dismiss="modal">
                            <i class="glyphicon glyphicon-remove"></i>Annuler
                        </button>
                    </div>

                </div>
            </div>
        </div>



        <%--<%@include file="static/footer.jsp"%>--%>
        <script src="resources/template/js/jquery.js"></script>
        <script src="resources/template/js/bootstrap.min.js"></script>
        <script src="resources/template/js/scrollup/jquery.scrollUp.js"></script>
        <script src="resources/template/js/sparkline/sparkline.js"></script>
        <script src="resources/template/js/sparkline/custom-sparkline.js"></script>
        <script src="resources/template/js/databars/jquery.databar.js"></script>
        <script src="resources/template/js/databars/custom-databars.js"></script>
        <script src="resources/template/js/datatables/dataTables.min.js"></script>
        <script
        src="resources/template/js/datatables/dataTables.bootstrap.min.js"></script>
        <script src="resources/template/js/datatables/autoFill.min.js"></script>
        <script
        src="resources/template/js/datatables/autoFill.bootstrap.min.js"></script>
        <script src="resources/template/js/datatables/fixedHeader.min.js"></script>
        <script src="resources/template/js/datatables/custom-datatables.js"></script>
        <script src="resources/template/js/fileinput.min.js"></script>
        <script src="resources/template/js/custom.js"></script>
        <script src="resources/template/js/fileinput/fr.js"></script>
        <script src="resources/template/js/jquery.form.js"></script>
        <script src="resources/template/js/color_picker/jscolor.js"></script>
        <script src="resources/template/js/color-picker/minicolors.min.js"></script>
        <script src="resources/template/js/color-picker/custom-colorpicker.js"></script>

        <script>
            $("#filtre").on("change", function () {
                var selected = this.value;
            });

            $('#openAddModalBtn').on('click', function () {
                $('#add-team-modal').modal('toggle');

            });

            $('#cancelAdd').on('click', function () {
                $('#add-team-modal').find("input").val('').end();
                document.getElementById('validateur').selectedIndex = 0;
            });

            $('#save').on('click', function () {

                $('#addTeamForm').ajaxForm({
                    success: function (data) {
                        var res = JSON.parse(data);
                        if (res.code == 1) {
                            $('#add-team-modal').modal('hide');
                            location.reload();
                            $('#add-team-modal').find("input").val('').end();
                        } else {
                            toastr["error"](res.message);
                        }
                    },
                    error: function (error) {
                        console.log(error);
                    }
                }).submit();
            });

            $('#update').on('click', function () {

                $('#updateTeamForm').ajaxForm({
                    success: function (data) {
                        var res = JSON.parse(data);
                        if (res.code == 1) {
                            $('#add-team-modal').modal('hide');
                            location.reload();
                        } else {
                            toastr["error"](res.message);
                        }
                    },
                    error: function (error) {
                        console.log(error);
                    }
                }).submit();
            });
            $('#tableTeams').DataTable({
                "language": {
                    "url": "resources/template/lang/French.json"
                }
            });
        </script>

    </body>

</html>  