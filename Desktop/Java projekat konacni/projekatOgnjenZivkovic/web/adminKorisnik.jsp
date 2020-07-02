<%-- 
    Document   : adminFilm
    Created on : Jun 25, 2020, 9:13:46 PM
    Author     : Ognjen Živković
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="includes/adminPanelHeadLinks.jsp"/>
          <c:if test="${korisnik == null || korisnik.nivo == 2}">
            <c:redirect url="index"></c:redirect>
        </c:if>

    </head>
    <header class="main-header">
        <a href="#" class="logo">
            <div class="user-panel">
                <div class="pull-left image">
                    <img style="border-radius:0; " src="img/logo.png"
                         class="img-circle">
                </div>
            </div>
        </a>
        <nav class="navbar navbar-static-top">
            <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button" style="color: #708090;">
                <span class="sr-only">Toggle navigation</span>
            </a>
              <a style="left: 25%;position: relative;width: 8%;" href="Logout" class="header__sign-in">
                <span>Odjavi se</span>
            </a>
        </nav>
    </header>
    <body class="hold-transition skin-blue sidebar-mini">


        <div class="wrapper">
            <aside class="main-sidebar">
                <section class="sidebar">
                    <ul class="sidebar-menu" data-widget="tree">
                        <li class="header">UPRAVLJANJE</li>
                        <li><a href="adminFilm"><i class="fa fa-film"></i> <span>Filmovi</span></a></li>
                        <li><a href="adminKorisnik"><i class="fa fa-users"></i> <span>Korisnici</span></a></li>
                        <li><a href="adminRezervacije"><i class="fa fa-ticket"></i> <span>Rezervacije</span></a></li>
                         <li><a href="adminProjekcije"><i class="fa fa-video-camera"></i> <span>Projekcije</span></a></li>

                    </ul>
                </section>
            </aside>
            <div class="content-wrapper">

                <section class="content-header">
                    <h1>
                        Korisnici
                    </h1>

                    <ol class="breadcrumb">
                        <li><a href="adminFilm.jsp"><i class="fa fa-dashboard"></i> Početna</a></li>
                        <li class="active">Filmovi</li>
                    </ol>
                </section>
                <section class="content">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="box">                           
                                <div class="box-body">
                                    <table id="example1" class="table table-bordered" >

                                        <thead>
                                        <th data-sort-order="desc" >Ime</th>
                                        <th>Prezime</th>
                                        <th>Email</th>
                                        <th>Lozinka</th>
                                        <th>Broj poena</th>
                                        <th>Alati</th>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${korisnici}" var="korisnik">
                                                <tr>
                                                    <td>
                                                        <span class='pull-right'>${korisnik.ime}</span>
                                                    </td>


                                                    <td>
                                                        <span class='pull-right'>${korisnik.prezime}</span>
                                                    </td>

                                                    <td>
                                                        <span class='pull-right'>${korisnik.email}</span>
                                                    </td>

                                                    <td>
                                                        <span class='pull-right'>${korisnik.lozinka}</span>
                                                    </td>

                                                    <td>
                                                        <span class='pull-right'>${korisnik.brojPoena}</span>
                                                    </td>


                                                    <td>
                                                        <a href="#delete" data-id="${korisnik.korisnikId}" data-toggle="modal" class="btn btn-danger btn-sm delete-korisnik btn-flat"><i
                                                                class="fa fa-trash"></i> Obriši</a>
                                                    </td>

                                                </tr>
                                            </c:forEach>
                                        </tbody>

                                    </table>
                                </div>

                            </div>

                        </div>

                    </div>


                    <!-- Delete -->
                    <div class="modal" id="delete">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button style="position: relative;
                                            left: 17%;" type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title" style="position: relative;
                                        left: -80%;"><b>Brisanje...</b></h4>
                                </div>
                                <div class="modal-body">
                                    <form class="form-horizontal" method="POST" action="adminKorisnik">
                                        <input type="hidden" class="korisnikId" name="korisnikId">
                                        <div class="text-center">
                                            <p>Da li ste sigurni da želite da obrišete ovog korisnika?</p>
                                            <h2 class="bold"></h2>
                                        </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default btn-flat pull-left" data-dismiss="modal"><i
                                            class="fa fa-close"></i> Zatvori
                                    </button>
                                    <button type="submit"  class="btn btn-danger btn-flat brisanjeKorisnika" name="delete"><i class="fa fa-trash"></i> Obriši
                                    </button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Delete End -->
                </section>
            </div>

        </div>


        <jsp:include page="includes/adminPanelScripts.jsp"/>
        <c:if test="${korisnikObrisan ==true}">
            <script>toastr.success("Korisnik uspešno obrisan.");</script>
        </c:if>

        <c:if test="${greska == true}">
            <script>toastr.error("Doslo je do greške.");</script>
        </c:if>
       
    </body>
</html>
