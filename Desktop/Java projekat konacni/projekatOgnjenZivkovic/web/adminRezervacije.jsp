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
                        Rezervacije
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
                                    <table id="example1" class="table table-bordered">

                                        <thead>
                                        <th data-sort-order="desc" >Email korisnika</th>
                                        <th>Film</th>
                                        <th>Vreme početka</th>
                                        <th>Bioskop</th>
                                        <th>Broj sale</th>
                                        <th>Rezervisana sedišta</th>
                                        <th>Cena</th>
                                        <th>Status</th>
                                        <th>Alati</th>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${rezervacije}" var="rezervacija">
                                                <tr>
                                                    <td>
                                                        <span class='pull-right'>${rezervacija.email}</span>
                                                    </td>


                                                    <td>
                                                        <span class='pull-right'>${rezervacija.filmNaziv}</span>
                                                    </td>

                                                    <td>
                                                        <span class='pull-right'>${rezervacija.vremePocetka}</span>
                                                    </td>

                                                    <td>
                                                        <span class='pull-right'>Koloseum - ${rezervacija.bioskopGradNaziv}</span>
                                                    </td>
                                                    
                                                     <td>
                                                        <span class='pull-right'>${rezervacija.brojSale}</span>
                                                    </td>
                                                    
                                                     <td>
                                                         
                                                         <span class='pull-right'><c:forEach items="${rezervacija.sedista}" var="sediste" varStatus="loop">${sediste}<c:if test="${!loop.last}">,</c:if></c:forEach></span>
                                                    </td>
                                                    
                                                       <td>
                                                        <span class='pull-right'>${rezervacija.cena}</span>
                                                    </td>


                                                    <td>
                                                        <c:if test="${rezervacija.status == 'Aktivna'}">
                                                        <span data-id="${rezervacija.rezervacijaId}" class='label status label-success'>${rezervacija.status}</span>
                                                        </c:if>
                                                         <c:if test="${rezervacija.status == 'Preuzeta karta'}">
                                                        <span data-id="${rezervacija.rezervacijaId}" class='label status label-warning'>${rezervacija.status}</span>
                                                        </c:if>
                                                        <c:if test="${rezervacija.status == 'Istekla rezervacija'}">
                                                        <span data-id="${rezervacija.rezervacijaId}" class='label status label-danger'>${rezervacija.status}</span>
                                                        </c:if>
                                                    </td>


                                                    <td>
                                                        <a href="#delete" data-id="${rezervacija.rezervacijaId}" data-toggle="modal" class="btn btn-danger btn-sm delete-rezervacija btn-flat"><i
                                                                class="fa fa-trash"></i> Obriši</a>
                                                                <c:if test="${rezervacija.status == 'Aktivna'}">
                                                            <a href="" data-status="${rezervacija.rezervacijaId}" class="btn btn-info btn-sm info btn-flat promenaStatusa"><i
                                                                    class="fa fa-info"></i> Promeni status</a>
                                                            </c:if>

                                                        </button>
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
                                    <form class="form-horizontal" method="POST" action="adminRezervacije">
                                        <input type="hidden" class="rezervacijaId" name="rezervacijaId">
                                        <div class="text-center">
                                            <p>Da li ste sigurni da želite da obrišete ovu rezervaciju?</p>
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
        <c:if test="${obrisano ==true}">
            <script>toastr.success("Rezervacija uspešno obrisana.");</script>
        </c:if>

        <c:if test="${greska == true}">
            <script>toastr.error("Doslo je do greške.");</script>
        </c:if>
       
    </body>
</html>
