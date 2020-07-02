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
                        Projekcije - Koloseum ${trenutniBioskop}
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

                                    <form method="post" action="adminProjekcije" style="display: inline-block;">
                                        <select style="width: 95% !important;" name="bioskopId" class="form-control" onchange="this.form.submit()" id="selectBioskop">
                                            <option selected disabled>Izaberite bioskop</option>
                                            <c:forEach items="${bioskopi}" var="bioskop">

                                                <option value="${bioskop.bioskopId}">Koloseum - ${bioskop.gradNaziv}</option>
                                            </c:forEach>

                                        </select>
                                    </form>
                                    <a href="#addnew" data-toggle="modal" class="btn btn-primary btn-sm btn-flat novaProjekcija"  style="display: inline-block;"><i
                                            class="fa fa-plus"></i> Nova projekcija</a>
                                    <div class="box-header with-border">

                                    </div>
                                    <table id="example1" class="table table-bordered">
                                        <thead>
                                        <th data-sort-order="desc">Film</th>
                                        <th>Broj sale</th>
                                        <th>Vreme početka</th>
                                        <th>Alati</th>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${projekcije}" var="projekcija">
                                                <tr>
                                                    <td>
                                                        <span class='pull-right'>${projekcija.nazivFilma}</span>
                                                    </td>
                                                    <td>
                                                        <span class='pull-right'>${projekcija.brojSale}</span>
                                                    </td>

                                                    <td>
                                                        <span class='pull-right'>${projekcija.vremePocetka}</span>
                                                    </td>
                                                    <td>
                                                        <a href="#delete" data-id="${projekcija.projekcijaId}" data-toggle="modal" class="btn btn-danger btn-sm delete-projekcija btn-flat"><i
                                                                class="fa fa-trash"></i> Obriši</a>
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
                                    <form class="form-horizontal" method="POST" action="adminProjekcije">
                                        <input type="hidden" class="projekcijaId" name="projekcijaId">
                                        <div class="text-center">
                                            <p>Da li ste sigurni da želite da obrišete ovu projekciju?</p>
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

        <!-- Add -->
        <div class="modal" id="addnew">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" style="position: relative;
                                left: 45%;" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" style="left: -50%; position: relative;"><b>Dodavanje nove projekcije</b></h4>
                    </div>
                    <br>
                    <form class="form-horizontal" method="POST" action="adminProjekcije">
                        <div class="form-group">
                            <label for="film" class="col-sm-3 control-label">Film</label>

                            <div class="col-sm-9">
                                <select id="filmSelect" class="form-control" name="film" required>

                                </select>

                            </div>
                        </div>
                        <div class="form-group">
                            <label for="bioskop" class="col-sm-3 control-label">Bioskop</label>
                            <div class="col-sm-9">
                                <select id="bioskopSelect" class="form-control bioskop-select" name="bioskop" required>

                                </select>                                       
                            </div>
                        </div>
                        <div class="form-group" >
                            <label style="padding-right: 0px;" for="brojSale" class="col-sm-3 control-label">Broj sale</label>

                            <div class="col-sm-9">
                                <select id="brojSaleSelect" class="form-control" name="brojSale" required>

                                </select>                                       
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="vremePocetka" class="col-sm-3 control-label">Vreme početka</label>

                            <div class="col-sm-9">
                                <input type="datetime-local" class="form-control" id="vremePocetka" name="vremePocetka" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="cena" class="col-sm-3 control-label">Cena</label>

                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="cena" name="cena" required>
                            </div>
                        </div>

                        <div class="modal-footer">
                            <button type="button" class="btn btn-default btn-flat pull-left" data-dismiss="modal"><i
                                    class="fa fa-close"></i> Zatvori
                            </button>
                            <button type="submit" class="btn btn-primary btn-flat" name="add"><i class="fa fa-save"></i> Sačuvaj
                            </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- Add End -->           
    <jsp:include page="includes/adminPanelScripts.jsp"/>
    <c:if test="${obrisano ==true}">
        <script>toastr.success("Projekcija uspešno obrisana.");</script>
    </c:if>

    <c:if test="${greska == true}">
        <script>toastr.error("Doslo je do greške.");</script>
    </c:if>
    <c:if test="${pogresnaCena == true}">
        <script>toastr.error("Cena mora da bude broj.");</script>
    </c:if>
        
         <c:if test="${uspesnoDodato == true}">
        <script>toastr.success("Uspešno dodata projekcija.");</script>
    </c:if>
    
</body>
</html>
